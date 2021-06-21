package id.co.wemppywp.shoppingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.model.MenuCafe;

public class CafeListAdapter extends RecyclerView.Adapter<CafeListAdapter.MyViewHolder> {

    private List<MenuCafe> menuCafeList = new ArrayList<>();
    private CafeListClicklistener clicklistener;

    public CafeListAdapter(CafeListClicklistener clicklistener){
        this.clicklistener = clicklistener;
    }

    public void setMenuCafeList(List<MenuCafe> menuCafeList){
        this.menuCafeList = menuCafeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CafeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cafe, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeListAdapter.MyViewHolder holder, final int position) {
        holder.tvNamaMenu.setText(menuCafeList.get(position).getNama());
        holder.tvHargaMenu.setText("Harga: Rp. " + menuCafeList.get(position).getHarga());

        Glide.with(holder.imgMenu)
                .load(menuCafeList.get(position).getFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.imgMenu);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistener.onItemClick(menuCafeList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuCafeList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamaMenu, tvHargaMenu;
        ImageView imgMenu;

        public MyViewHolder(View view){
            super(view);

            tvNamaMenu = view.findViewById(R.id.namaMenu);
            tvHargaMenu = view.findViewById(R.id.hargaMenu);
            imgMenu = view.findViewById(R.id.imgMenu);
        }
    }

    public interface CafeListClicklistener{
        public void onItemClick (MenuCafe menuCafe);
    }
}

