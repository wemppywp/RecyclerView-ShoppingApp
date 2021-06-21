package id.co.wemppywp.shoppingapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.co.wemppywp.shoppingapp.model.MenuCafe;

@Dao
public interface CafeDao {

    @Insert
    void insert(MenuCafe menuCafe);

    @Delete
    void delete(MenuCafe menuCafe);

    //untuk dipanggil pada saat recycler view
    @Query("SELECT * FROM cafe_table ORDER BY nama ASC")
    LiveData<List<MenuCafe>> getAllCafe();
}
