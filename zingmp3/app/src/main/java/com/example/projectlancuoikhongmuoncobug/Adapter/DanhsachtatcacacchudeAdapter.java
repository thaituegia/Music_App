package com.example.projectlancuoikhongmuoncobug.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectlancuoikhongmuoncobug.Activity.DanhsachtatcachudeActivity;
import com.example.projectlancuoikhongmuoncobug.Activity.DanhsachtheloaitheochudeActivity;
import com.example.projectlancuoikhongmuoncobug.Model.ChuDe;
import com.example.projectlancuoikhongmuoncobug.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcacacchudeAdapter extends RecyclerView.Adapter<DanhsachtatcacacchudeAdapter.ViewHolder> {
    Context context;
    ArrayList<ChuDe> mangchude;

    public DanhsachtatcacacchudeAdapter(Context context, ArrayList<ChuDe> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cac_chu_de,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDe chude = mangchude.get(position);
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgchude);
    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgchude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgchude = itemView.findViewById(R.id.imagviewcacchude);
            imgchude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("chude",mangchude.get(getLayoutPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
