package com.example.manotoor.unitedsikhmovement;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by Mano Toor on 6/19/2017.
 */

public class UniversityFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER= "section_number";
    public static final String ARG_UNIVERSITY="university_name";
    private ImageView header_image;
    private TextView pageNumber;
    private TextView longPara;
    private School school;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle args = getArguments();
        school = (School) args.getSerializable(ARG_UNIVERSITY);

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_content,container,false);
        pageNumber = (TextView) rootView.findViewById(R.id.pagenumber);
        pageNumber.setGravity(Gravity.CENTER);
        pageNumber.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
        header_image = (ImageView) rootView.findViewById(R.id.image_header);
        longPara = (TextView) rootView.findViewById(R.id.long_paragraph);
        longPara.setText(R.string.long_paragraph);

        Picasso.with(header_image.getContext()).load(school.getPath()).fit().into(header_image);
        return rootView;

//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_content, container, false);
//
//        TextView textView = new TextView(getActivity());
//        textView.setGravity(Gravity.CENTER);
//        Bundle args = getArguments();
//        school = (School) args.getSerializable(ARG_UNIVERSITY);
//        textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER))+ school.getAcry());
//        header_image = (ImageView) getActivity().findViewById(R.id.image_header);
//        Picasso.with(header_image.getContext()).load(school.getPath()).fit().into(header_image);
//
//        return textView;
    }
}
