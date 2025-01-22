package ru.vladislav.gorskii.state;

public class ProcessingState implements IState{

    private final ATMModel machine;
    private boolean isWithdrawal;

    public ProcessingState(ATMModel instance, int amountChange) {
        this.machine = instance;
        this.isWithdrawal = amountChange < 0;
    }

    @Override
    public String enterPIN() {
        return "Failed: Currently busy";
    }

    @Override
    public String withdraw(int num) {
        return this.isWithdrawal ? "Failed: Already withdrawing..." : "Failed: Currently busy";
    }

    @Override
    public String terminate() {
        return "Failed: Can't abort right now, please wait.";
    }

    @Override
    public String deposit(int num) {
        return this.isWithdrawal ? "Failed: Currently busy" : "Failed: Already depositing...";
    }
}
