package materialuitemplate.example.com.materialuitemplate.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Extend this class to create a fragment with a recycler view.
 * This class uses abstraction to force every fragment that extends this
 * class to create the minimal requirements for getting a recycler
 * view up and running.  See the ListFragment class to see an example
 * of this class in use.
 */
abstract public class AbstractRecyclerFragment extends Fragment {

    /**
     * Adapter for the recycler view.  You can use the inner class AbstractRecyclerViewAdapter<T>
     * or define your own.
     */
    protected RecyclerView.Adapter mAdapter;

    /**
     * The recycle view object.  It is created automatically by this class
     * using the Recycler container ID passed into the onCreate() method.
     */
    protected RecyclerView mRecyclerView;

    /**
     *  The layout manager for this recycler fragment.
     */
    protected RecyclerView.LayoutManager mLayoutManager;

    /**
     * Override this method to provide the id of the fragment container
     * for which this fragment will be placed.
     *
     * @return fragment resource container ID
     */
    abstract protected int getLayoutResId();

    /**
     * Get the recycler view container ID
     *
     * @return int
     */
    abstract protected int getRecyclerViewId();

    /**
     * Override to create and set up the adapter that will be used for the recycler view
     *
     * @return  RecyclerView.Adapter
     */
    abstract protected RecyclerView.Adapter getRecyclerAdapter();

    /**
     * Override to create and set up the layout manager that will be used for the recycler view
     *
     * @return RecyclerView.LayoutManager
     */
    abstract protected RecyclerView.LayoutManager getLayoutManager();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutResId(), container, false);
        mAdapter = getRecyclerAdapter();
        mLayoutManager = getLayoutManager();
        mRecyclerView = (RecyclerView) view.findViewById(getRecyclerViewId());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    /**
     * Override this function if you wish to provide
     * your own UI update function
     */
    public void updateUI() {
        if (mAdapter == null) {
            mAdapter = getRecyclerAdapter();
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
