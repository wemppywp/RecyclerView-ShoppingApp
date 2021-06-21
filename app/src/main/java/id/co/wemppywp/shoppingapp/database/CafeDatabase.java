package id.co.wemppywp.shoppingapp.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.dao.CafeDao;
import id.co.wemppywp.shoppingapp.model.MenuCafe;
import timber.log.Timber;

@Database(entities = {MenuCafe.class}, version = 1)
public abstract class CafeDatabase extends RoomDatabase {

    private static CafeDatabase instance;

    private static Context activity;

    public abstract CafeDao cafeDao();

    public static synchronized CafeDatabase getInstance(Context context){

        activity = context.getApplicationContext();

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CafeDatabase.class, "cafe_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private CafeDao cafeDao;
        private PopulateDbAsyncTask(CafeDatabase cafeDatabase){
            this.cafeDao = cafeDatabase.cafeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            fillWithStartingData(activity);
            return null;
        }
    }

    private static void fillWithStartingData(Context context){
        CafeDao dao = getInstance(context).cafeDao();

        JSONArray menus = loadJSONArray(context);

        try {
            for (int i = 0; i < menus.length(); i++){
                JSONObject menu = menus.getJSONObject(i);

                String namaMenu = menu.getString("nama");
                String hargaMenu = menu.getString("harga");
                String fotoMenu = menu.getString("foto");

                dao.insert(new MenuCafe(namaMenu, hargaMenu, fotoMenu));

            }
        } catch (JSONException e){
            Timber.d(e, e.getMessage());
        }
    }

    private static JSONArray loadJSONArray(Context context){
        StringBuilder builder = new StringBuilder();
        InputStream in = context.getResources().openRawResource(R.raw.cafe);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;

        try{
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }

            JSONObject jsonObject = new JSONObject(builder.toString());
            return jsonObject.getJSONArray("menus");

        } catch (IOException | JSONException e){
            Timber.d(e, e.getMessage());
        }
        return null;
    }
}
