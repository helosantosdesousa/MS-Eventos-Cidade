package com.github.helosantosdesousa.MS_Eventos_Cidade.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message){
        super(message);
    }
}
