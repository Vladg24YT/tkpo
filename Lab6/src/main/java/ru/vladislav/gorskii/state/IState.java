package ru.vladislav.gorskii.state;

public interface IState {
    String enterPIN();
    String withdraw(int num);
    String terminate();
    String deposit(int num);
}
