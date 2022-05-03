package View;

import Model.constants;
import Model.personel;

import java.util.List;

public class search_vacation implements menu{
    @Override
    public void start() {
        System.out.println("please inter national code :");
        String code = in.nextLine();
        personel p = personel.getPersonelByCode(code);
        System.out.println("your vacation days :");
        List<Boolean> vacations = p.getVacations();
        for (int i = 0; i <vacations.size() ; i++) {
            if(vacations.get(i)){
                System.out.println("--> " + constants.weekDays.get(i));
            }
        }
        viewHandler.situ = viewHandler.situation.mainMenu;
    }
}
