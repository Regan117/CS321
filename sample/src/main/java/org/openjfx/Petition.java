package org.openjfx;
import org.apache.commons.validator.GenericValidator;
class Petition extends DataBase{
    protected String Name;
    protected String Email;
    protected String DOB;
    protected String Country;
    protected int Anum;
    


    public static void main(String[] args){
        //mock data to be added into the "dataBaseMap" should function on it's own when WF is working
        Petition one = new Petition("james", "2000-08-03", "regan@gmail.com","USA",1);
        //System.out.println("test 1 should pass" +one.validateEntry());
        one.writeToDB(one,1);

        
        Petition two = new Petition("james mo", "2000-08-03", "regan@gmail.com","USA",2);
        two.writeToDB(two,2);

        /* 
        Petition three = new Petition("james", "2000-08-03", "regan@gmail.com","USA",3);
        one.writeToDB(three);
        
        Petition test = new Petition();
        test = (one.pullFromDB(1));
        if(test != null){
        System.out.println(test.getAnum());
        }
        else{
            System.out.println("why");

        }
        */
        //TESTS for the petetion functions
        /* 
        Petition two = new Petition("ja3mes", "2000-08-03", "regan@gmail.com","USA",2);
        System.out.println("test 1 should name fail" +two.validateEntry());

        Petition three = new Petition("james", "20000-08-03", "regan@gmail.com","USA",2);
        System.out.println("test 1 fail date" +three.validateEntry());

        Petition four = new Petition("james", "2000-08-03", "regan","USA",02);
        System.out.println("test 1 should fail email" +four.validateEntry());


       
        System.out.println("write test" +  one.writeToDB(one));

        System.out.println("pull test" +  one.pullFromDB(02));

        System.out.println("pull test" +  one.searchDB(one));
*/

    }
    public Petition(){

    }
    public Petition(String name, String dOB, String email, String country, int anum) {
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
    public String getDOB() {
        return DOB;
    }
    public void setDOB(String dOB) {
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
    public Boolean validateEntry() {
        if(Name == null || DOB == null || Country == null|| Email == null || Anum < 0 || Anum >  1000000000){
            return false;
        }
        boolean dV = true;

        if((Name instanceof String)){
            boolean allLetters = Name.chars().allMatch(Character::isLetter);
            if(!allLetters){
                return false;
            }
        }
        if(!GenericValidator.isDate(DOB, "MM-DD-YYYY", dV)){
            return false;
        }
        if(Country.equals("Null")){
            return false;
        }
        return GenericValidator.isEmail(Email);
    }
    public Boolean searchDB(Petition j){
        for(Petition i : DataBase.dataBaseMap.values()) {

            if(i.Name.equals(j.Name) && i.DOB.equals(j.DOB) && i.Country.equals(j.Country)){
                return true;
            }
        }

        return false;
    }
    public Petition pullFromDB(int num){

        return DataBase.dataBaseMap.get(num);
    }
    public Boolean writeToDB(){
        Petition p = new Petition(this.getName(),this.getDOB(),this.getEmail(),this.getCountry(),this.getAnum());
        DataBase.writeToDB(p, Anum);
        return true;
    }
    void displayPetition(){
        System.out.println(this.Name);
        System.out.println(this.Country);
        System.out.println(this.Email);
        System.out.println(this.DOB);
        System.out.println(this.Anum);

    }
}
