package com.apirest.webflux.controller;

import com.apirest.webflux.document.Notification;
import com.apirest.webflux.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@CrossOrigin(origins = "*")
@RestController
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@GetMapping(value= "/notification")
	public Flux<Notification> getNotification(){
		return notificationService.findAll();
	}
	
	
	@GetMapping(value= "/notification/{id}")
	public Mono<Notification> getNotificationId(@PathVariable String id){
		return notificationService.findById(id);

	}


	@PostMapping(value= "/notification/receipt")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Notification> save(@RequestBody Notification notification){
		return notificationService.save(notification);
	}
	
	@GetMapping(value= "/notification/reative/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Notification>> getNotificationByWebflux(){

		System.out.println("---Start get Notification by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<Notification> notificationFlux = notificationService.findAll();
		System.out.println("Passou pelo Notification webflux");
        return Flux.zip(interval, notificationFlux);
        
	}

	/// testes
	// Lista thread-safe para armazenar as notificações
	private final List<Notification> notifications = new CopyOnWriteArrayList<>();

	@GetMapping(value = "/notifications/reative/webflux/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> streamNotifications() {

		// Fluxo de notificações do tipo 1, emitindo a cada 2 segundos
		Flux<String> notifications1 = Flux.interval(Duration.ofSeconds(2))
				.map(seq -> "Notificação Tipo 1 - " + LocalTime.now().toString());

		Flux<Notification> notificationFlux = notificationService.findAll();

		// Combinando os fluxos de notificações
		return Flux.zip(notifications1, notificationFlux,
				(n1, n2) -> "Combinado: " + n1 + " | Id: " + n2.getId() + " - Msg: " + n2.getMessage() + " - UserId: " + n2.getUserId());

	}

}
