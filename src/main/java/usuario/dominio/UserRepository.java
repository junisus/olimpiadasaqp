package usuario.dominio;

public interface UserRepository {
	Usuario encontrarPorEmail(String email);
	void guardar(Usuario usuario);
}
