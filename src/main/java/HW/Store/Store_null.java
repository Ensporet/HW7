package HW.Store;


import HW.Fruts.Frut;
import Library.Ens_File.File_default;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public interface Store_null {


    void addFruits(String pathToJsonFile);

    void save(String pathToJsonFile);

    void load(String pathToJsonFile);

    String infoOfStore();


    static File createSupply(Frut... fruts) {

        File f = new File_default(new File("").getAbsolutePath() + File.separator + "Supply" + File.separator + "supply_1.json").getFile();
        System.out.println("Path supply : " + f.getAbsolutePath());

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("fruts", gson.toJsonTree(fruts));

        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(f);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        gson.toJson(jsonObject, fileWriter);
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


        return f;
    }


}
