package com.example.btvn.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.btvn.Fragments.bongda_fragment;
import com.example.btvn.Fragments.choban_fragment;
import com.example.btvn.Fragments.congnghe_fragment;
import com.example.btvn.Fragments.doisong_fragment;
import com.example.btvn.Fragments.theodoi_fragment;

public class ViewPagerAdapter2 extends FragmentPagerAdapter {
    public ViewPagerAdapter2(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new theodoi_fragment();
            case 1: return new choban_fragment();
            case 2: return new bongda_fragment();
            case 3: return new congnghe_fragment();
            case 4: return new doisong_fragment();
            default: return new theodoi_fragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Theo dõi";
            case 1: return "Cho bạn";
            case 2: return "Bóng đá";
            case 3: return "Công nghệ";
            case 4: return "Đời sống";
            default: return "Theo dõi";
        }
    }
}
