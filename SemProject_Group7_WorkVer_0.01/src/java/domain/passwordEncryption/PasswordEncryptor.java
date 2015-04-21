package domain.passwordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {

    private static String hexStr;

    public PasswordEncryptor() {
    }
    public String encryptPassword_SHA1(String password) {
 
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(password.getBytes());
            byte[] output = md.digest();

            hexStr = bytesToHex(output);
            
        } catch (NoSuchAlgorithmException e) {

            System.out.println("Fail in PasswordEncryptor ->> encryptPassword_SHA1");
            System.out.println(e.getMessage());
        }
        return hexStr;
    }

    private String bytesToHex(byte[] b) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++) {
            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
    }
}
