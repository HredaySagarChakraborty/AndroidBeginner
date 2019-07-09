package comp.example.hreday.androidbeginner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    String[]tabArray=new String[]{"Tutorial","Quiz","Videos"};
    Integer array=3;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabArray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){


            case 0:
                Tutorial tutorial=new Tutorial();
                return  tutorial;

            case 1:
              Quiz quiz=new Quiz();
              return quiz ;

            case 2:
                Videos videos=new Videos();
                return  videos;

        }


        return null;
    }

    @Override
    public int getCount() {
        return array;
    }
}
