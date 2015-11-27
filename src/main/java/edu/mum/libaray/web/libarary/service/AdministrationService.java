package edu.mum.libaray.web.libarary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Authority;
import edu.mum.libaray.web.entity.Credentials;
import edu.mum.libaray.web.entity.Role;
/*import edu.mum.libaray.web.entity.Role;*/
import edu.mum.libaray.web.entity.User;
import edu.mum.libaray.web.repository.AuthorityRepository;
import edu.mum.libaray.web.repository.CredentialRepository;
import edu.mum.libaray.web.repository.RoleRepository;
/*import edu.mum.libaray.web.repository.RoleRepository;*/
import edu.mum.libaray.web.repository.UserRepository;


public class AdministrationService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CredentialRepository credentialRepository;
	
	@Autowired
	AuthorityRepository authorityRepository;

	
	public void save(User user){
	
		Authority authority=new Authority();
		authority.setAuthority(user.getAuthority());
		authority.setUsername(user.getUsername());
		authorityRepository.save(authority);
		
		Credentials credential=new Credentials();
		credential.setUsername(user.getUsername());
		credential.setPassword(user.getPassword());
		credential.setEnabled(user.getEnabled());
		credential.setAuthority(authority);
		credentialRepository.save(credential);
		
		
		user.setCredentials(credential);	
		userRepository.save(user);
	}
	public User findUser(long userid){
		return userRepository.findOne(userid);
	}
	public Iterable <User> findAllUser(){
		return userRepository.findAll();
	}
	public void deleteUser(long id){
		userRepository.delete(id);
	}
	
	public void save(Role role){
		roleRepository.save(role);
	}
	public Role findRole(long roleid){
		return roleRepository.findOne(roleid);
	}
	public Iterable <Role> findAllRoles(){
		return roleRepository.findAll();
	}
	public void deleteRole(long id){
		roleRepository.delete(id);
	}
	
}
