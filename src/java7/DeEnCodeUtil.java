package java7;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/8/19
 */

public class DeEnCodeUtil {
    public static String desEnCode(String srcStr) {

        try {
            Key localKey = jdMethod_super("cputest".getBytes());

            Cipher localCipher = Cipher.getInstance("DES");
            localCipher.init(1, localKey);
            return byteArr2HexStr(localCipher.doFinal(srcStr.getBytes()));
        } catch (InvalidKeyException localInvalidKeyException) {
            localInvalidKeyException.printStackTrace();
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        } catch (NoSuchPaddingException localNoSuchPaddingException) {
            localNoSuchPaddingException.printStackTrace();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return "0";
    }

    public static String desDeCode(String desStr) {
        try {
            Key localKey = jdMethod_super("cputest".getBytes());

            Cipher localCipher = Cipher.getInstance("DES");
            localCipher.init(2, localKey);
            return new String(localCipher.doFinal(hexStr2ByteArr(desStr)));
        } catch (InvalidKeyException localInvalidKeyException) {
            localInvalidKeyException.printStackTrace();
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        } catch (NoSuchPaddingException localNoSuchPaddingException) {
            localNoSuchPaddingException.printStackTrace();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return "0";
    }

    private static Key jdMethod_super(byte[] paramArrayOfByte) throws Exception {
        byte[] arrayOfByte = new byte[8];

        for (int i = 0; (i < paramArrayOfByte.length) && (i < arrayOfByte.length); i++) {
            arrayOfByte[i] = paramArrayOfByte[i];
        }

        SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte, "DES");

        return localSecretKeySpec;
    }

    public static String byteArr2HexStr(byte[] paramArrayOfByte) throws Exception {
        int i = paramArrayOfByte.length;

        StringBuffer localStringBuffer = new StringBuffer(i * 2);
        for (int j = 0; j < i; j++) {
            int k = paramArrayOfByte[j];

            while (k < 0) {
                k += 256;
            }

            if (k < 16) {
                localStringBuffer.append("0");
            }
            localStringBuffer.append(Integer.toString(k, 16));
        }
        return localStringBuffer.toString();
    }

    public static byte[] hexStr2ByteArr(String paramString) throws Exception {
        byte[] arrayOfByte1 = paramString.getBytes();
        int i = arrayOfByte1.length;

        byte[] arrayOfByte2 = new byte[i / 2];
        for (int j = 0; j < i; j += 2) {
            String str = new String(arrayOfByte1, j, 2);
            arrayOfByte2[(j / 2)] = ((byte) Integer.parseInt(str, 16));
        }
        return arrayOfByte2;
    }

    public static void main(String[] args) {
        try {

            if (null == args[0] || null == args[1]) {
                System.out.println("Usage: java -cp <path>/DeEnCodeUtil.jar <sourceFilePath> <targetFilePath>");
            }
            FileReader reader = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(reader);

            File file = new File(args[1]);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(args[1]);
            BufferedWriter bw = new BufferedWriter(writer);
            String str = null;

            while ((str = br.readLine()) != null) {
                String[] strings = str.split("\t");
                bw.write(strings[0] + "\t" + desDeCode(strings[1]) + "\n");
            }
            br.close();
            reader.close();
            bw.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("源文件路径不存在");
        } catch (IOException e) {
            System.out.println("文件输出流异常");
        }

    }

}
