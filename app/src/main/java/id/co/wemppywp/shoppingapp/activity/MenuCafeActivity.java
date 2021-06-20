package id.co.wemppywp.shoppingapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.utilities.Singleton;
import id.co.wemppywp.shoppingapp.adapter.MenuListAdapter;
import id.co.wemppywp.shoppingapp.model.Cafe;
import id.co.wemppywp.shoppingapp.model.Menu;

public class MenuCafeActivity extends AppCompatActivity implements MenuListAdapter.MenuListClicklistener {

    private List<Menu> menuList = null;
    private MenuListAdapter menuListAdapter;

    TextView tvAlamatCafe, tvUser;
    ImageView imgMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cafe);

        Cafe cafe = getIntent().getParcelableExtra("Cafe");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(cafe.getNama());
        actionBar.setDisplayHomeAsUpEnabled(true);

        menuList = cafe.getMenus();

        tvAlamatCafe = findViewById(R.id.alamatCafeDetail);
        tvAlamatCafe.setText(cafe.getAlamat());

        tvUser = findViewById(R.id.userTV);
        tvUser.setText(Singleton.getInstance().getUser());

        imgMenu = findViewById(R.id.imgCafeDetail);
        Glide.with(imgMenu)
                .load(cafe.getImage())
                .into(imgMenu);

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        menuListAdapter = new MenuListAdapter(menuList, this);
        recyclerView.setAdapter(menuListAdapter);
    }

    @Override
    public void onItemClick(Menu menu) {
        Intent intent = new Intent(MenuCafeActivity.this, DetailMenuActivity.class);
        intent.putExtra("Menu", menu);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

