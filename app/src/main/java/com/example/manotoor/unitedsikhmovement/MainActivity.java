package com.example.manotoor.unitedsikhmovement;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.R.drawable.ic_menu_help;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearlayoutManager;
    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.app_name);

        initViews();
    }
    private void initViews(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearlayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearlayoutManager);

        ArrayList<School> schoolsArrayList = getData();
        RecyclerAdapter adapter = new RecyclerAdapter(this,schoolsArrayList);
        mRecyclerView.setAdapter(adapter);
    }

    private ArrayList<School> getData(){
        Resources res = getResources();
        String[] schools = res.getStringArray(R.array.school_names);
        String[] acronyms = res.getStringArray(R.array.acryonyms);
        //Map<String, String> as = new HashMap<>(schools.length);

        ArrayList<School> mSchool = new ArrayList<School>();
        //TODO: Get rid of hard coding "usm" and "united sikh movement" - bad practice and possible leaks
        School usm = new School();
        usm.setPath(R.drawable.usm);
        usm.setAcry(getString(R.string.app_label));
        usm.setName(getString(R.string.app_name));
        usm.setLogo(ic_menu_help);
        mSchool.add(usm);
        for(int i=0; i < schools.length;i++){
            School uni = new School();//Make a School Object

            /* DYNAMIC WAY TO GET IMAGE RESOURCE
             * Now if you ever want to change the list, we change the string xml and it'll do everything for us
              * with proper naming of images
              *
              * TODO EVENTUALLY MAKE A WEBSITE THAT HOSTS JSON OBJECTS THAT HOLD SCHOOL INFORMATION
              * */
            String uri = getString(R.string.drawable) +acronyms[i].toLowerCase();
            int imageResource = getResources().getIdentifier(uri+getString(R.string.school), null, getPackageName());
            int logoResource = getResources().getIdentifier(uri+getString(R.string.logo),null,getPackageName());

            //Avoid Null Pointers, By default display USM Image
            if(imageResource == 0) imageResource = R.drawable.usm;
            if(logoResource == 0) logoResource = ic_menu_help;

            //as.put(acronyms[i],schools[i]);                                 //Map each School acronym to full name
            uni.setName(schools[i]);                               //Set School name to non acronym
            uni.setAcry(acronyms[i]);
            uni.setPath(imageResource);
            uni.setLogo(logoResource);
//            /*TODO: Refactor more code ---> Figure a way to compare acronym with letters in resources drawable... DONE
//            */
//            switch(acronyms[i]){                                            //Probably have to hardcode until we find a better way
//                case "CC":
//                    uni.setAcry(acronyms[0]);
//                    uni.setPath(R.drawable.cc_school);
//                    break;
//                case "CPP":
//                    uni.setAcry(acronyms[1]);
//                    uni.setPath(R.drawable.cpp_school);
//                    break;
//                case "CSUF":
//                    //uni.setName(as.get(acronyms[2]));
//                    uni.setAcry(acronyms[2]);
//                    uni.setPath(R.drawable.csuf_school);
//                    break;
//                case "FSU":
//                    //uni.setName(as.get(acronyms[3]));
//                    uni.setAcry(acronyms[3]);
//                    uni.setPath(R.drawable.acronyms[i]_school);
//                    break;
//                case "UCB":
//                    //uni.setName(as.get(acronyms[4]));
//                    uni.setAcry(acronyms[4]);
//                    uni.setPath(R.drawable.ucb_school);
//                    break;
//                case "UCD":
//                    //uni.setName(as.get(acronyms[5]));
//                    uni.setAcry(acronyms[5]);
//                    uni.setPath(R.drawable.ucd_school);
//                    break;
//                case "UCI":
//                    //uni.setName(as.get(acronyms[6]));
//                    uni.setAcry(acronyms[6]);
//                    uni.setPath(R.drawable.uci_school);
//                    break;
//                case "UCLA":
//                    //uni.setName(as.get(acronyms[7]));
//                    uni.setAcry(acronyms[7]);
//                    uni.setPath(R.drawable.ucla_school);
//                    break;
//                case "UCR":
//                    //uni.setName(as.get(acronyms[8]));
//                    uni.setAcry(acronyms[8]);
//                    uni.setPath(R.drawable.ucr_school);
//                    break;
//                case "UCSC":
//                    //uni.setName(as.get(acronyms[9]));
//                    uni.setAcry(acronyms[9]);
//                    uni.setPath(R.drawable.ucsc_school);
//                    break;
//                case "UCSD":
//                    //uni.setName(as.get(acronyms[10]));
//                    uni.setAcry(acronyms[10]);
//                    uni.setPath(R.drawable.ucsd_school);
//                    break;
//                case "USC":
//                    //uni.setName(as.get(acronyms[11]));
//                    uni.setAcry(acronyms[11]);
//                    uni.setPath(R.drawable.usc_school);
//                    break;
//
//                default:
//                    //Should never get here
//                    break;
//            }
            mSchool.add(uni);
        }


        return mSchool;
    }
}
