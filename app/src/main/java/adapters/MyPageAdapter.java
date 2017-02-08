package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import fragments.ScreenSlidePageFragment;

/**
 * Created by ashukuma on 2/7/2017.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {


    public MyPageAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return new ScreenSlidePageFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}