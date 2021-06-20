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

    TextView tvNamaMenuDtl, tvHargaMenuDtl;
    ImageView imgMenuDtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        Menu menu = getIntent().getParcelableExtra("Menu");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.detail));
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvNamaMenuDtl = findViewById(R.id.namaMenuDetail);
        tvNamaMenuDtl.setText(menu.getNama());

        tvHargaMenuDtl = findViewById(R.id.hargaMenuDetail);
        tvHargaMenuDtl.setText("Rp. " + String.valueOf(menu.getHarga()));

        imgMenuDtl = findViewById(R.id.imageMenuDetail);
        Glide.with(imgMenuDtl)
                .load(menu.getFoto())
                .into(imgMenuDtl);
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
