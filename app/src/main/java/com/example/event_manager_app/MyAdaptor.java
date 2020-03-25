package com.example.event_manager_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder>
{
    private List<Event> mDataset;
    Activity context;
    public MyAdaptor(Activity cxt , List<Event> myDataset) {
        this.context = cxt ;mDataset = myDataset;
    }




    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        // each data item is just a string in this case
        public TextView event_name;
        public TextView event_date;
        // Provide a suitable constructor (depends on the kind of dataset)
        public MyViewHolder(View itemview ) {
            super(itemview );
            event_name = (TextView) itemview.findViewById(R.id.event_name_l);
            event_date = (TextView) itemview.findViewById(R.id.date_l);
        }


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_event,parent,false);
        return new MyViewHolder(rootView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Event event = mDataset.get(position);
        MyAdaptor.MyViewHolder viewHolder= (MyAdaptor.MyViewHolder) holder;

        viewHolder.event_name.setText(event.getEvent_name());
        viewHolder.event_date.setText(event.getDate().toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.toArray().length ;
    }

    public  void setData(List<Event> newData)
    {

        this.mDataset = newData;
        notifyDataSetChanged();

    }
}