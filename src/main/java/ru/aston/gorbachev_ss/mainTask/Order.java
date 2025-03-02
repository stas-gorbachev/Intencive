package ru.aston.gorbachev_ss.mainTask;

abstract class Order implements Discount {

    User user;
    int id;
    double coefficient, amount;

    Order (int id, User user, double amount, double coefficient) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.coefficient = coefficient;
    }

    int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    User getUser() {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    double getAmount() {
        return amount;
    }

    public void setAmount (double amount) {
        this.amount = amount;
    }

    double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient (double coefficient) {
        this.coefficient = coefficient;
    }
}