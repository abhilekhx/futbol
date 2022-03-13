package com.adhikari.futbol.util;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(){super("The provided request parameters did not meet validation requirements");}

    public InvalidRequestException(String message){super(message);}

}
