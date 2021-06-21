package id.co.wemppywp.shoppingapp.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.model.MenuCafe;
import id.co.wemppywp.shoppingapp.utilities.Singleton;
import id.co.wemppywp.shoppingapp.adapter.CafeListAdapter;
import id.co.wemppywp.shoppingapp.viewmodel.CafeListViewModel;

public class CafeActivity extends AppCompatActivity implements CafeListAdapter.CafeListClicklistener {

    TextView TvUser;
    private CafeListAdapter cafeListAdapter;
    private CafeListViewModel cafeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.list_cafe));

        TvUser = findViewById(R.id.userTV);
        TvUser.setText(Singleton.getInstance().getUser());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cafeListAdapter = new CafeListAdapter(this);
        recyclerView.setAdapter(cafeListAdapter);

        cafeListViewModel = ViewModelProviders.of(this).get(CafeListViewModel.class);
        cafeListViewModel.getAllCafe().observe(this, new Observer<List<MenuCafe>>() {
            @Override
            public void onChanged(List<MenuCafe> menuCafeList) {
                cafeListAdapter.setMenuCafeList(menuCafeList);
            }
        });
    }

    @Override
    public void onItemClick(MenuCafe menuCafe) {
        Intent intent = new Intent(CafeActivity.this, DetailMenuActivity.class);
        intent.putExtra("nama", menuCafe.getNama());
        intent.putExtra("harga", menuCafe.getHarga());
        intent.putExtra("foto", menuCafe.getFoto());
        startActivity(intent);
    }
}
