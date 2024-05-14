package com.apirest.webflux.services;

import com.apirest.webflux.document.NotificationType;
import com.apirest.webflux.document.User;
import com.apirest.webflux.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRespository userRepository;

	@Override
	public Flux<User> findAll() {return userRepository.findAll();}

	@Override
	public Mono<User> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public Mono<User> save(User user) {
		return userRepository.save(user);
	}

	public Mono<Void> unsubscribeUser(String id) {
		return userRepository.findById(id)
				.flatMap(user -> userRepository.delete(user));
	}

	public void enviarNotificacao(NotificationType tipo, String mensagem) {
		switch (tipo) {
			case SMS:
				enviarSms(mensagem);
				break;
			case EMAIL:
				enviarEmail(mensagem);
				break;
			case PUSH:
				enviarPush(mensagem);
				break;
		}
	}

	private void enviarSms(String mensagem) {
		// Lógica para enviar SMS
		System.out.println("Enviando SMS: " + mensagem);
	}

	private void enviarEmail(String mensagem) {
		// Lógica para enviar E-Mail
		System.out.println("Enviando E-Mail: " + mensagem);
	}

	private void enviarPush(String mensagem) {
		// Lógica para enviar notificação Push
		System.out.println("Enviando Push Notification: " + mensagem);
	}

	public Mono<User> createUser(User user) {
		return userRepository.save(user);
	}


}
