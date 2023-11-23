package usuario.dominio;

public interface EncryptionService {
	String encrypt(String unencrypted);
	String decrypt(String encrypted);
}
