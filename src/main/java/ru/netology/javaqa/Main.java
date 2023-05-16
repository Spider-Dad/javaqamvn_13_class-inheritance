package ru.netology.javaqa;

public class Main {
    public static void main(String[] args) {
        // Создаем задачи
        Task task1 = new SimpleTask(1, "Пойти гулять");
        Task task2 = new SimpleTask(2, "Купить сосиски");
        Task epic = new Epic(3, new String[]{"Командый проект, изучить инструкцию"});
        Task meeting = new Meeting(4, "Ежедневный статус", "Командый проект", "2023-05-17 10:00");

        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(epic);
        todos.add(meeting);


    }
}
