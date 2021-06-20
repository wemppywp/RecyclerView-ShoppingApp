package id.co.wemppywp.shoppingapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.model.Cafe;
import id.co.wemppywp.shoppingapp.model.Menu;

public class DetailMenuActivity extends AppCompatActivity {

    TextView namaMenuDetail, hargaMenuDetail;
    ImageView imgMenuDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        Menu menu = getIntent().getParcelableExtra("Menu");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);

        namaMenuDetail = findViewById(R.id.namaMenuDetail);
        namaMenuDetail.setText(menu.getNama());

        hargaMenuDetail = findViewById(R.id.hargaMenuDetail);
        hargaMenuDetail.setText("Rp. " + String.valueOf(menu.getHarga()));

        imgMenuDetail = findViewById(R.id.imageMenuDetail);
        Glide.with(imgMenuDetail)
                .load(menu.getFoto())
                .into(imgMenuDetail);
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
