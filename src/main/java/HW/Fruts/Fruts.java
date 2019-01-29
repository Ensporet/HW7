package HW.Fruts;

import java.util.ArrayList;

public class Fruts {


    public Fruts() {

    }

    public Fruts(Frut... fruts) {

        for (Frut f : fruts) {

            this.fruts.add(f);

        }

    }

    //-----------------------------------------------------------

    private ArrayList<Frut> fruts = new ArrayList<>();

    public ArrayList<Frut> getFruts() {

        return fruts;
    }
}
