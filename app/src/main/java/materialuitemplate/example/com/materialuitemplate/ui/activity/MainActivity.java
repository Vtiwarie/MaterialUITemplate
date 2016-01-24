package materialuitemplate.example.com.materialuitemplate.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import materialuitemplate.example.com.materialuitemplate.R;
import materialuitemplate.example.com.materialuitemplate.ui.fragment.ListFragment;

/**
 * Main Activity class.
 */
public class MainActivity extends BaseFragmentActivity implements ListFragment.Callable {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device (sw600dp or greater)
     */
    private boolean mTwoPane;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     *
     */
    public void onFragmentInteraction() {

    }

}
