package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequest extends Paging {
    private String id;
    private String code;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String nationalId;
    private String imgNationalId;
    private byte[] imgNationalIdFile;
    private String unit;
    private String room;
    private String position;
    private String job;
    private String email;
    private String imgProfile;
    private byte[] imgProfileFile;
    private List<String> role;
    private String status;

    //    create account
    private String accountId;
    private String password;
    private String userName;
    private String roleCode;

    public String getImgNationalId() throws Exception {
        return decompress(imgNationalIdFile);
    }

    public byte[] getImgNationalIdFile() throws Exception {
        return compress(imgNationalId);
    }

    public String getImgProfile() throws Exception {
        return decompress(imgProfileFile);
    }

    public byte[] getImgProfileFile() throws Exception {
        return compress(imgProfile);
    }

    public static byte[] compress(String str) throws Exception {
        if (str == null || str.length() == 0) {
            return null;
        }
        System.out.println("String length : " + str.length());
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str.getBytes(StandardCharsets.UTF_8));
        gzip.close();

        return obj.toByteArray();
    }

    public static String decompress(byte[] str) throws Exception {
        if (str == null) {
            return null;
        }

        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(str));
        BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8));
        String outStr = "";
        String line;
        while ((line = bf.readLine()) != null) {
            outStr += line;
        }
        System.out.println("Output String lenght : " + outStr.length());
        return outStr;
    }
}
