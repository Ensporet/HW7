import HW.Fruts.Fruts_enum;
import HW.Store.Store_default;
import HW.Store.Store_null;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.io.File;

public class main {
    public static void main(String[] args) {

        File supplay = null;

        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2019, 0, 1);

            supplay = Store_null.createSupply(

                    Fruts_enum.Apple.getFrut(calendar.getTime()),
                    Fruts_enum.Plum.getFrut(calendar.getTime()),
                    Fruts_enum.unknown.getFrut(calendar.getTime()),
                    Fruts_enum.Pear.getFrut(calendar.getTime())


            );
        }
        String pathSaveAnsLoad = new File("").getAbsolutePath() + File.separator + "SaveStore" + File.separator + "save.json";
        String separator = "\n--\\\\--\n";
        //-------------------------------------------

        {//defoult + add and save
            Store_default store_default = new Store_default(
                    Fruts_enum.Litchi.getFrut(),
                    Fruts_enum.Melon.getFrut(),
                    Fruts_enum.Salak.getFrut()
            );
            store_default.PrInfoOdStore("Create new store and added defoult fruts");
            store_default.addFruits(supplay.getAbsolutePath());
            store_default.PrInfoOdStore("addFruits()");
            System.out.println(separator + "SaveStore...");
            store_default.save(pathSaveAnsLoad);
        }

        //-----------------------------------------------------------------------------------------------
        //load
        Store_default store_default = new Store_default();
        store_default.load(pathSaveAnsLoad);
        store_default.PrInfoOdStore("Load Store...");

        //----------------------------------------------------------------------------------------------------
        {//Fruit : Spoiled Fruits  and Available Fruits
            Date dateOfRot = null;
            {
                Calendar calendar = (Calendar) Calendar.getInstance();
                calendar.add(Calendar.DATE, 25);
                dateOfRot = calendar.getTime();
            }

            System.out.println(separator + "Spoiled fruits on that date (" + dateOfRot + ") :");
            store_default.prSpoiledFruits(dateOfRot);

            //.......................................................

            System.out.println(separator + "Available fruits on that date (" + dateOfRot + ") :");
            store_default.prAvailableFruits(dateOfRot);
        }


        //----------------------------------------------------------------------------------------------

        { //Fruit : Spoiled Fruits type  and Available Fruits type
            Date dateOfRot = null;
            {
                Calendar calendar = (Calendar) Calendar.getInstance();
                calendar.add(Calendar.DATE, 25);
                dateOfRot = calendar.getTime();
            }

            Type t = Fruts_enum.Apple.getType();

            System.out.println(separator + "Spoiled  \"" + t.getTypeName() + "\" on that date (" + dateOfRot + ") :");
            store_default.prSpoiledFruits(dateOfRot, t);

            //.......................................................

            System.out.println(separator + "Available \"" + t.getTypeName() + "\" on that date (" + dateOfRot + ") :");
            store_default.prAvailableFruits(dateOfRot, t);
        }
        //--------------------------------------------------------------------------------------------------------------

        { //Fruit : Spoiled Fruits type  and Available Fruits type
            Date dateAdderFruits = null;
            {
                Calendar calendar = Calendar.getInstance();
                calendar.set(2019, 0, 01);
                dateAdderFruits = calendar.getTime();
            }

            Type t = Fruts_enum.Apple.getType();

            System.out.println(separator + "Added \"" + t.getTypeName() + "\" on that date (" + dateAdderFruits + ") :");
            store_default.prAddedFruits(dateAdderFruits, t);
            //.........................................................................................................
            System.out.println(separator + "AddedFruits on that date (" + dateAdderFruits + ") :");
            store_default.prAddedFruits(dateAdderFruits);

            //.......................................................

        }
        //--------------------------------------------------------------------------------------------------------------


    }

}
