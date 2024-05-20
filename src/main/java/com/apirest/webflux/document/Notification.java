package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "notification")
public class Notification {

	public Notification(String id, String message, String notificationType, String userId) {
		super();
		this.id = id;
		this.message = message;
		this.notificationType = notificationType;
		this.userId = userId;
	}
	
	
	@Id
	private String id;
	private String message;
	private String notificationType;
	private String userId;


	public void setNotificationType(Enum notification_type) {
		this.notificationType = String.valueOf(NotificationType.fromString(notificationType));
	}

	public String getUser() {
		return userId;
	}

	public void setUser(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
