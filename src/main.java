import View.viewHandler;
import dao.DBHandler;
import dao.dataFetcher;

public class main {
    public static void main(String[] args) {
        dataFetcher.startFetching();
        viewHandler.startView();
    }
}
