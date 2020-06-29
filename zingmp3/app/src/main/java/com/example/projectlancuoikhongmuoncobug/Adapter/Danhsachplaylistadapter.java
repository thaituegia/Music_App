package com.example.projectlancuoikhongmuoncobug.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectlancuoikhongmuoncobug.Activity.DanhsachbaihatActivity;
import com.example.projectlancuoikhongmuoncobug.Model.PlayList;
import com.example.projectlancuoikhongmuoncobug.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Danhsachplaylistadapter extends RecyclerView.Adapter<Danhsachplaylistadapter.ViewHolder>{
    Context context;
    ArrayList<PlayList>  mangplaylist;

    public Danhsachplaylistadapter(Context context, ArrayList<PlayList> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_playlist,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayList playList = mangplaylist.get(position);
        Picasso.with(context).load(playList.getHinhPlayList()).into(holder.imghinhnen);
        holder.txttenplaylist.setText(playList.getTen());
    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttenplaylist;

        public ViewHolder(View itemView){
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewdanhsachplaylist);
            txttenplaylist = itemView.findViewById(R.id.textviewtendanhsachcacplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist",mangplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }

    }
}
