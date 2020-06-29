package com.example.projectlancuoikhongmuoncobug.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projectlancuoikhongmuoncobug.Adapter.Danhsachplaylistadapter;
import com.example.projectlancuoikhongmuoncobug.Model.PlayList;
import com.example.projectlancuoikhongmuoncobug.R;
import com.example.projectlancuoikhongmuoncobug.Service.APIService;
import com.example.projectlancuoikhongmuoncobug.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcacPlaylistActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachcacplaylist;
    Danhsachplaylistadapter danhsachplaylistadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcac_playlist);
        anhxa();
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<PlayList>> callback = dataservice.GetDanhsachcacPlaylist();
        callback.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                ArrayList<PlayList> mangplaylist = (ArrayList<PlayList>) response.body();
                danhsachplaylistadapter = new Danhsachplaylistadapter(DanhsachcacPlaylistActivity.this,mangplaylist);
                recyclerViewdanhsachcacplaylist.setLayoutManager(new GridLayoutManager(DanhsachcacPlaylistActivity.this,2));
                recyclerViewdanhsachcacplaylist.setAdapter(danhsachplaylistadapter);
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
    }


    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play Lists");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbardanhsachcacplaylist);
        recyclerViewdanhsachcacplaylist = findViewById(R.id.recycalerviewdanhsachcacplaylist);
    }
}