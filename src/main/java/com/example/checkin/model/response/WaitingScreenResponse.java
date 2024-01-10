package com.example.checkin.model.response;

import lombok.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaitingScreenResponse {
    private String id;
    private String code;
    private String showType;
    private String notification;
    private String status;
    private String note;
    private String contentFile;
    private byte[] contentFileByte;

    public String getContentFile() throws Exception {
        return decompress(contentFileByte);
    }

    public byte[] getContentFileByte() throws Exception{
        return compress(contentFile);
    }

    public static byte[] compress(String str) throws Exception {
        if (str == null || str.isEmpty()) {
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
