package com.example.projectlancuoikhongmuoncobug.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectlancuoikhongmuoncobug.Activity.PlaynhacActivity;
import com.example.projectlancuoikhongmuoncobug.Adapter.PlaynhacAdapter;
import com.example.projectlancuoikhongmuoncobug.R;

public class Fragment_play_danh_sach_cac_bai_hat extends Fragment {
    View view;
    RecyclerView recyclerViewplaynhac;
    PlaynhacAdapter playnhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bai_hat,container,false);
        recyclerViewplaynhac = view.findViewById(R.id.recycalerviewPlaybaihat);
        if(PlaynhacActivity.mangbaihat.size()>0){
        playnhacAdapter = new PlaynhacAdapter(getActivity(), PlaynhacActivity.mangbaihat);
        recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewplaynhac.setAdapter(playnhacAdapter);
        }
    return view;
    }
}
