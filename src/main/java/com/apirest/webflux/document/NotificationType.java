package com.apirest.webflux.document;

public enum NotificationType {
    SMS("sms"),
    EMAIL("email"),
    WEB("web"),
    PUSH("push");


    private String notificationType;

    NotificationType() {
    }

    NotificationType (String notificationType){
        this.notificationType = notificationType;
    }


    // Método para retornar um valor legível do enum, opcional
    @Override
    public String toString() {
        switch (this) {
            case SMS:
                return "SMS";
            case EMAIL:
                return "E-Mail";
            case PUSH:
                return "Push Notification";
            case WEB:
                return "Web Site";
            default:
                return super.toString();
        }
    }

    public static NotificationType fromString(String text) {
        for (NotificationType notificationType : NotificationType.values()) {
            if (notificationType.notificationType.equalsIgnoreCase(text)) {
                return notificationType;
            }
        }
        throw new IllegalArgumentException("Nenhuma NotificationType encontrada para a string fornecida: " + text);
    }

}

