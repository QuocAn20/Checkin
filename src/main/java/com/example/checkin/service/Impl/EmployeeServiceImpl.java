package com.example.checkin.service.Impl;

import com.example.checkin.mapper.EmployeeMapper;
import com.example.checkin.mapper.RoleMapper;
import com.example.checkin.mapper.UserMapper;
import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.EmployeeResponse;
import com.example.checkin.model.response.UserResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IEmployeeService;
import com.google.common.base.Strings;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getEmployee(EmployeeRequest request) {
        try {
            List<EmployeeResponse> result = new ArrayList<>();
            if (request.getRole() != null) {
                result = mapper.getEmployeeByRole(request);
            } else {
                result = mapper.getEmployee(request);
            }

            for (EmployeeResponse item : result) {
                List<String> listRoleOfEmployee = roleMapper.get(item.getId());
                if (listRoleOfEmployee != null) {
                    item.setRole(listRoleOfEmployee);
                }
            }
            int count = mapper.countEmployee(request);

            if (!result.isEmpty()) {
                return new BaseResponse(result, count, "0", "Get Successfully");
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Failed");
        }
        return new BaseResponse("1", "Failed");
    }

    @Override
    public BaseResponse getAllEmployee(EmployeeRequest request) {
        try {
            List<EmployeeResponse> result = mapper.getAll();

            if (!result.isEmpty()) {
                return new BaseResponse(result, "0", "Get Successfully");
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Failed");
        }
        return new BaseResponse("1", "Failed");
    }

    @Override
    public BaseResponse updateEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            int deleteOldRole = roleMapper.delete(request.getId());
            int result = mapper.update(request);

            if (result > 0) {
                EmployeeResponse roleResult = roleMapper.create(request);
                return new BaseResponse(request, "0", "Update Successfully");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Failed");
        }
        return new BaseResponse("1", "Failed");
    }

    @Override
    public BaseResponse deleteEmployee(EmployeeRequest request) {
        try {
            int result = mapper.delete(request);

            if (result > 0) {
                return new BaseResponse(request, "0", "Delete Successfully");
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Failed");
        }
        return new BaseResponse("1", "Failed");
    }

    @Override
    public BaseResponse createEmployee(EmployeeRequest request) {
        int index = 0;
        try {
            if (request == null || Strings.isNullOrEmpty(request.getName())
                    || Strings.isNullOrEmpty(request.getUserName())
                    || Strings.isNullOrEmpty(request.getPassword())) {
                return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Fiels is requried");
            }

            UserResponse checkUsernameExist = userMapper.checkUsernameExistion(request.getUserName());
            if (checkUsernameExist != null) {
                return new BaseResponse("1", "Username already in use");
            }

            String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(10));
            request.setPassword(hashedPassword);

            UserResponse account = userMapper.createEmployeeAccount(request);

            if (account == null) {
                return new BaseResponse("1", "Create failed");
            }
            request.setAccountId(account.getId());

            String code = "EMP-";
            int getId = mapper.getId() + index;
            String pad = commonService.padLeft(String.valueOf(getId), 4, "0");
            request.setCode(code + pad);

            EmployeeResponse result = mapper.create(request);
            if (result != null) {
                request.setId(result.getId());
                EmployeeResponse roleResult = roleMapper.create(request);
                if (roleResult != null) {
                    return new BaseResponse(request, "0", "Create Successfully");
                }
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Failed");
        }
        return new BaseResponse("1", "Failed");
    }
}
