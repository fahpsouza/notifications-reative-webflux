package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

@Document(collection = "user")
public class User  {

    public User(String id, String nome, Boolean acceptReceivingNotifications) {
        super();
        this.id = id;
        this.nome = nome;
        this.acceptReceivingNotifications = acceptReceivingNotifications;
    }

    public User() {
    }

    @Id
    private String id;
    private String nome;
    private Boolean acceptReceivingNotifications = false;


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

    public Boolean getAcceptReceivingNotifications(Mono<User> userMono) {
        return acceptReceivingNotifications;
    }

    public void setAcceptReceivingNotifications(Boolean acceptReceivingNotifications) {
        this.acceptReceivingNotifications = acceptReceivingNotifications;
    }
}
