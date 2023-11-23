package usuario.infraestructura;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.*;

import org.picketbox.commons.cipher.Base64;

import usuario.dominio.EncryptionService;

public class EncryptionServiceImpl implements EncryptionService {
	private String key = "RnCD(*ewS^a?pwx";

	public SecretKeySpec createSecretKey(String key) {
		try {
			byte[] claveEnBytes = key.getBytes("UTF-8");
			MessageDigest mensaje = MessageDigest.getInstance("SHA-1");
			claveEnBytes = mensaje.digest(claveEnBytes);
			claveEnBytes = Arrays.copyOf(claveEnBytes, 16);

			SecretKeySpec secretKey = new SecretKeySpec(claveEnBytes, "AES");
			return secretKey;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String encrypt(String unencrypted) {
		try {
			SecretKeySpec secretKeySpec = createSecretKey(key);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

			byte[] claveEnBytes = unencrypted.getBytes("UTF-8");
			byte[] claveEncriptada = cipher.doFinal(claveEnBytes);
			String claveEncriptadaCodificada = Base64.encodeBytes(claveEncriptada);
			return claveEncriptadaCodificada;

		} catch (Exception e) {
			return e.toString();
		}
	}

	@Override
	public String decrypt(String encrypted) {
		try {
			SecretKeySpec secretKeySpec = createSecretKey(key);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

			byte[] claveEnBytes = Base64.decode(encrypted);
			byte[] claveDesencriptada = cipher.doFinal(claveEnBytes);
			String claveDesencriptadaCadena = new String(claveDesencriptada);
			return claveDesencriptadaCadena;

		} catch (Exception e) {
			return e.toString();
		}
	}
}
