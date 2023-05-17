
package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Вскрыть себе вены от Джавы");

        Assertions.assertFalse(task.matches("Налить"));
        Assertions.assertTrue(task.matches("себе"));
        Assertions.assertFalse(task.matches("вина"));
        Assertions.assertTrue(task.matches("от"));
        Assertions.assertTrue(task.matches("Джавы"));
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Написать тесты на метод  `matches`", "Добавить тесты в TodosTest класс"};
        Epic epic = new Epic(2, subtasks);

        Assertions.assertTrue(epic.matches("matches"));
        Assertions.assertTrue(epic.matches("TodosTest"));
        Assertions.assertFalse(epic.matches("TaskTest"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(3, "Ежедневный статус", "Командный проект", "2023-05-17 10:00");

        Assertions.assertTrue(meeting.matches("статус"));
        Assertions.assertTrue(meeting.matches("проект"));
        Assertions.assertFalse(meeting.matches("команда"));
    }

    @Test
    public void testSearch() {
        SimpleTask task1 = new SimpleTask(1, "Пойти гулять");
        SimpleTask task2 = new SimpleTask(2, "Купить сосиски");
        Epic epic = new Epic(3, new String[]{"Командый проект, изучить инструкцию"});
        Meeting meeting = new Meeting(4, "Ежедневный статус", "Командый проект", "2023-05-17 10:00");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(epic);
        todos.add(meeting);

        Task[] result1 = todos.search("гулять");
        Assertions.assertArrayEquals(new Task[]{ task1 }, result1);

        Task[] result2 = todos.search("изучить инструкцию");
        Assertions.assertArrayEquals(new Task[]{ epic }, result2);

        Task[] result3 = todos.search("Командый проект");
        Assertions.assertArrayEquals(new Task[]{ epic, meeting }, result3);
        
        Task[] result4 = todos.search("Бросить учебу");
        Assertions.assertArrayEquals(new Task[]{}, result4);
    }

}
