package com.example.checkin.service.Impl;

import com.example.checkin.mapper.UserMapper;
import com.example.checkin.model.request.UserRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.UserResponse;
import com.example.checkin.service.EmailBasicService;
import com.example.checkin.service.IUserService;
import com.example.checkin.utils.GenerateUtil;
import com.google.common.base.Strings;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private EmailBasicService emailBasicService;

    @Override
    public BaseResponse createUser(UserRequest request) {
        try {
            if (request == null || Strings.isNullOrEmpty(request.getName())
                    || Strings.isNullOrEmpty(request.getUserName())
                    || Strings.isNullOrEmpty(request.getPassword())) {
                return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Fields is required");
            }

            String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(10));
            request.setPassword(hashedPassword);
            return null;
        } catch (Exception e) {
            return new BaseResponse("1", "Failure");
        }
    }

    @Override
    public BaseResponse forgotPassword(UserRequest request) {
        try {
            String host = "smtp.gmail.com";
            String port = "465";
            String userName = "quocan17102000@gmail.com";
            String password = "zogsxqzztaexmzpf";

            if(request.getUserName().isEmpty() || request.getEmail().isEmpty()){
                return new BaseResponse(HttpStatus.BAD_REQUEST.name(), "Email or user id are required");
            }
//            request.setUserName(request.getUserName().toUpperCase());
            int checkExistedUser = mapper.checkExistedUser(request.getUserName());
            if (checkExistedUser == 0) {
                return new BaseResponse(HttpStatus.BAD_REQUEST.name(), "Người dùng không tồn tại");
            }

            int checkEmailForUser = mapper.checkExistedEmail(request.getEmail());
            if (checkEmailForUser == 0) {
                return new BaseResponse(HttpStatus.BAD_REQUEST.name(), "Something was wrong with email");
            }

            String passGenRandom = GenerateUtil.generateNumber(6);
            String hashedPassword = BCrypt.hashpw(passGenRandom, BCrypt.gensalt(10));
            request.setNewPassword(hashedPassword);

            String userId = request.getUserName();
            String toAddress = request.getEmail();
            String subject = "Hệ thống AI-CHECKIN - CẤP LẠI MẬT KHẨU";
            String htmlContent = getEmailTemplate(userId, passGenRandom);

            int update = mapper.updateUserPasswordWithUSName(request);
            if (update > 0) {
                // send mail
                emailBasicService.sendHtmlEmail(host, port, userName, password, toAddress, subject, htmlContent);
                return new BaseResponse(HttpStatus.OK.name(), "Updating password is successful");
            }
            return new BaseResponse(HttpStatus.BAD_REQUEST.name(), "Updating password is failure");

        } catch (Exception e){
            e.fillInStackTrace();
            return new BaseResponse(HttpStatus.BAD_REQUEST.name(), "fail");
        }
    }

    private String getEmailTemplate(String userId, String passGenRandom) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <style>\n" +
                "    body{margin:0;padding:0;font-family:'Segoe UI',Tahoma,Geneva,Verdana,sans-serif;background-color:#f5f5f5}#email-template{max-width:600px;margin:20px auto;border:1px solid #ddd;border-radius:10px;overflow:hidden}#header{background-color:#fff;text-align:center;padding:20px;color:#333;box-shadow:0 2px 5px rgba(0,0,0,0.1)}#content{background-color:#f5f5f5;padding:20px;color:#333}#content h2{font-size:1.5em;margin-bottom:10px}#content ul{list-style-type:none;padding:0;margin:0}#content li{margin-bottom:5px}#footer{background-color:#4CAF50;text-align:center;padding:10px;color:#fff}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"email-template\">\n" +
                "    <div id=\"header\">\n" +
                "      <img src=\"https://i.imgur.com/rafTBMf.png\" alt=\"Logo\" width=\"180\">\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "      <h2>THÔNG TIN ĐĂNG NHẬP</h2>\n" +
                "      <ul>\n" +
                "        <li>Tài khoản: " + userId + "</li>\n" +
                "        <li>Mật khẩu: " + passGenRandom + "</li>\n" +
                "      </ul>\n" +
                "      <p>VUI LÒNG KHÔNG CUNG CẤP MẬT KHẨU CHO NGƯỜI KHÁC!</p>\n" +
                "    </div>\n" +
                "    <div id=\"footer\">\n" +
                "      <p>Ai.Checkin 2024</p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
    }

    @Override
    public BaseResponse updateUserPassword(UserRequest request) {
        try {
            UserResponse response = mapper.getUser(request);
            if (BCrypt.checkpw(request.getPassword(), response.getPassword())) {
                String hashedPassword = BCrypt.hashpw(request.getNewPassword(), BCrypt.gensalt(10));
                request.setNewPassword(hashedPassword);

                int result = mapper.updateUserPassword(request);

                if (result > 0) {
                    return new BaseResponse(result, "0", "update successfully");
                }
            }
        } catch (Exception e) {
            return new BaseResponse("-1", "fail");
        }
        return new BaseResponse("1", "update fail");
    }

    @Override
    public UserResponse validateUser(String userName, String password) throws AuthException {
        try {
            UserResponse user = mapper.finAccountByUsername(userName);

            if (!BCrypt.checkpw(password, user.getPassword())) {
                return null;
            }
            user.setPassword(null);
            return user;

        } catch (EmptyResultDataAccessException e) {
            throw new AuthException("Invalid username/password");
        }
    }
}
