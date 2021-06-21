package id.co.wemppywp.shoppingapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import id.co.wemppywp.shoppingapp.R;

public class DetailMenuActivity extends AppCompatActivity {

    TextView tvNamaMenuDtl, tvHargaMenuDtl;
    ImageView imgMenuDtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.detail));
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        tvNamaMenuDtl = findViewById(R.id.namaMenuDetail);
        tvNamaMenuDtl.setText(intent.getStringExtra("nama"));

        tvHargaMenuDtl = findViewById(R.id.hargaMenuDetail);
        tvHargaMenuDtl.setText("Rp. " + intent.getStringExtra("harga"));

        imgMenuDtl = findViewById(R.id.imageMenuDetail);
        Glide.with(imgMenuDtl)
                .load(intent.getStringExtra("foto"))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
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
