package org.openjfx;
import java.util.HashMap;
class Petition{
    protected String Name;
    protected String Email;
    protected int DOB;
    protected String Country;
    protected int Anum;
    
    private HashMap<Integer, Petition> dataBaseMap = new HashMap<>();


    public static void main(String[] args){
    
    }
    public Petition(){

    }
    public Petition(String name,int dOB, String email, String country, int anum) {
        Name = name;
        Email = email;
        DOB = dOB;
        Country = country;
        Anum = anum;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public int getDOB() {
        return DOB;
    }
    public void setDOB(int dOB) {
        DOB = dOB;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public int getAnum() {
        return Anum;
    }
    public void setAnum(int anum) {
        Anum = anum;
    }
    
//NOT FINISHED
    public Boolean validateEntry(String name, int dOB, String email, String country, int aNum) {
        boolean state =  true;
        if(!(name instanceof String)){
            state = false;
        }
        return state;
    }
    public Boolean searchDB(Petition p){
        for(Petition i : dataBaseMap.values()) {
            if(p.equals(i)){
                return true;
            }
        }
        return false;
    }
    public Petition pullFromDB(int ANum){
        
        return dataBaseMap.get(Anum);
    }
    public Boolean writeToDB(Petition p){
        dataBaseMap.put(Anum, p);
        return true;
    }
}
