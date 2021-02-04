package com.myapp.collegesocial;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {


    int tabCount;

    public MyPagerAdapter(@NonNull FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabCount = tabCount;
    }

    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                ArtAndCultureFragment artAndCultureFragment = new ArtAndCultureFragment();
                return  artAndCultureFragment;

            case 1:
                SportsAndFitnessFragment sportsAndFitnessFragment = new SportsAndFitnessFragment();
                return  sportsAndFitnessFragment;

            case 2:
                TechnicalAndManagementFragment technicalAndManagementFragment = new TechnicalAndManagementFragment();
                return  technicalAndManagementFragment;
            case 3:
                ExtraFragment extraFragment = new ExtraFragment();
                return extraFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
