package id.co.wemppywp.shoppingapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.co.wemppywp.shoppingapp.dao.CafeDao;
import id.co.wemppywp.shoppingapp.database.CafeDatabase;
import id.co.wemppywp.shoppingapp.model.MenuCafe;

public class CafeRepository {

    private CafeDao cafeDao;
    private LiveData<List<MenuCafe>> allCafe;

    public CafeRepository(Application application){
        CafeDatabase database = CafeDatabase.getInstance(application);
        cafeDao = database.cafeDao();
        allCafe = cafeDao.getAllCafe();
    }

    public void insert(MenuCafe menuCafe){
        new InsertAsyncTask(cafeDao).execute(menuCafe);
    }

    public void delete(MenuCafe menuCafe){
        new DeleteAsyncTask(cafeDao).execute(menuCafe);
    }

    public LiveData<List<MenuCafe>> getAllCafe(){
        return allCafe;
    }

    private class InsertAsyncTask extends AsyncTask<MenuCafe,Void,Void> {

        private CafeDao cafeDao;

        InsertAsyncTask(CafeDao cafeDao){
            this.cafeDao = cafeDao;
        }

        @Override
        protected Void doInBackground(MenuCafe... menuCafes) {
            cafeDao.insert(menuCafes[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<MenuCafe,Void,Void> {

        private CafeDao cafeDao;

        DeleteAsyncTask(CafeDao cafeDao){
            this.cafeDao = cafeDao;
        }

        @Override
        protected Void doInBackground(MenuCafe... menuCafes) {
            cafeDao.delete(menuCafes[0]);
            return null;
        }
    }

}
