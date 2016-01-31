package materialuitemplate.example.com.materialuitemplate.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import materialuitemplate.example.com.materialuitemplate.R;
import materialuitemplate.example.com.materialuitemplate.ui.fragment.ListFragment;

/**
 * Main Activity class.
 */
public class MainActivity extends BaseFragmentActivity implements ListFragment.Callable {

    /**
     * Log tag for debugging
     */
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device (sw600dp or greater).
     */
    private boolean mTwoPane;

    /**
     * Toolbar widget.
     */
    private Toolbar mToolbar;

    /**
     * Navigation View widget.
     */
    private NavigationView mNavigationView;

    /**
     * The Navigation Drawer Layout widget.
     */
    private DrawerLayout mDrawerLayout;

    /**
     * Navigation drawer toggle, if using the navigation drawer.
     */
    private ActionBarDrawerToggle mDrawerToggle;

    /**
     * Get the layout ID for this activity.
     *
     * @return int layout resource ID
     */
    protected int getActivityLayoutResId() {
        return R.layout.activity_master_detail;
    }

    @Override
    protected int getMainFragmentLayoutResId() {
        return ListFragment.LAYOUT_RES_ID;
    }

    @Override
    protected int getMainFragmentId() {
        return ListFragment.FRAGMENT_ID;
    }

    /**
     * Get the fragment ID of the detail container
     *
     * @return int detail fragment container ID
     */
    protected int getDetailFragmentId() {
        return R.id.fragment_detail_container;
    }

    @Override
    protected Fragment createFragment() {
        return ListFragment.newInstance(null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutResId());

        if (findViewById(getDetailFragmentId()) != null) {
            mTwoPane = true;
        }

        //Set up the toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getTitle());

        //set up a floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //set up navigation for the activity
        setUpNavigationDrawer();
    }

    /**
     * Set up event handling for the navigation icons.
     * Delete the body of this function and create your
     * own action events.
     */
    private void setUpNavigationActions(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_settings:
                break;
            case R.id.nav_help:
                break;
            case R.id.nav_sub_item_1:
                break;
            case R.id.nav_sub_item_2:
                break;
            default:
                return;
        }
    }

    /**
     * Set up the navigation drawer.
     *
     * @return void
     */
    private void setUpNavigationDrawer() {

        //set up the navigation drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_container);
        mDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.nav_container);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                setUpNavigationActions(item);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Use this function to communicate with fragments within the activity
     * whenever a fragment even has been triggered.
     *
     * ex. In a tablet, you can trigger the detail view to update it's UI
     * whenever a view is clicked from the list/recycler fragment in the
     * master
     */
    public void onFragmentInteraction() {
        //TODO: implement this function to perform updates on containing fragment views
    }

}
