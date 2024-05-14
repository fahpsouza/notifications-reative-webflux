package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notification")
public class Notification {
	
	
	
	public Notification(String id, String nome, String message) {
		super();
		this.id = id;
		this.nome = nome;
		this.message = message;
	}
	
	
	@Id
	private String id;
	private String nome;
	private String message;



    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}

}
