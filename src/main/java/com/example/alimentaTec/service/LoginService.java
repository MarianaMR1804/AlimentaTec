package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.enums.RolNombre;
import com.example.alimentaTec.model.Login;
import com.example.alimentaTec.repository.LoginRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginRepository repo;

	@Autowired
    private PasswordEncoder passwordEncoder;

    public Login registrarUsuario(String username, String password, String email, RolNombre rol) {
        Login login = new Login();
        login.setUsername(username);
        login.setPasswordUser(passwordEncoder.encode(password));
        login.setEmail(email);
        login.setRole(rol);
        return repo.save(login);
    }

	public boolean autenticarUsuario(String username, String password) {
        Login usuario = repo.findByUsername(username)
            .orElse(null);
			
        if (usuario == null) {
            return false;
        }
        
        return passwordEncoder.matches(password, usuario.getPasswordUser());
    }


	public List<Login> getAll() {
		return repo.findAll();
	}

	public void save(Login login) {
		repo.save(login);
	}

	public Login getByIdLogin(Integer idUser) {
		return repo.findById(idUser).get();
	}

	public void delete(Integer idUser) {
		repo.deleteById(idUser);
	}

}
