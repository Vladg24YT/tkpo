package ru.vladislav.gorskii.state;

public class AuthState implements IState {

    private final ATM machine;

    public AuthState(ATM instance) {
        this.machine = instance;
    }

    @Override
    public String enterPIN() {
        return "Failed: Already authenticated";
    }

    @Override
    public String withdraw(int num) {
        if (num < this.machine.getTotalAmount()) {
            this.machine.setState(new ProcessingState(this.machine, num));
            this.machine.changeAmount(-num);
            this.machine.setState(this);
            return "Withdraw successful";
        }
        this.machine.setState(new BlockedState(this.machine));
        return "Failed: Not enough money in the ATM";
    }

    @Override
    public String terminate() {
        this.machine.setState(new IdleState(this.machine));
        return "Session terminated";
    }

    @Override
    public String deposit(int num) {
        this.machine.setState(new ProcessingState(this.machine, num));
        this.machine.changeAmount(num);
        this.machine.setState(this);
        return "Deposit successful";
    }
}
