package com.example.keeper;
import java.util.ArrayDeque;
import java.util.Queue;
public class Caretaker {
    private Queue<Momento> momentoList = new ArrayDeque<>();
    // Сохраняем состояние
    public void push(Momento state) {
        momentoList.add(state);
    }
    // Извлекаем последнее сохраненное состояние
    public Momento poll() {
        return momentoList.poll();
    }
}
