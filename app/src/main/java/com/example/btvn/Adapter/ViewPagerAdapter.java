package com.example.btvn.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.btvn.Fragments.AccountFragment;
import com.example.btvn.Fragments.HomeFrgament;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFrgament();
            case 1:
                return new AccountFragment();
            default: return new HomeFrgament();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
