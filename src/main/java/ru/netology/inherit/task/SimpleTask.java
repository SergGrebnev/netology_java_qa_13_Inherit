package ru.netology.inherit.task;


import ru.netology.inherit.Task;

//SimpleTask — простая задача, про неё известны только id (число) и title (название)
public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id); // вызов родительского конструктора
        this.title = title; // заполнение своих полей
    }

    public String getTitle() {
        return title;
    }


    //Метод, проверяющий подходит ли эта задача поисковому запросу
    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

}