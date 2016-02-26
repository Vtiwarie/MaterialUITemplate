package materialuitemplate.example.com.materialuitemplate.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import materialuitemplate.example.com.materialuitemplate.R;
import materialuitemplate.example.com.materialuitemplate.adapters.AbstractRecyclerViewAdapter;
import materialuitemplate.example.com.materialuitemplate.dummy.DummyContent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Callable} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends AbstractRecyclerFragment {

    /**
     * Callable object to interact with calling activity
     */
    protected Callable mListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void updateUI() {
        //TODO: Delete this call to the superclass if you desire to create your own update function
        super.updateUI();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_list;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recycler_container;
    }

    @Override
    protected RecyclerView.Adapter getRecyclerAdapter() {
        DummyContent dummyContent = DummyContent.getInstance();
        List<DummyContent.DummyItem> items = dummyContent.getItems();
        return new AbstractRecyclerViewAdapter(items) {
            @Override
            public ViewHolder<DummyContent.DummyItem> createViewHolderTemplate(ViewGroup parent, int viewType) {
                View view = ListViewHolder.createView(R.layout.list_item, parent, viewType);
                return new ListViewHolder(view);
            }
        };
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callable) {
            mListener = (Callable) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //TODO: Add menu item options here for fragment-specific actions
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Extend the ViewHolder class defined in the AbtractRecyclerFragment class.
     */
    private class ListViewHolder extends AbstractRecyclerViewAdapter.ViewHolder<DummyContent.DummyItem> {
        private TextView mTextView;
        private ImageView mImageView;

        public ListViewHolder(View view) {
            super(view);

            mTextView = (TextView) view.findViewById(android.R.id.text1);
            mImageView = (ImageView) view.findViewById(R.id.image_list_icon);
        }

        @Override
        public void bindItem(DummyContent.DummyItem item) {

            mTextView.setText(item.getContent());
            Glide.with(getActivity())
                    .load(item.getImage())
                    .asBitmap()
                    .centerCrop()
                    .thumbnail(0.1f)
                    .into(new BitmapImageViewTarget(mImageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    mImageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }


    // TODO: Override this method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    /**
     * Implement this interface to interact with the calling activity, so that the calling activity
     * can respond accordingly to changes or events triggered by this fragment.
     */
    public interface Callable {
        // TODO: Update argument type and name
        void onFragmentInteraction();

    }
}
