package com.epam.esm.webcourse.validation;

import com.epam.esm.webcourse.entity.User;

public class SecurityValidator {

    public static boolean isValidUser(User user) {
        return user != null && user.getEmail() != null;
    }
}
