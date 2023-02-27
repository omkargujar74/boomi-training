package com.boomi.java8features;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Base64EncodingDecoding {
    public static void main(String[] args) {
        // Basic.............
        final String data = "This is new feature of Java8....";
        final String Base64EncodingDecodingInJava = "https://youtu.be/MLad3kMLJug";

        byte[] encodedData = Base64.getEncoder().encode(data.getBytes(StandardCharsets.UTF_8));
        System.out.println("Encoded Data = " + Arrays.toString(encodedData));

        byte[] decodedArray = Base64.getDecoder().decode(encodedData);
        String decodedData = new String(decodedArray, StandardCharsets.UTF_8);
        System.out.println("Decoded Data = " + decodedData);

        // URL................
        byte[] urlEncodedData = Base64.getUrlEncoder().encode(Base64EncodingDecodingInJava.getBytes(StandardCharsets.UTF_8));
        System.out.println("URL Encoded Data = " + Arrays.toString(urlEncodedData));

        byte[] urlDecodedArray = Base64.getUrlDecoder().decode(urlEncodedData);
        String urlDecodedData = new String(urlDecodedArray, StandardCharsets.UTF_8);
        System.out.println("URL Decoded Data = " + urlDecodedData);

        // MIME...................
        byte[] mimeEncodedData = Base64.getMimeEncoder().encode(data.getBytes(StandardCharsets.UTF_8));
        System.out.println("MIME Encoded Data = " + Arrays.toString(mimeEncodedData));

        byte[] mimeDecodedArray = Base64.getMimeDecoder().decode(mimeEncodedData);
        String mimeDecodedData = new String(mimeDecodedArray, StandardCharsets.UTF_8);
        System.out.println("MIME Decoded Data = " + mimeDecodedData);


    }
}