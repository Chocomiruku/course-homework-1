package com.chocomiruku.homework3.task2;

public abstract class Action {
    private Action() {
    }

    public static final class Registration extends Action {
    }

    public static final class Login extends Action {
        private final User user;

        public Login(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static final class Logout extends Action {
    }
}