package com.company;

import java.util.Set;

public class Task {
    private String name;
    private Set<Category> categories;

    public Task(String name, Set<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
