package materialuitemplate.example.com.materialuitemplate.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Adapter to display tabs
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter{

    /**
     * List of fragments to display
     */
    private Fragment[] mFragments;

    /**
     * Tab titles
     */
    private String[] mTitles;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(Fragment[] fragments) {
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    /**
     * Set the tab titles
     *
     * @param titles
     */
    public void setTitles(String[] titles) {
        mTitles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
