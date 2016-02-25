package materialuitemplate.example.com.materialuitemplate.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Use this class to create fragment-based activities, in which
 * the activity has at least one fragment.
 * Main Fragment is the fragment that contains the main part of the
 * layout, such as list/recycler views, tab layouts, etc...
 */
abstract public class BaseFragmentActivity extends AppCompatActivity {

    /**
     * Create the main fragment to be displayed in the activity.
     *
     * @return Fragment to create
     */
    abstract protected Fragment createFragment();

    /**
     * Resource ID for the main fragment.
     *
     * @return int fragment layout resource file ID
     */
    @LayoutRes
    abstract protected int getMainFragmentLayoutResId();

    /**
     * Retrieve the main fragment's container ID.
     *
     * @return int fragment ID
     */
    abstract protected int getMainFragmentId();

    /**
     * Layout ID of the main activity, not fragment.
     *
     * @return int activity layout resource file ID
     */
    abstract protected int getActivityLayoutResId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getMainFragmentLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(getMainFragmentId());

        if(fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(getMainFragmentId(), fragment)
                    .commit();
        }
    }
}
