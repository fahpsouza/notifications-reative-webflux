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
	UserRespository userRespository;

	@Override
	public Flux<User> findAll() {return userRespository.findAll();}

	@Override
	public Mono<User> findById(String id) {
		return userRespository.findById(id);
	}

	@Override
	public Mono<User> save(User user) {
		return userRespository.save(user);
	}

	@Override
	public void unsubscribe(String id) {
		 userRespository.findById(id)
				.map(user -> {
					user.setAcceptReceivingNotifications(false);
					return userRespository.save(user);
				});
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


}
