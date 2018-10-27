package com.example.srpinglesson.exeptions;

import org.hibernate.NonUniqueResultException;

public class SeveralUsersException extends NonUniqueResultException {
    String massege = "Найдено несколько учетных записей: ";
    public SeveralUsersException(int resultCount) {
        super(resultCount);
    }

    public String getMassege() {
        return massege;
    }
}
