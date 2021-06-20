package id.co.wemppywp.shoppingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.wemppywp.shoppingapp.R;
import id.co.wemppywp.shoppingapp.model.Cafe;

public class CafeListAdapter extends RecyclerView.Adapter<CafeListAdapter.MyViewHolder> {

    private List<Cafe> cafeList;
    private CafeListClicklistener clicklistener;

    public CafeListAdapter(List<Cafe> cafeList, CafeListClicklistener clicklistener){
        this.cafeList = cafeList;
        this.clicklistener = clicklistener;
    }

    @NonNull
    @Override
    public CafeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cafe, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeListAdapter.MyViewHolder holder, final int position) {
        holder.namaCafe.setText(cafeList.get(position).getNama());
        holder.alamatCafe.setText("Alamat:" + cafeList.get(position).getAlamat());

        Glide.with(holder.imageCafe)
                .load(cafeList.get(position).getImage())
                .into(holder.imageCafe);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistener.onItemClick(cafeList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cafeList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView namaCafe;
        TextView alamatCafe;
        ImageView imageCafe;

        public MyViewHolder(View view){
            super(view);

            namaCafe = view.findViewById(R.id.namaCafe);
            alamatCafe = view.findViewById(R.id.alamatCafe);
            imageCafe = view.findViewById(R.id.imgCafe);
        }
    }

    public interface CafeListClicklistener{
        public void onItemClick (Cafe cafe);
    }
}

