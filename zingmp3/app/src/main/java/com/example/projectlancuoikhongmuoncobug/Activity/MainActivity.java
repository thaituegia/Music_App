package com.example.projectlancuoikhongmuoncobug.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.projectlancuoikhongmuoncobug.Adapter.MainViewPagerAdapter;
import com.example.projectlancuoikhongmuoncobug.Fragment.Fragment_TIm_Kiem;
import com.example.projectlancuoikhongmuoncobug.Fragment.Fragment_Trang_Chu;
import com.example.projectlancuoikhongmuoncobug.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();

    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(),"Trang Chủ");
        mainViewPagerAdapter.addFragment(new Fragment_TIm_Kiem(),"Tìm Kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.timkiem);
    }

    private void
    anhxa(){
            tabLayout=findViewById(R.id.myTabLayout);
            viewPager = findViewById(R.id.myViewPager);
    }
}
