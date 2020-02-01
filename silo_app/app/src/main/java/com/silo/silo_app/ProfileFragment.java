package com.silo.silo_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        SiloLineChart siloChart = new SiloLineChart((MaterialCardView) view.findViewById(R.id.graph_profile), view.getContext());

        List<Entry> entrie = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            entrie.add(new Entry(i, (float) (i*i*(1+Math.abs(Math.sin(i/10f)))*(Math.random()+2))));
        }
        List<Entry> entrie1 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            entrie1.add(entrie.get(i));
        }
        List<Entry> entrie2 = new ArrayList<>();
        for (int i = 0; i < entrie.size()/12; i++) {
            entrie2.add(entrie.get(i));
        }
        List<Entry> entrie3 = new ArrayList<>();
        for (int i = 0; i < entrie.size()/52; i++) {
            entrie3.add(entrie.get(i));
        }





        try {
            siloChart.newData(entrie3, "week");
        } catch (Exception e){
        }

        TabLayout tb = view.findViewById(R.id.tabs);
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getText().toString()) {
                    case "WEEK":
                        siloChart.newData(entrie3, "week");
                        break;
                    case "MONTH":
                        siloChart.newData(entrie2, "month");
                        break;
                    case "YEAR":
                        siloChart.newData(entrie1, "year");
                        break;
                }
                //siloChart.chart.invalidate();
//                siloChart.chart.

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        mDataSet: List<String> = listOf("Example 1", "Example 2")
        List<String> mDataSet = new ArrayList<String>();
        mDataSet.add("Spring Layout");
        mDataSet.add("Summer Layout");
        mDataSet.add("Fall Layout");

        RecyclerView.LayoutManager viewManager = new LinearLayoutManager(view.getContext());
        RecyclerView.Adapter viewAdapter = new RecyclerAdapter(mDataSet);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(viewManager);
        recyclerView.setAdapter(viewAdapter);

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
