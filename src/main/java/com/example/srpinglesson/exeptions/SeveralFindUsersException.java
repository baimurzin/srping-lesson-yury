package com.example.srpinglesson.exeptions;

public class SeveralFindUsersException extends RuntimeException{
    public SeveralFindUsersException(String message){
        super(message);
    }

}
