package View;


public class viewHandler {
    public static main_menu main_menu = new main_menu();
    public static create_personel create_personel = new create_personel();
    public static search_personel search_personel = new search_personel();
    public static request_vacation request_vacation = new request_vacation();
    public static search_vacation search_vacation = new search_vacation();
    public static confirm_vacation confirm_vacation = new confirm_vacation();
    public static enum situation{confirmVacation,createPersonel,mainMenu,createVacation,searchPersonel,searchVacation};
    public static situation situ = situation.mainMenu;
    public static void startView(){
        while (true){
            if(situ == situation.mainMenu){
                main_menu.start();
            }
            else if(situ == situation.createPersonel){
                create_personel.start();
            }
            else if(situ == situation.searchPersonel){
                search_personel.start();
            }
            else if(situ == situation.createVacation){
                request_vacation.start();
            }
            else if(situ == situation.searchVacation){
                search_vacation.start();
            }
            else if(situ == situation.confirmVacation){
                confirm_vacation.start();
            }
        }
    }
}
