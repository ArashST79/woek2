package View;

import Model.personel;

import java.util.List;
import java.util.Map;

public class confirm_vacation implements menu {
    @Override
    public void start() {
        System.out.println("please confirm each of the vacations you want or you can enter to go back");
        for (Map.Entry<personel, List<Boolean>> unconfirmedVacations :
                personel.unconfirmedVacations.entrySet()) {
            personel p = unconfirmedVacations.getKey();
            System.out.println(p.getNationalCode() + ", "+ p.getName()+"   :   "+p.getVacationsString());
        }
        String input  = in.nextLine();
        if(input.equals("")){
            viewHandler.situ = viewHandler.situation.mainMenu;
            return;
        }
        personel p = personel.getPersonelByCode(input);
        System.out.println("you have confirmed " + p.getName());
        p.setHasVacation(true);
        personel.unconfirmedVacations.remove(p);
    }
}
