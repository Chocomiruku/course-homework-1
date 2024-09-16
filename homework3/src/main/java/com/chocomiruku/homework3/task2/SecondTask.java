package com.chocomiruku.homework3.task2;

import static com.chocomiruku.homework3.Util.convertLongToTimeString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SecondTask {
    private static final AuthCallback anonymousAuthCallback = new AuthCallback() {
        @Override
        public void authSuccess() {
            System.out.println("Authorization was successful.");
        }

        @Override
        public void authFailed() {
            System.out.println("Authorization has failed.");
        }
    };

    public void updateCache() {
        System.out.println("Cache was updated.");
    }

    public void auth(User user, Runnable r) {
        try {
            user.checkAge();
            anonymousAuthCallback.authSuccess();
            r.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            anonymousAuthCallback.authFailed();
        }
    }

    public void doAction(Action action) {
        if (action instanceof Action.Registration) {
            System.out.println("\nRegistration has started.");
        } else if (action instanceof Action.Login) {
            System.out.println("Auth has started.");
            User user = ((Action.Login) action).getUser();
            if (user == null) {
                throw new NullPointerException("User should be specified.");
            } else auth(user, this::updateCache);
        } else if (action instanceof Action.Logout) {
            System.out.println("Logout has started.");
        }
    }

    public void run() {
        // Exercise 2-3:  Data class with lazy property
        User user = new User(1, "Angelina", 20, Type.DEMO);

        try {
            System.out.println(convertLongToTimeString(user.getStartTime()));
            Thread.sleep(1000);
            System.out.println(convertLongToTimeString(user.getStartTime()));
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught.");
        }

        // Exercise 4: Scope function apply (
        List<User> users = new ArrayList<>();
        users.add(new User(2, "Ivan", 25, Type.FULL));
        users.add(new User(3, "Maria", 30, Type.DEMO));

        // Exercise 5: Filtering collections
        List<User> usersWithFullAccess = users.stream()
                .filter(u -> u.getType() == Type.FULL)
                .collect(Collectors.toList());

        // Exercise 6: Collection transformation operations
        List<String> userNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("\nFirst element: " + userNames.get(0) + ", last element: " + userNames.get(userNames.size() - 1));

        //Alternative solution:
        LinkedList<String> userNamesAlternative = users.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("First element: " + userNamesAlternative.getFirst() + ", last element: " + userNamesAlternative.getLast());

        // Exercises 7-12: Extension function,
        // anonymous object, inline, sealed class
        // (not supported)
        doAction(new Action.Registration());
        try {
            doAction(new Action.Login(user));
            doAction(new Action.Logout());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. " + e.getMessage());
        }
    }
}
