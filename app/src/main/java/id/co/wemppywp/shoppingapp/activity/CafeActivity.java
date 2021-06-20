package id.co.wemppywp.shoppingapp.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.utilities.Singleton;
import id.co.wemppywp.shoppingapp.adapter.CafeListAdapter;
import id.co.wemppywp.shoppingapp.model.Cafe;
import timber.log.Timber;

public class CafeActivity extends AppCompatActivity implements CafeListAdapter.CafeListClicklistener{

    TextView TvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.list_cafe));

        List<Cafe> cafeList = getCafeData();

        TvUser = findViewById(R.id.userTV);
        TvUser.setText(Singleton.getInstance().getUser());

        initRecyclerView(cafeList);
    }

    private void initRecyclerView(List<Cafe> cafeList){

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CafeListAdapter adapter = new CafeListAdapter(cafeList, this);
        recyclerView.setAdapter(adapter);

    }

    //read json file
    private List<Cafe> getCafeData(){
        InputStream is = getResources().openRawResource(R.raw.cafe);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try{
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1){
                writer.write(buffer, 0, n);
            }
        }catch (Exception e){
            Timber.d(e, e.getMessage());
        }

        String jsonString = writer.toString();
        Gson gson = new Gson();
        Cafe[] cafes = gson.fromJson(jsonString, Cafe[].class);
        List<Cafe> cfList = Arrays.asList(cafes);

        return cfList;
    }

    @Override
    public void onItemClick(Cafe cafe) {
        Intent intent = new Intent(CafeActivity.this, MenuCafeActivity.class);
        intent.putExtra("Cafe", cafe);
        startActivity(intent);
    }
}
