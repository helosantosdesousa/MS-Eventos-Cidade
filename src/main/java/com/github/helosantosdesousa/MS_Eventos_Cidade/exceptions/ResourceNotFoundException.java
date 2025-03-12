package com.github.helosantosdesousa.MS_Eventos_Cidade.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
