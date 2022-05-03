public class menu_structure {
    public static situation getSitu() {
        return situ;
    }
    public  static enum situation{createPersonel,mainMenu,vacationCreator};
    private  static situation situ=situation.mainMenu;
    static public void setMenuSituation(situation situ) {
        menu_structure.situ = situ;
    }
}
