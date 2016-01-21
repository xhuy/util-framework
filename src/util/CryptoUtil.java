package util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * This is a class for encryption/decryption of data with an initial
 * <code>secretKey</code>
 * 
 * @author jesus.herrera
 *
 */
public class CryptoUtil {

	private static final String secretKey = "h4ckz0rsl33tn00b";
	private static final byte[] secretKeyBytes = secretKey.getBytes();
	private static final String algorithm = "AES";

	/**
	 * Function that receives raw data and encrypt it to Base 64 using AES
	 * algorithm
	 * 
	 * @param input
	 *            <code>String</code> to be encrypted using AES and Base64
	 * @return <code>String</code> encrypted using AES and Base64
	 * @throws NoSuchAlgorithmException
	 *             NoSuchPaddingException InvalidKeyException
	 *             IllegalBlockSizeException BadPaddingException
	 */
	public static String encryptBase64WithAES(String input) throws Exception {
		Key key = new SecretKeySpec(secretKeyBytes, algorithm);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedValueBytes = cipher.doFinal(input.getBytes());
			String encryptedValue = new String(Base64.getEncoder().encode(encryptedValueBytes));
			return encryptedValue;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			throw e;
		}
	}

	/**
	 * Function that receives an encrypted value that was encrypted using the
	 * function <code>CryptoUtil.encryptBase64WithAES</code> and returns the
	 * decrypted value
	 * 
	 * @param encryptedData
	 *            <code>String</code> value encrypted using AES in Base64
	 * @return <code>String</code> desencrypted
	 * @throws NoSuchAlgorithmException
	 *             NoSuchPaddingException InvalidKeyException
	 *             IllegalBlockSizeException BadPaddingException
	 */
	public static String dencryptBase64WithAES(String encryptedData) throws Exception {
		Key key = new SecretKeySpec(secretKeyBytes, algorithm);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedData.getBytes());
			byte[] decValue = cipher.doFinal(decodedBytes);
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			throw e;
		}

	}

}
