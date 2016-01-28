package materialuitemplate.example.com.materialuitemplate.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Extend this class to create a fragment with a recycler view.
 * Check out ListFragment class to see an example of this class in use.
 */
abstract public class AbstractRecyclerFragment extends Fragment {

    /**
     * Adapter for the recycler view.  You can use the inner class AbstractRecyclerViewAdapter<T>
     * or define your own.
     */
    protected RecyclerView.Adapter mAdapter;

    /**
     * The recycle view object.  It is created automatically by this class
     * using the Recylcer container ID passed into the constructor
     */
    protected RecyclerView mRecyclerView;

    @Override
    abstract public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * Initialize the recycler view
     *
     * @param recyclerViewId int ID of the recycler view
     * @param rootView the inflated container view of the fragment
     * @param adapter recycler view adapter
     * @param layoutManager recycler view layout manager
     */
    public void setUpRecyclerView(int recyclerViewId, View rootView, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager) {
        mRecyclerView = (RecyclerView) rootView.findViewById(recyclerViewId);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        assert mRecyclerView != null;
    }

    /**
     * Override to update the recycler list's view
     *
     * @param view
     */
    abstract public void updateUI(View view);

    /**
     * Recycler view adapter class
     *
     * @param <T> Type of model object that will be binded to the view
     */
    abstract public static class AbstractRecyclerViewAdapter<T>
            extends RecyclerView.Adapter<AbstractRecyclerViewAdapter.ViewHolder<T>> {

        protected final List<T> mValues;

        public AbstractRecyclerViewAdapter(List<T> items) {
            mValues = items;
        }

        abstract public ViewHolder<T> createViewHolderTemplate(ViewGroup parent, int viewType);

        @Override
        public ViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
            return createViewHolderTemplate(parent, viewType);
        }

        @Override
        public void onBindViewHolder(final ViewHolder<T> holder, int position) {
            T item = mValues.get(position);
            holder.bindItem(item);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        /**
         * Extend this class to create a viewholder to use to store views for recycler
         *
         * @param <T> Type of model object that will be binded to the view
         */
        abstract public static class ViewHolder<T> extends RecyclerView.ViewHolder {
            //TODO: Extend this class and create member variables to store views to be displayed on the recycler
            public ViewHolder(View view) {
                super(view);
            }

            public static View createView(int list_item_res_id, ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(list_item_res_id, parent, false);
                return view;
            }

            /**
             * Override this function to bind the model object <T> to the list item view
             *
             * @param item
             */
            abstract public void bindItem(T item);
        }
    }

}
