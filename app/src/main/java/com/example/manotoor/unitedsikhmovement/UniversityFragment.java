package com.example.manotoor.unitedsikhmovement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mano Toor on 6/19/2017.
 */

public class UniversityFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER= "section_number";
    public static final String ARG_UNIVERSITY="university_name";
    Bundle args;

    private ImageView header_image;
    private ViewGroup rootView;
    private TextView upcomingEvents;
    private TextView pastEvents;
    private School school;
    private RecyclerView mRecyclerViewUpcoming;
    private RecyclerView mRecyclerViewPast;
    private LinearLayoutManager mLinearlayoutManager;
    private LinearLayoutManager mLinearlayoutManagerPast;

    public UniversityFragment() {
        //Empty Constructor
    }

    public static UniversityFragment newInstance(School school) {
        UniversityFragment fragment = new UniversityFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_UNIVERSITY, school);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            args = getArguments();
            school = (School) args.getSerializable(ARG_UNIVERSITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init(inflater,container);

        return rootView;

//        TextView textView = new TextView(getActivity());
//        textView.setGravity(Gravity.CENTER);
//        textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER))+ school.getAcry());
//        return textView;
    }
    private void init(LayoutInflater inflater, ViewGroup container){
        //Inflate Root
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_university,container,false);

        //Instantiate Views
        header_image = (ImageView) rootView.findViewById(R.id.image_header);
        //Set Focus to false because it will force view to bottom

        //UPCOMING/CURRENT
        upcomingEvents = (TextView) rootView.findViewById(R.id.upcoming_events);
        mRecyclerViewUpcoming = (RecyclerView) rootView.findViewById(R.id.recyclerViewEvents);
        mRecyclerViewUpcoming.setFocusable(false);
        mLinearlayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerViewUpcoming.setLayoutManager(mLinearlayoutManager);
        //PAST EVENTS
        pastEvents = (TextView) rootView.findViewById(R.id.past_events);
        mRecyclerViewPast = (RecyclerView) rootView.findViewById(R.id.recyclerViewPastEvents);
        mRecyclerViewPast.setFocusable(false);
        mLinearlayoutManagerPast = new LinearLayoutManager(rootView.getContext());
        mRecyclerViewPast.setLayoutManager(mLinearlayoutManagerPast);

        //Recycler
        ArrayList<String> eventList = getData();
        RAdapterEvents adapter = new RAdapterEvents(rootView.getContext(),eventList);
        RAdapterEvents past_adapter = new RAdapterEvents(rootView.getContext(),eventList);
        mRecyclerViewUpcoming.setAdapter(adapter);
        mRecyclerViewPast.setAdapter(past_adapter);

        //Loading Views
        Picasso.with(header_image.getContext()).load(school.getPath()).fit().into(header_image);
        upcomingEvents.setText(R.string.upcomingEvents);
        pastEvents.setText(R.string.pastEvents);
    }
    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Event: SSA\nDate:1/1/2019\nTime:12:30PM");
        list.add("Event:\nDate:\nTime:");
        list.add("Event:\nDate:\nTime:");
        list.add("Event:\nDate:\nTime:");
        list.add("Event:\nDate:\nTime:");
        list.add("Event:\nDate:\nTime:");
        list.add("Event:\nDate:\nTime:");
        list.add("Event:\nDate:\nTime:");
        return list;
    }
}
