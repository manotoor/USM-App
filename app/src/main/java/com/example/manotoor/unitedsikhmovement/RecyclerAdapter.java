package com.example.manotoor.unitedsikhmovement;

/**
 * Created by Mano Toor on 6/14/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PhotoHolder> {

    private ArrayList<School> schools;
    private static String mPhoto = "****";
    private static String PHOTO_KEY ="****";
    private Context context;

    public static class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mItemImage;
        private TextView mItemText,mItemTextTwo;


        public PhotoHolder(View v){
            super(v);
            mItemImage = (ImageView) v.findViewById(R.id.school_image);
            mItemText = (TextView) v.findViewById(R.id.university_name);
            mItemTextTwo = (TextView) v.findViewById(R.id.university_acry);
            v.setOnClickListener(this);
        }

        public void bindPhoto(String photo){
            //mPhoto = photo;
            //Picasso.with(mItemImage.getContext()).load(R.drawable.mPhoto).into(mItemImage);
        }

        @Override
        public void onClick(View v){
            Context context = itemView.getContext();
            Intent showPhotoIntent = new Intent(context, UniversityActivity.class);
            showPhotoIntent.putExtra(String.valueOf(PHOTO_KEY), String.valueOf(mPhoto));
            context.startActivity(showPhotoIntent);
        }
    }

    public RecyclerAdapter(Context context, ArrayList<School> schools){
        this.schools = schools;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_school_view, parent, false);
        return new PhotoHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PhotoHolder holder, int position) {
        Picasso.with(context).load(schools.get(position).getPath()).fit().into(holder.mItemImage);
        holder.mItemText.setText(schools.get(position).getName());
        holder.mItemTextTwo.setText(schools.get(position).getAcry());
        mPhoto = schools.get(position).getName();
        PHOTO_KEY = Integer.toString(position);
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    private int getScreenHeight(Context context) {
        int height;

        if (android.os.Build.VERSION.SDK_INT >= 13) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            height = size.y;
        } else {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            height = display.getHeight();  // deprecated
        }

        return height;
    }

    private int getScreenWidth(Context context) {
        int width;

        if (android.os.Build.VERSION.SDK_INT >= 13) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            Log.i("WIDTH",String.valueOf(width));
        } else {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            width = display.getWidth();  // deprecated
        }

        return width;
    }
}
