package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class personel {
    private String name;
    private String nationalCode;
    private String age;
    private boolean hasVacation;
    private List<Boolean> vacations;
    public static List<personel> personels = new ArrayList<>();
    public static HashMap<personel, List<Boolean> > unconfirmedVacations = new HashMap<personel, List<Boolean>>();
    public boolean isConfirmedVacation() {
        return confirmedVacation;
    }

    public void setConfirmedVacation(boolean confirmedVacation) {
        this.confirmedVacation = confirmedVacation;
    }

    private boolean confirmedVacation;
    public personel(String name, String age, String nationalCode){
        this.name = name;
        this.age = age;
        this.nationalCode = nationalCode;
        this.hasVacation = false;
        vacations = new ArrayList<>(7);
        for (int i = 0; i < 10; i++) {
            vacations.add(false);
        }
    }
    public static personel getPersonelByCode(String code){
        for(personel p: personels){
            if (p.getNationalCode().equals(code)) return p;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void addVacation(int index){
        vacations.add(index,true);
    }

    public List<Boolean> getVacations(){
        return vacations;
    }

    public boolean hasVacation() {
        return hasVacation;
    }

    public void setHasVacation(boolean hasVacation) {
        this.hasVacation = hasVacation;
    }

    public String getVacationsString(){
        String s = "";
        for (int i = 0; i <vacations.size() ; i++) {
            if (vacations.get(i)) {
                s += constants.weekDays.get(i);
                s+=", ";
            }
        }
        if(s.substring(s.length() - 2).equals(", ")){
            s = s.substring(0,s.length()-2);
        }
        return s;
    }
}
