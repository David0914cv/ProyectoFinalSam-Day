package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.ArrayList;
import java.util.List;

public class Notify implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notify(String mensaje) {
        for (Observer o : observers) {
            o.update(mensaje);
        }
    }

    // Algún cambio interno que dispara la notificación
    public void importantChange(String message) {
        notify(message);
    }
}
