package digi.coders.koibandaapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import digi.coders.koibandaapp.Fragments.Tutor1Fragment;
import digi.coders.koibandaapp.Fragments.Tutor2Fragment;
import digi.coders.koibandaapp.Fragments.Tutor3Fragment;
import digi.coders.koibandaapp.Fragments.Tutor4Fragment;
import digi.coders.koibandaapp.Fragments.Tutor5Fragment;
import digi.coders.koibandaapp.Fragments.Tutor6Fragment;

public class TutorViewPagerAdapter extends FragmentPagerAdapter{
    int tabcount;

    public TutorViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount =behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tutor1Fragment();
            case 1:
                return new Tutor2Fragment();
            case 2:
                return new Tutor3Fragment();
            case 3:
                return new Tutor4Fragment();
            case 4:
                return new Tutor5Fragment();
            case 5:
                return new Tutor6Fragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
