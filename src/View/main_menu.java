package View;

import java.util.Scanner;

public class main_menu implements menu{

    @Override
    public void start() {
        System.out.println("1-create personel");
        System.out.println("2-search personel");
        System.out.println("3-request vacation for personel");
        System.out.println("4-search vacation by personel");
        System.out.println("5-vacation confirmation");
        System.out.println("6-search date");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("1")){
            viewHandler.situ = viewHandler.situation.createPersonel;
        }
        else if(input.equals("2")){
            viewHandler.situ = viewHandler.situation.searchPersonel;
        }
        else if(input.equals("3")){
            viewHandler.situ = viewHandler.situation.createVacation;
        }
        else if(input.equals("4")){
            viewHandler.situ = viewHandler.situation.searchVacation;
        }
        else if(input.equals("5")){
            viewHandler.situ = viewHandler.situation.confirmVacation;
        }

    }
    }

