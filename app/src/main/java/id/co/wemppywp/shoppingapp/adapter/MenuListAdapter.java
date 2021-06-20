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

import java.util.List;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.model.Menu;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {

    private List<Menu> menuList;
    private MenuListClicklistener clicklistener;

    public MenuListAdapter(List<Menu> menuList, MenuListClicklistener clicklistener){
        this.menuList = menuList;
        this.clicklistener = clicklistener;
    }

    @NonNull
    @Override
    public MenuListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListAdapter.MyViewHolder holder, final int position) {
        holder.tvNamaMenu.setText(menuList.get(position).getNama());
        holder.tvHargaMenu.setText("Harga: Rp." + menuList.get(position).getHarga());

        Glide.with(holder.imgMenu)
                .load(menuList.get(position).getFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgMenu);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistener.onItemClick(menuList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
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

    public interface MenuListClicklistener{
        public void onItemClick(Menu menu);
    }
}

