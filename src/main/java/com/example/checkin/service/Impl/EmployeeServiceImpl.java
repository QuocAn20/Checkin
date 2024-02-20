package com.example.checkin.service.Impl;

import com.example.checkin.mapper.EmployeeMapper;
import com.example.checkin.mapper.UserMapper;
import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.EmployeeResponse;
import com.example.checkin.model.response.ImportResponse;
import com.example.checkin.model.response.UserResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IEmployeeService;
import com.google.common.base.Strings;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getEmployee(EmployeeRequest request) {
        try {
            List<EmployeeResponse> result;
            if (request.getRole() != null) {
                result = mapper.getEmployeeByRole(request);
            } else {
                result = mapper.getEmployee(request);
            }

            int count = mapper.countEmployee(request);

            if (result != null) {
                return new BaseResponse(result, count, "0", "Get Successfully");
            }else {
                return new BaseResponse("1", "Get Failed");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("-1", "Failed");
        }
    }

    @Override
    public BaseResponse getAllEmployee(EmployeeRequest request) {
        try {
            List<EmployeeResponse> result = mapper.getAll();

            if (!result.isEmpty()) {
                return new BaseResponse(result, "0", "Get All Successfully");
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Get All Failed");
        }
        return new BaseResponse("-1", "Failed");
    }

    @Override
    public BaseResponse updateEmployee(EmployeeRequest request) {
        try {
            int result = mapper.update(request);

            if (result > 0) {
                return new BaseResponse(request, "0", "Update Successfully");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Update Failed");
        }
        return new BaseResponse("-1", "Failed");
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
            return new BaseResponse("1", "Delete Failed");
        }
        return new BaseResponse("-1", "Failed");
    }

    @Override
    public BaseResponse upload(MultipartFile file) {
        ImportResponse upload = new ImportResponse();
        List<EmployeeRequest> listSuccess = new ArrayList<>();
        List<Map<String, Object>> listError = new ArrayList<>();

        try {
            int index = 0;
            StreamingReader reader = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).sheetIndex(0)
                    .read(file.getInputStream());
            Iterator<Row> rowIterator = reader.iterator();
            Row row = rowIterator.next(); // Bỏ qua dòng đầu tiên (HEADER)
            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                Cell name = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell dob = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell gender = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell phone = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell nationalId = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell unit = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell room = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell position = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell job = row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell email = row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell status = row.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell userName = row.getCell(11, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell password = row.getCell(12, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

//                String code = "EMP-";
//                int getId = mapper.getId() + index;
//                String pad = commonService.padLeft(String.valueOf(getId), 4, "0");

                EmployeeRequest eRequest = new EmployeeRequest();
//                eRequest.setCode(code + pad);
                eRequest.setName(name.getStringCellValue());
                eRequest.setDob(dob.getStringCellValue());
                eRequest.setGender(gender.getStringCellValue());
                eRequest.setPhone(phone.getStringCellValue());
                eRequest.setNationalId(nationalId.getStringCellValue());
                eRequest.setUnit(unit.getStringCellValue());
                eRequest.setRoom(room.getStringCellValue());
                eRequest.setPosition(position.getStringCellValue());
                eRequest.setJob(job.getStringCellValue());
                eRequest.setEmail(email.getStringCellValue());
                eRequest.setStatus(status.getStringCellValue());
                eRequest.setUserName(userName.getStringCellValue());
                eRequest.setPassword(password.getStringCellValue());

                listSuccess.add(eRequest);
                index++;
            }

            upload.setListSuccess(listSuccess);
            upload.setListError(listError);

            if(!listSuccess.isEmpty()){
                return new BaseResponse(upload, "0", "Upload SUCCESS");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Upload Fail");
        }
        return new BaseResponse("-1", "Fail");
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

            UserResponse checkUsernameExist = userMapper.checkUsernameExisted(request.getUserName());
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
                return new BaseResponse(request, "0", "Create Successfully");
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("1", "Create Failed");
        }
        return new BaseResponse("-1", "Failed");
    }
}
