package edu.uoc.android.daada_pec1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_book_number = "param_book_number";
    private static final String ARG_book_name = "param_book_name";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookDetailFragment newInstance(String param1, String param2) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_book_number, param1);
        args.putString(ARG_book_name, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_book_number);
            mParam2 = getArguments().getString(ARG_book_name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_book_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mParam1 != null && mParam2 != null) {

            String details_text = "Details from book " + mParam1 + " - Title:" + mParam2;
            Log.d("BookDetailFragment", details_text);
            ((TextView) rootView.findViewById(R.id.book_list_detail)).setText(details_text);
        }

        return rootView;

    }
}
