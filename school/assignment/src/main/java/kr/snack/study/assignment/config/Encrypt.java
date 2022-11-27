package kr.snack.study.assignment.config;

public interface Encrypt {

    String encode(String data);

    boolean match(String originalData, String encryptedData);
}
