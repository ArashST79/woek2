package service;

import Model.personel;
import dao.personelDao;

public class personelService {
    public void createPersonel(personel p){
        personelDao personelDao = new personelDao();
        personelDao.createPersonel(p);
    }
}
