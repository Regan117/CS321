package org.openjfx;
class petition{
    protected String Name;
    protected String Email;
    protected int DOB;
    protected String country;
    protected int Anum;

    public static void main(String[] args){
    
    }
    public petition(){

    }

    public petition(String name, int dOB, String email, String country, int aNum) {
    
    }

    public Boolean ValidateEntry(String name, int dOB, String email, String country, int aNum) {

        return false;
    }
    public Boolean SearchDB(petition p){

        return false;
    }
    public Boolean PullFromDB(int ANum){

        return false;
    }
    public Boolean WriteToDB(petition p){
        return true;
    }
}
