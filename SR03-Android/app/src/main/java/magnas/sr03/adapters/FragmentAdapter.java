package magnas.sr03.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import magnas.sr03.R;
import magnas.sr03.fragments.NameFragment;
import magnas.sr03.fragments.StructureFragment;

/**
 * Created by Gregory on 03/04/2016.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private List<String> mTabNames;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mTabNames = new ArrayList<>();
        mTabNames.add(context.getString(R.string.name_tab_title));
        mTabNames.add(context.getString(R.string.struct_tab_title));
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new NameFragment();
            case 1 : return new StructureFragment();
            default : return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabNames.get(position);
    }
}
