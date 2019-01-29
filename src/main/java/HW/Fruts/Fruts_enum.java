package HW.Fruts;

import java.lang.reflect.Type;
import java.util.Date;

public enum Fruts_enum {

    Apple(new Frut("Apple", 60)),
    Quince(new Frut("Quince", 30)),
    Pear(new Frut("Pear", 90)),
    Fig(new Frut("Fig", 120)),
    Melon(new Frut("Melon", 25)),
    WoterMelon(new Frut("WoterMelon", 35)),
    Litchi(new Frut("Litchi", 40)),
    Salak(new Frut("Salak", 61)),
    Plum(new Frut("Plum", 70)),
    unknown(new Frut("???", 1));


    Fruts_enum(Frut f) {
        frut = f;
    }


    private final Frut frut;

    public Frut getFrut() {
        return frut.clone();
    }

    public Frut getFrut(Date date) {


        return new Frut(frut.getTypeFrut(), frut.getDaysLive(), date, frut.getPrice());
    }


    public Type getType() {
        return new Type() {
            @Override
            public String getTypeName() {
                return frut.getTypeFrut();
            }
        };
    }

}
