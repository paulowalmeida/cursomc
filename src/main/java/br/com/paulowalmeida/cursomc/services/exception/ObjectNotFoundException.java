package br.com.paulowalmeida.cursomc.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public static String getMessageFormatted(Long id, String className) {
        return "Objeto não encontrado. Id: " + id + ", Tipo: " + className;
    }
}
