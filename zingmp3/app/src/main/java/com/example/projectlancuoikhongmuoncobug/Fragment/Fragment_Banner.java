package com.example.projectlancuoikhongmuoncobug.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.projectlancuoikhongmuoncobug.Adapter.BannerAdapter;
import com.example.projectlancuoikhongmuoncobug.Model.Quangcao;
import com.example.projectlancuoikhongmuoncobug.R;
import com.example.projectlancuoikhongmuoncobug.Service.APIService;
import com.example.projectlancuoikhongmuoncobug.Service.Dataservice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Banner extends Fragment  {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Handler handler;
    Runnable runnable;
    int     curentitem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);
        anhxa();
        GetData();
        return view;
    }

    private void anhxa() {
        viewPager=view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Quangcao>> callback = dataservice.GetDataBanner();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> banners = (ArrayList<Quangcao>) response.body();
                bannerAdapter = new BannerAdapter(getActivity(),banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        curentitem = viewPager.getCurrentItem();
                        curentitem++;
                        if(curentitem>= viewPager.getAdapter().getCount())
                        {
                            curentitem=0;
                        }
                        viewPager.setCurrentItem(curentitem,true);
                        handler.postDelayed(runnable,5000);
                    }
                };
                handler.postDelayed(runnable,5000);
          }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {

            }
        });
    }


}

    

