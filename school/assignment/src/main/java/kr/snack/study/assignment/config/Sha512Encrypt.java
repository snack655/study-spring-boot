package kr.snack.study.assignment.config;

import kr.snack.study.assignment.config.Encrypt;
import kr.snack.study.assignment.exception.EncodingException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
public class Sha512Encrypt implements Encrypt {

    @Override
    public String encode(String data) throws EncodingException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(data.getBytes());
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte byteDatum : byteData) {
                sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            throw EncodingException.EXCEPTION;
        }
    }

    @Override
    public boolean match(String originalData, String encryptedData) {

        String str = encode(originalData);
        return encryptedData.equals(str);
    }
}