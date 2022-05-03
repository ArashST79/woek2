package View;

import Model.constants;
import Model.personel;

import java.util.Arrays;
import java.util.List;

public class request_vacation implements menu{
    @Override
    public void start() {
        System.out.println("please enter national code");
        String code = in.nextLine();
        personel p = personel.getPersonelByCode(code);
        System.out.println("please enter your vacation days like this -> saturday, sunday,wednesday");
        String input = in.nextLine();
        List<String> inputs = Arrays.asList(input.split("\\s*,\\s*"));
        for(String inp : inputs){
            for (int i = 0; i < constants.weekDays.size() ; i++) {
                if(inp.equals(constants.weekDays.get(i))){
                    p.addVacation(i);
                    p.setHasVacation(true);
                }
            }
        }
        personel.unconfirmedVacations.put(p,p.getVacations());
        String s = String.join(",",inputs);
        viewHandler.situ = viewHandler.situation.mainMenu;
        System.out.println("vacations has been requested for "+s);
    }
}
