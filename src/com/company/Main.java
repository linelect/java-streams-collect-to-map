package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class Main {

    public static void main(String[] args) {
        Category cat1 = new Category("cat1");
        Category cat2 = new Category("cat2");
        Category cat3 = new Category("cat3");

        Task task1 = new Task("task1", Set.of(cat1, cat2, cat3));
        Task task2 = new Task("task2", Set.of(cat1, cat2));
        Task task3 = new Task("task3", Set.of(cat1, cat3));

        List<Task> tasks = List.of(task1, task2, task3);
        HashMap<String, Set<Task>> mapOfCategories = tasks.stream()
                .flatMap(t -> t.getCategories().stream().map(c -> Map.entry(c.getName(), t)))
                .collect(groupingBy(
                        Map.Entry::getKey, HashMap::new, mapping(Map.Entry::getValue, Collectors.toSet())));

        System.out.println(mapOfCategories);
    }
}
