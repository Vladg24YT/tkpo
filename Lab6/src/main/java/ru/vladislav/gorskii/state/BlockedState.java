package ru.vladislav.gorskii.state;

public class BlockedState implements IState{

    private final ATMModel machine;

    public BlockedState(ATMModel instance) {
        this.machine = instance;
    }

    @Override
    public String enterPIN() {
        return "Failed: Machine has been blocked";
    }

    @Override
    public String withdraw(int num) {
        return "Failed: Machine has been blocked";
    }

    @Override
    public String terminate() {
        this.machine.setState(new IdleState(this.machine));
        return "Session terminated";
    }

    @Override
    public String deposit(int num) {
        return "Failed: Machine has been blocked";
    }
}
