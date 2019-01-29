package HW.Fruts;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class Frut implements Cloneable {


    public Frut(String typeFrut, int daysLive) {
        this.type = typeFrut;
        this.shelfLife = daysLive;
        this.date = new Date();
        this.price = buldDefaultPrice();
    }

    public Frut(String typeFrut, int daysLive, double price) {
        this.type = typeFrut;
        this.shelfLife = daysLive;
        this.date = new Date();
        this.price = price;
    }

    public Frut(String typeFrut, int daysLive, Date date, double price) {
        this.type = typeFrut;
        this.shelfLife = daysLive;
        this.date = date;
        this.price = price;
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Function

    public boolean isDateBad(Date d) {
        return getDateEnd().before(d);

    }
    //-----------------------------------------------------

    public boolean DateEgulsYearMonthDay(Date d) {

        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTime(getDate());
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(d);


        return (calendar0.get(Calendar.YEAR) == calendar1.get(Calendar.YEAR)
                && calendar0.get(Calendar.MONTH) == calendar1.get(Calendar.MONTH)
                && calendar0.get(Calendar.DATE) == calendar1.get(Calendar.DATE));

    }


    //-------------------------------------------------
    public Date getDateEnd() {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(getDate());

        calendar.add(Calendar.DATE, getDaysLive());

        return calendar.getTime();

    }


    //--------------------------------------------------------------------
    @Override
    public String toString() {
        return ("Type : " + this.getTypeFrut() + " Price : " + this.getPrice()
                + " Date : " + DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(this.getDate())
                + "\\" + DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(this.getDateEnd())
                + " TimeForLive day : " + this.getDaysLive() + "\n");


    }

    //-----------------------------------------------------------------------------------------------
    public double buldDefaultPrice() {

        return ((getTypeFrut() == null || getTypeFrut().isEmpty()) ? 1 : getTypeFrut().length()) *
                ((getDaysLive() < 1.0) ? 1 : getDaysLive());

    }

    ;

    //----------------------------------------------------------------------------------------------
    public Frut clone() {
        try {
            return (Frut) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new Frut(this.getTypeFrut(), this.getDaysLive(), getDate(), getPrice());
        }
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value

    private final String type;

    public String getTypeFrut() {
        return type;
    }

    //----------------------------------------------------
    private final int shelfLife;

    public int getDaysLive() {
        return shelfLife;
    }

    //-------------------------------------------------------
    private final Date date;

    public Date getDate() {
        return date;
    }


    //----------------------------------------------

    final double price;

    public double getPrice() {
        return price;
    }
}
