package com.example.manotoor.unitedsikhmovement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mano Toor on 6/26/2017.
 */

public class RAdapterEvents extends RecyclerView.Adapter<RAdapterEvents.EventHolder> {

    private ArrayList<String> events;
    private Context context;

    public static class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTextView;

        public EventHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.event);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Context context = itemView.getContext();
//            Intent showPhotoIntent = new Intent(context, UniversityActivity.class);
//            showPhotoIntent.putExtra(PHOTO_KEY, university);
//            context.startActivity(showPhotoIntent);

        }
        public void bindEvent(String event){
            mTextView.setText(event);
            //Event = event;
        }
    }

    public RAdapterEvents (Context context, ArrayList<String> events){
        this.events = events;
        this.context = context;
    }

    @Override
    public RAdapterEvents.EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_events_view, parent, false);
        return new EventHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RAdapterEvents.EventHolder holder, int position) {
        String event = events.get(position);
        holder.bindEvent(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
