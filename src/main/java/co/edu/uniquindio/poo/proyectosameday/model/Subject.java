package co.edu.uniquindio.poo.proyectosameday.model;

public interface Subject {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notify(String message);
}
