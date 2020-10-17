package com.java.decrypt;

import javax.crypto.*;

public class Decrypt

{

    public String decrypt_pass(String Str_Password) throws Exception

    {
      Cipher decryptCipher;
      sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
      String characterEncoding = "ASCII";
      String recoveredPassword = "";
      final byte[] DESKeyBytes = {0x01, 0x02, 0x04, 0x08, 0x08, 0x04, 0x02, 0x01};
      final byte[] ivBytes = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};
      try
      {

        decryptCipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        javax.crypto.SecretKey key = new javax.crypto.spec.SecretKeySpec(DESKeyBytes, "DES");
        javax.crypto.spec.IvParameterSpec iv = new javax.crypto.spec.IvParameterSpec(ivBytes);
        decryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv);
        byte[] encryptedPasswordBytes = base64Decoder.decodeBuffer(Str_Password);
        byte[] passwordBytes = decryptCipher.doFinal(encryptedPasswordBytes);
        recoveredPassword = new String(passwordBytes, characterEncoding);
      }
      catch (Exception ex)
      {
        ex.printStackTrace(System.out);
      }
      //System.out.println("recoveredPassword : "+recoveredPassword);
       return recoveredPassword;
    }
    public String DecryptPassword(String Str_Password)
    {
        String recoveredPassword = "";
        try
        {
            //recoveredPassword = decrypt(Str_Password);
            recoveredPassword =  decrypt_pass(Str_Password);
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
        return recoveredPassword;
    }
}

