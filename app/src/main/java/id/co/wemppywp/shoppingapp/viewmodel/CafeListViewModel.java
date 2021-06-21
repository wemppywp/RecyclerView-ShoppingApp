package id.co.wemppywp.shoppingapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.co.wemppywp.shoppingapp.model.MenuCafe;
import id.co.wemppywp.shoppingapp.repository.CafeRepository;

public class CafeListViewModel extends AndroidViewModel {

    private CafeRepository repository;
    private LiveData<List<MenuCafe>> allCafe;

    public CafeListViewModel(@NonNull Application application) {
        super(application);
        repository = new CafeRepository(application);
        allCafe = repository.getAllCafe();
    }

    public void insert(MenuCafe menuCafe){
        repository.insert(menuCafe);
    }

    public void delete(MenuCafe menuCafe){
        repository.delete(menuCafe);
    }

    public LiveData<List<MenuCafe>> getAllCafe(){
        return allCafe;
    }
}
