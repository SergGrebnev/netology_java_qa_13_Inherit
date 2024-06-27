package ru.netology.inherit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.inherit.task.Epic;
import ru.netology.inherit.task.Meeting;
import ru.netology.inherit.task.SimpleTask;

public class TodosTest {

    private SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    private String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    private Epic epic = new Epic(55, subtasks);

    private Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatchesForSimpleTaskTrue() {

        boolean expected = true;
        boolean actual = simpleTask.matches("родит");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForSimpleTaskFalse() {

        boolean expected = false;
        boolean actual = simpleTask.matches("неверно");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForEpicTrue() {

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForEpicFalse() {

        boolean expected = false;
        boolean actual = epic.matches("неверно");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForMeetingTopicTrue() {

        boolean expected = true;
        boolean actual = meeting.matches("прилож");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForMeetingProjectTrue() {

        boolean expected = true;
        boolean actual = meeting.matches("Банк");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesForMeetingFalse() {

        boolean expected = false;
        boolean actual = meeting.matches("неверно");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchOfTodos2() {
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("ло");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOfTodos1() {
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOfTodos0() {
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("ничего не найдёт");
        Assertions.assertArrayEquals(expected, actual);
    }

}
