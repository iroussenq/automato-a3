package classes;

import classes.State;
import classes.Transition;

import java.util.HashMap;
import java.util.HashSet;

public class Automata {
    private HashMap<Integer, State> states;
    private HashSet<State> finalStates;
    private HashSet<Transition> transitions;
    private State startState;
    private static int startStateLimit = 0;

    public Automata() {
        states = new HashMap<>();
        finalStates = new HashSet<>();
        transitions = new HashSet<>();
    }

    public void setState(int id, State state) {
        states.put(id, state);
    }

    public void setFinalState(int id) {
        State finalState = states.get(id);
        if (finalState != null) {
            finalStates.add(finalState);
        } else {
            // Handle if state with given ID doesn't exist
            message("State with ID " + id + " doesn't exist.");
        }
    }

    public void setStartState(int id) {
        startState = states.get(id);
    }

    public void setTransition(int originId, int destinyId, String symbol) {
        State origin = states.get(originId);
        State destiny = states.get(destinyId);
        if (origin != null && destiny != null) {
            transitions.add(new Transition(origin, destiny, symbol));
        } else {
            // Handle if states with given IDs don't exist
            message("One or both states with IDs " + originId + " and " + destinyId + " don't exist.");
        }
    }

    public Transition getTransition(int originId, String symbol) {
        for (Transition transition : transitions) {
            if (transition.getOrigin().getId() == originId && transition.getSymbol().equals(symbol)) {
                return transition;
            }
        }
        return null; // If no transition found for the given origin and symbol
    }

    public State getStartState() {
        return startState;
    }

    public State getFinalState(int id) {
        for (State finalState : finalStates) {
            if (finalState.getId() == id) {
                return finalState;
            }
        }
        return null; // If no final state found with the given ID
    }

    public int getFinalStateSize() {
        return finalStates.size();
    }

    public State getState(int id) {
        return states.get(id);
    }

    public boolean isStartState(int id) {
        return startState != null && startState.getId() == id;
    }

    public boolean isFinalState(int id) {
        for (State finalState : finalStates) {
            if (finalState.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void message(String msg) {
        System.out.println(msg);
    }
}