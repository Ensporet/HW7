package HW.Store;

import HW.Fruts.Frut;
import Library.Ens_File.File_default;
import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import java.io.*;

import java.lang.reflect.Type;
import java.util.*;


public class Store_default implements Store_null {


    public Store_default() {
    }


    public Store_default(Frut... fruts) {


        if (fruts != null)
            for (Frut f : fruts) {

                linkedList.add(f);

            }

    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Function

    public void prAddedFruits(Date date) {
        prAddedFruits(date, null);
    }

    //..........................................................
    public void prAddedFruits(Date d, Type type) {

        for (Frut f : getAddedFruits(d, type)) {
            System.out.print(f.toString());
        }
    }

    //......................................................
    public List<Frut> getAddedFruits(Date date) {
        return getAddedFruits(date, null);
    }

    //..................................................................
    public List<Frut> getAddedFruits(Date date, Type type) {

        ArrayList<Frut> arrayList = new ArrayList<>();

        for (Frut f : getLinkedList()) {

            if (f.DateEgulsYearMonthDay(date)) {

                if (type != null) {
                    if (!type.getTypeName().equals(f.getTypeFrut())) {
                        continue;
                    }
                }

                arrayList.add(f);
            }

        }


        return arrayList;
    }

    //-----------------------------------------------
    public void prAvailableFruits(Date d) {
        prAvailableFruits(d, null);
    }

    //...................................................
    public void prAvailableFruits(Date d, Type type) {

        for (Frut f : getAvailableFruits(d, type)) {

            System.out.print(f.toString());
        }
    }

    //----------------------------------------------------------------
    public List<Frut> getAvailableFruits(Date date) {
        return getAvailableFruits(date, null);
    }

    //....................................................................
    public List<Frut> getAvailableFruits(Date date, Type type) {

        ArrayList<Frut> arrayList = new ArrayList<>();


        for (Frut f : getLinkedList()) {
            if (type != null) {
                if (!type.getTypeName().equals(f.getTypeFrut())) {
                    continue;
                }
            }

            if (!f.isDateBad(date)) {

                arrayList.add(f);
            }
        }

        return arrayList;
    }
    //------------------------------------------------------------------------------------------

    public void prSpoiledFruits(Date date) {
        prSpoiledFruits(date, null);
    }

    //.........................................................................
    public void prSpoiledFruits(Date date, Type type) {
        for (Frut f : getSpoiledFruits(date, type)) {

            System.out.print(f.toString());
        }

    }
    //............................................................

    public List<Frut> getSpoiledFruits(Date date) {
        return getSpoiledFruits(date, null);
    }

    //...........................................................
    public List<Frut> getSpoiledFruits(Date date, Type type) {

        ArrayList<Frut> arrayList = new ArrayList<>();
        if (date == null) {
            return arrayList;
        }


        for (Frut f : getLinkedList()) {

            if (type != null) {
                if (!type.getTypeName().equals(f.getTypeFrut())) {
                    continue;
                }
            }

            if (f.isDateBad(date)) {
                arrayList.add(f);
            }


        }


        return arrayList;
    }

    //...........................................................
    public void save(String pathToJsonFile) {


        File file = new File_default(pathToJsonFile).getFile();

        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        Gson gson = new Gson();

        gson.toJson(this, Store_default.class, fileWriter);

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Store save action is successfully in path save :" + file.getAbsolutePath());

    }

    //............................................................................................................
    public void addFruits(String pathToJsonFile) {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(pathToJsonFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }


        Gson gson = new Gson();


        JsonObject jsonObject = gson.fromJson(fileReader, JsonObject.class);

        JsonElement jsonElement;
        if ((jsonElement = jsonObject.get("fruts")) != null) {
            if (jsonElement.isJsonArray()) {

                for (JsonElement js : jsonElement.getAsJsonArray()) {

                    Frut f = gson.fromJson(js, Frut.class);
                    if (f != null) {
                        getLinkedList().add(f);
                    }
                }

            }
        }


        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //-------------------------------------------------------------------------------


    //............................................
    public void load(String pathToJsonFile) {

        File f = new File_default(pathToJsonFile).getFile();

        FileReader fileReader;


        try {
            fileReader = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Gson gson = new Gson();

        Store_default store_default = gson.fromJson(fileReader, Store_default.class);
        if (store_default != null) {

            this.getLinkedList().addAll(store_default.getLinkedList());


        }


    }
    //--------------------------------------------------------------------------------------


    public void PrInfoOdStore() {
        PrInfoOdStore(null);
    }

    //.................................
    public void PrInfoOdStore(String s) {
        String separator = "\n --\\\\-- \n";
        System.out.println(((s == null) ? separator : separator + s + "\n") + infoOfStore());
    }

    //------------------------------------------------------------------------------------------------------------------
    public String infoOfStore() {

        String s = "";

        for (int i = 0; i < getLinkedList().size(); i++) {

            Frut f = (Frut) getLinkedList().get(i);
            s += f.toString();


        }


        return s;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //-------------------------------------------------------------------------

    private LinkedList<Frut> linkedList = new LinkedList<>();

    public LinkedList<Frut> getLinkedList() {
        return this.linkedList;
    }
}
