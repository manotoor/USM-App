package com.example.manotoor.unitedsikhmovement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mano Toor on 6/19/2017.
 */

public class UniversityFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER= "section_number";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_content, container, false);

        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        Bundle args = getArguments();
        textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));

        return textView;
    }
}
