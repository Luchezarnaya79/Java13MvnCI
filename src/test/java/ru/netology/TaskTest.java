package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void WhenTestFindTaskSimple() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void WhenTestNotFindTaskSimple() {

        SimpleTask simpleTask = new SimpleTask(5, "Купить подарок родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertFalse(actual);
    }

    @Test
    public void WhenTestFindTaskEpic() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void WhenTestNotFindTaskEpic() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Макароны");

        Assertions.assertFalse(actual);
    }

    @Test
    public void WhenTestFindTaskMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void WhenTestNotFindTaskMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Ужин");

        Assertions.assertFalse(actual);
    }


}
