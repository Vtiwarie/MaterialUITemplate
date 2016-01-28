package materialuitemplate.example.com.materialuitemplate.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import materialuitemplate.example.com.materialuitemplate.R;
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
     * This fragment's layout resource ID.
     */
    public static final int LAYOUT_RES_ID = R.layout.fragment_list;

    /**
     * This fragment's container ID
     */
    public static final int FRAGMENT_ID = R.id.fragment_list_container;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Callable mListener;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(LAYOUT_RES_ID, container, false);
        updateUI(view);
        return view;
    }

    @Override
    public void updateUI(View rootView) {
        if (mAdapter == null) {
            DummyContent dummyContent = DummyContent.getInstance();
            List<DummyContent.DummyItem> items = dummyContent.getItems();
            mAdapter = new AbstractRecyclerViewAdapter(items) {
                @Override
                public ViewHolder<DummyContent.DummyItem> createViewHolderTemplate(ViewGroup parent, int viewType) {
                    View view = ListViewHolder.createView(android.R.layout.simple_list_item_1, parent, viewType);
                    return new ListViewHolder(view);
                }
            };

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            setUpRecyclerView(R.id.recycler_list, rootView, mAdapter, layoutManager);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
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

    /**
     * Implement this interface to interact with the calling activity, so that the calling activity
     * can respond accordingly to changes or events triggered by this fragment.
     */
    public interface Callable {
        // TODO: Update argument type and name
        void onFragmentInteraction();
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

    public static class ListViewHolder extends AbstractRecyclerViewAdapter.ViewHolder<DummyContent.DummyItem> {
        private TextView mTextView;

        public ListViewHolder(View view) {
            super(view);

            mTextView = (TextView) view.findViewById(android.R.id.text1);
        }

        @Override
        public void bindItem(DummyContent.DummyItem item) {
            mTextView.setText(item.getContent());
        }
    }
}
