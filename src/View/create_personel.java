package View;

import Model.personel;

public class create_personel implements menu {
    @Override
    public void start() {
        System.out.println("please enter username");
        String userName = in.nextLine();
        System.out.println("please enter age");
        String age = in.nextLine();
        System.out.println("please enter national code");
        String nationalCode = in.nextLine();
        personel p = new personel(userName,age,nationalCode);
        personel.personels.add(p);
        System.out.println("successfully created");
        System.out.println("please enter if you want to go back either print {1} if you want to create antother Model.personel");
        String t = in.nextLine();
        if(!t.equals("1")) viewHandler.situ = viewHandler.situation.mainMenu;
    }
}
