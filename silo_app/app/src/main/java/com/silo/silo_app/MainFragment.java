package com.silo.silo_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView graph_rc = view.findViewById(R.id.gragh_recycler);

        List<List<Entry>> entries = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> types = new ArrayList<>();

        List<Entry> susEntry = Arrays.asList(new Entry(0.7f, 1));
        List<Entry> envEntry = Arrays.asList(new Entry(0.9f, 1));

        List<Entry> waterEntry = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            waterEntry.add(new Entry(i, (float) Math.sin(i/200)));
        }
        List<Entry> powerEntry = new ArrayList<>();
        for (int i = 0; i < 1200; i++) {
            powerEntry.add(new Entry(i, i*i));
        }
        List<Entry> tempEntry = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            tempEntry.add(new Entry(i, i*1.1f));
        }

        entries.add(susEntry);
        titles.add("Sustainability Index");
        types.add("score");

        entries.add(envEntry);
        titles.add("Environmental Index");
        types.add("score");

        entries.add(waterEntry);
        titles.add("Water Use");
        types.add("line");

        entries.add(powerEntry);
        titles.add("Power Use");
        types.add("line");

        entries.add(tempEntry);
        titles.add("Building Temperature");
        types.add("line");

        ChartAdaptor adaptor = new ChartAdaptor(entries, titles, types, getContext());
        graph_rc.setDividerHeight(0);
        graph_rc.setAdapter(adaptor);

        //charts -- mult lines //2560X1312



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
