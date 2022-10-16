package org.acsn1.practicecore.utils;

import org.acsn1.practicecore.PracticeCore;

import java.io.*;

public class ObjectUtils {

    public static PracticeCore core = PracticeCore.getPlugin(PracticeCore.class);

    public static Object deserializeObject(String path){
        String ext = ".profile";
        Object o = null;


        try{
            FileInputStream fis = new FileInputStream(core.getDataFolder()+"/data/" + path + ext);
            ObjectInputStream ois = new ObjectInputStream(fis);

            o = ois.readObject();
            ois.close();
            fis.close();

            return o;

        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println(ex.getLocalizedMessage());
        }

        return o;
    }



    public static void serializeObject(Object o, String path) {
        String ext = ".profile";

        try {
            FileOutputStream fos = new FileOutputStream(core.getDataFolder()+"/data/" + path + ext);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(o);
            oos.close();
            fos.close();

        }catch(IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getLocalizedMessage());

        }
    }

}
