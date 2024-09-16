package com.chocomiruku.homework3.task2;

public class User {

    private final long id;
    private final String name;
    private final int age;
    private final Type type;
    private Long startTime;

    public User(long id, String name, int age, Type type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public Long getStartTime() {
        if (startTime == null) {
            startTime = System.currentTimeMillis();
        }
        return startTime;
    }

    public void checkAge() throws Exception {
        if (age < 18) throw new Exception("User is under 18 years old.");
        else System.out.println("Success. User is over 18 years old.");
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}