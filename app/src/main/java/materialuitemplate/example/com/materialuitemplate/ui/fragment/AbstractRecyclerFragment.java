package materialuitemplate.example.com.materialuitemplate.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Extend this class to create a fragment with a recycler view
 */
abstract public class AbstractRecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;

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
    public void setUpRecyclerView(int recyclerViewId, View rootView, AbstractRecyclerViewAdapter adapter, RecyclerView.LayoutManager layoutManager) {
        mRecyclerView = (RecyclerView) rootView.findViewById(recyclerViewId);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
        assert mRecyclerView != null;
    }

    /**
     * Recycler view adapter class
     *
     * @param <T> Type of model object that will be binded to the view
     */
    abstract public static class AbstractRecyclerViewAdapter<T>
            extends RecyclerView.Adapter<AbstractRecyclerViewAdapter.ViewHolder<T>> {

        protected final List<T> mValues;
        protected int mListViewLayout;
        protected ViewHolder<T> mViewHolder;

        public AbstractRecyclerViewAdapter(int listViewLayout, List<T> items, ViewHolder<T> viewHolder) {
            mValues = items;
            mListViewLayout = listViewLayout;
            mViewHolder = viewHolder;
        }

        protected View createView(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(mListViewLayout, parent, false);
            return view;
        }

        @Override
        public ViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
            return mViewHolder;
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

            /**
             * Bind object of type T to the recycler view
             *
             * @param item
             */
            abstract public void bindItem(T item);
        }
    }

}
