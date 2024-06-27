package ru.netology.inherit.task;

//Epic — задача, состоящая из подзадач.
// Про неё известны id (число) и subtasks — массив из подзадач,
// каждая из которых является простым текстом (String)


import ru.netology.inherit.Task;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtask) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtask; // заполнение своих полей
    }

    public String[] getSubtask() {
        return subtasks;
    }

    //Метод, проверяющий подходит ли эта задача поисковому запросу
    @Override
    public boolean matches(String query) {
        for (String taskSearch : subtasks) {
            if (taskSearch.contains(query)) {
                return true;
            }
        }
        return false;
    }


}