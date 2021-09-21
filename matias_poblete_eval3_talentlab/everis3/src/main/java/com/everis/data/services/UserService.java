package com.everis.data.services;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.User;
import com.everis.data.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void save(@Valid User user) {
		// hash password
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
		userRepository.save(user);
	}

	public boolean validarUser(String email, String password) {
		
		User user = userRepository.findByEmail(email);
		//siempre validar si es null
		if(user == null) {
			return false;
		}else {
			//comparar los password
			if (BCrypt.checkpw(password, user.getPassword())) {
			    System.out.println("Password iguales");
				return true;
				
			}else {
			    System.out.println("Password Distintos");
			    return false;
			}
			
		}
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	

}