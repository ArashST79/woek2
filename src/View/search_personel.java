package View;

import Model.personel;

public class search_personel implements menu {
    @Override
    public void start() {
        System.out.println("what is the national code ?");
        String code = in.nextLine();
        personel p = personel.getPersonelByCode(code);
        System.out.println("username = "+p.getName());
        System.out.println("age = "+p.getAge());
        System.out.println("national code = "+p.getNationalCode());
        viewHandler.situ = viewHandler.situ.mainMenu;
    }
}
