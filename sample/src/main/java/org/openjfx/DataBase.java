package org.openjfx;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static HashMap<Integer, Petition> dataBaseMap = new HashMap<>();

    /*
    public Boolean searchDB(Petition j){
        for(Petition i : dataBaseMap.values()) {

            if(i.Name.equals(j.Name) && i.Anum == j.Anum){

                return true;
            }
        }

        return false;
    }
    */
    public static Petition pullFromDB(int num){

            return dataBaseMap.get(num);
        }
    
    public static Boolean writeToDB(Petition p, int iD){
        dataBaseMap.put(iD, p);
        return true;
    }

    public static void deleteFromDB(int id){
        dataBaseMap.remove(id);
    }

    public static void printDB(){
        for( Map.Entry<Integer,Petition> entry : dataBaseMap.entrySet() ){
            System.out.println("FROM DB"+ entry.getKey() + " => " + entry.getValue() );
        }
        
    }
}
