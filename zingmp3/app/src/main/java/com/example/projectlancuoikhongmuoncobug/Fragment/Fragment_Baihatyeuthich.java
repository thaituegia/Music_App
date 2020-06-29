package com.example.projectlancuoikhongmuoncobug.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectlancuoikhongmuoncobug.Adapter.BaihatyeuthichAdapter;
import com.example.projectlancuoikhongmuoncobug.Model.Baihat;
import com.example.projectlancuoikhongmuoncobug.Model.Baihatyeuthich;
import com.example.projectlancuoikhongmuoncobug.R;
import com.example.projectlancuoikhongmuoncobug.Service.APIService;
import com.example.projectlancuoikhongmuoncobug.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Baihatyeuthich extends Fragment {
    View view;
    RecyclerView recyclerView;
    BaihatyeuthichAdapter baihatyeuthichAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihatyeuthich,container,false);
        recyclerView = view.findViewById(R.id.recyclerviewbaihathot);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> Callback = dataservice.GetBaihatyeuthich();
        Callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> baihatyeuthichArrayList = (ArrayList<Baihat>) response.body();
                baihatyeuthichAdapter = new BaihatyeuthichAdapter(getActivity(),baihatyeuthichArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(baihatyeuthichAdapter);

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });

    }
}
