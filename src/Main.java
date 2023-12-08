import classes.Automata;
import classes.State;
import classes.Transition;

public class Main {
    public static void main(String[] args) {

        Automata automata = new Automata();

        //Input:
        String symbol = "2020021";

        Transition transition;
        State destiny;
        State state0 = new State(0);
        State state1 = new State(1);
        State state2 = new State(2);
        State state3 = new State(3);
        State state4 = new State(4);


        automata.setState(0, state0);
        automata.setState(1, state1);
        automata.setState(2, state2);
        automata.setState(3, state3);
        automata.setState(4, state4);

        automata.setStartState(0);
        automata.setFinalState(4);
        int finalStates[] = {4};

        automata.setTransition(0, 0, "1");
        automata.setTransition(0, 0, "2");
        automata.setTransition(0, 1, "0");
        automata.setTransition(1, 2, "1");
        automata.setTransition(1, 3, "2");
        automata.setTransition(2, 2, "0");
        automata.setTransition(2, 4, "1");
        automata.setTransition(2, 4, "2");
        automata.setTransition(3, 3, "0");
        automata.setTransition(3, 3, "1");
        automata.setTransition(3, 4, "2");
        automata.setTransition(4, 4, "0");
        automata.setTransition(4, 4, "1");
        automata.setTransition(4, 4, "2");
        headerMessage(symbol, automata, finalStates);

        int i = 0;
        int origin = 0;
        while (i < symbol.length()) {
            if (!(symbol.charAt(i) == ' ')) {
                transition = automata.getTransition(origin,
                        "" + symbol.charAt(i));
                destiny = transition.getDestiny();
                origin = destiny.getId();
                System.out.println("Leu o símbolo \"" + symbol.charAt(i)
                        + "\" foi para o \""
                        + automata.getState(origin).getId());
                i++;
            } else {
                System.out.println("\nEste autômato não aceita transições vazias!!!");
                System.exit(0);
            }
        }
        finalStateOfAutomata(symbol, automata, origin);
    }
    public static void headerMessage(String symbol, Automata myAutomata, int
            finalStates[]) {
        System.out.println("\nDFA reconhecedor da expressão regular (0+1)*1(0+1)(0+1)");
        System.out.println("Verifica a entrada \"" + symbol + "\"\n");
        System.out.println("Definição dos Estados:\n\t"
                + myAutomata.getStartState().getName() + " - "
                + myAutomata.getStartState().getLabel());
        for (int j = 0; j < myAutomata.getFinalStateSize(); j++) {
            System.out.println("\n\t" +
                    myAutomata.getFinalState(finalStates[j]).getName()
                    + " - " +
                    myAutomata.getFinalState(finalStates[j]).getLabel() + "\n");
        }
    }

    public static void finalStateOfAutomata(String symbol, Automata myAutomata, int origin) {
        if (myAutomata.isFinalState(origin)) {
            System.out.println("\nA entrada \"" + symbol
                    + "\" foi aceita !!!\n");
        } else {
            System.out.println("\nA entrada \"" + symbol
                    + "\" foi rejeitada !!!\n");
        }
    }
}