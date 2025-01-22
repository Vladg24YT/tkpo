package ru.vladislav.gorskii.state;

import java.util.Random;

public class IdleState implements IState{

    private final ATM machine;

    public IdleState(ATM instance) {
        this.machine = instance;
    }

    @Override
    public String enterPIN() {
        Random rngProvider = new Random();
        if (rngProvider.nextDouble() > this.machine.getNoConnectionChance()) {
            return "Failed: No connection to bank";
        }
        this.machine.setState(new AuthState(this.machine));
        return "Authenticated successfully";
    }

    @Override
    public String withdraw(int num) {
        return "Failed: You need to authenticate first";
    }

    @Override
    public String terminate() {
        return "Failed: Already idling";
    }

    @Override
    public String deposit(int num) {
        return "Failed: You need to authenticate first";
    }
}
