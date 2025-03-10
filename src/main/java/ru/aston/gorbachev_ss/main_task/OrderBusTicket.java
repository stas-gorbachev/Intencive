package ru.aston.gorbachev_ss.main_task;

public class OrderBusTicket extends Order {

    Route route;

    OrderBusTicket (int id, User user, double amount, double coefficient, Route route) {
        super(id, user, amount, coefficient);
        this.route = route;
    }

    @Override
    double getTicketAmount() {
        return super.getTicketAmount();
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}