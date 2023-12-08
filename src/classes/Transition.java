package classes;

import classes.State;

import java.util.Objects;

public class Transition {
    private State origin;
    private State destiny;
    private String symbol;

    public Transition(State origin, State destiny, String symbol) {
        this.origin = origin;
        this.destiny = destiny;
        this.symbol = symbol;
    }

    public State getOrigin() {
        return origin;
    }

    public void setOrigin(State origin) {
        this.origin = origin;
    }

    public State getDestiny() {
        return destiny;
    }

    public void setDestiny(State destiny) {
        this.destiny = destiny;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Transition that = (Transition) object;
        return Objects.equals(origin, that.origin) &&
                Objects.equals(destiny, that.destiny) &&
                Objects.equals(symbol, that.symbol);
    }
}