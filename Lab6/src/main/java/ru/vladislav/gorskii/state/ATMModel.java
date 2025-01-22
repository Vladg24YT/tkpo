package ru.vladislav.gorskii.state;

public class ATMModel {

    private int id;
    private int totalAmount;
    private double noConnectionChance;
    private IState state;

    public ATMModel(int id, int amount, double chance){
        this.id = id;
        this.totalAmount = amount;
        this.noConnectionChance = chance;
        this.state = new IdleState(this);
    }

    public String enterPIN() {
        return this.state.enterPIN();
    }

    public String withdraw(int num) {
        return this.state.withdraw(num);
    }

    public String terminate() {
        return this.state.terminate();
    }

    public String deposit(int num) {
        return this.state.deposit(num);
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    public void changeAmount(int num) {
        this.totalAmount += num;
    }

    public double getNoConnectionChance() {
        return this.noConnectionChance;
    }

    public void setState(IState newState) {
        this.state = newState;
    }
}
