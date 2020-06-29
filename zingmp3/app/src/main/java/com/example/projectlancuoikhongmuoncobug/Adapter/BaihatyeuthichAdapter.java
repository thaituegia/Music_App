package com.example.projectlancuoikhongmuoncobug.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectlancuoikhongmuoncobug.Activity.PlaynhacActivity;
import com.example.projectlancuoikhongmuoncobug.Model.Baihat;
import com.example.projectlancuoikhongmuoncobug.R;
import com.example.projectlancuoikhongmuoncobug.Service.APIService;
import com.example.projectlancuoikhongmuoncobug.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaihatyeuthichAdapter extends RecyclerView.Adapter<BaihatyeuthichAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> baihatyeuthichArrayList;

    public BaihatyeuthichAdapter(Context context, ArrayList<Baihat> baihatyeuthichArrayList) {
        this.context = context;
        this.baihatyeuthichArrayList = baihatyeuthichArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihathot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = baihatyeuthichArrayList.get(position);
        holder.txtcasi.setText(baihat.getCasi());
        holder.txtten.setText(baihat.getTenbaihat());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imghinh);

    }

    @Override
    public int getItemCount() {
        return baihatyeuthichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtten,txtcasi;
        ImageView imghinh, imgluotthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbaihatyeuthich);
            txtcasi = itemView.findViewById(R.id.textviewtencaisibaihathot);
            imghinh = itemView.findViewById(R.id.imageviewbaihatyeuthich);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback =dataservice.Updateluotthich("1",baihatyeuthichArrayList.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if(ketqua.equals("Succes")){
                                Toast.makeText(context,"Da thich", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(context, "loi", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("cakhuc",baihatyeuthichArrayList.get(getLayoutPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
