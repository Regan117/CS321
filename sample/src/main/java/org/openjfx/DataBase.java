package org.openjfx;

import java.util.HashMap;

public class DataBase {
    public static HashMap<Integer, Petition> dataBaseMap = new HashMap<>();

   /* public Boolean searchDB(Petition j){
        for(Petition i : dataBaseMap.values()) {

            if(i.Name.equals(j.Name) && i.Anum == j.Anum){

                return true;
            }
        }

        return false;
    }
    public Petition pullFromDB(int num){
        return dataBaseMap.get(num);
    }*/
    public static Boolean writeToDB(Petition p, int Anum){
        dataBaseMap.put(Anum, p);
        return true;
    }

}
