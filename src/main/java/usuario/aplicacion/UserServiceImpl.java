package usuario.aplicacion;

import usuario.dominio.UserRepository;
import usuario.dominio.Usuario;

public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public boolean login(String email, String password) {
		Usuario usuario = userRepository.encontrarPorEmail(email);
		
		if (usuario != null && usuario.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean register(String email, String password) {
		Usuario u = userRepository.encontrarPorEmail(email);
		if (u == null) {
			Usuario usuario = new Usuario();
			usuario.setIdRol(1);
			usuario.setEmail(email);
			usuario.setPassword(password);
			userRepository.guardar(usuario);
			return true;
		}
		return false;
	}
}
