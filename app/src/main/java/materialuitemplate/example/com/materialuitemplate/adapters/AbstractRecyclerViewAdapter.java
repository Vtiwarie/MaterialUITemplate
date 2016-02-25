package materialuitemplate.example.com.materialuitemplate.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Recycler view adapter class
 *
 * @param <T> Type of model object that will be binded to the view
 */
abstract public class AbstractRecyclerViewAdapter<T>
        extends RecyclerView.Adapter<AbstractRecyclerViewAdapter.ViewHolder<T>> {

    protected List<T> mValues;

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
     * Extend this class to create a ViewHolder to use to store views for the recycler.
     *
     * @param <T> Type of model object that will be binded to the view
     */
    abstract public static class ViewHolder<T> extends RecyclerView.ViewHolder {
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
         * @param item that you wish to bind to the recycler view
         */
        abstract public void bindItem(T item);
    }
}
