package edu.usc.sunset.team7.www.parkhere.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import edu.usc.sunset.team7.www.parkhere.Activities.ParkingSpotDetailsActivity;
import edu.usc.sunset.team7.www.parkhere.R;
import edu.usc.sunset.team7.www.parkhere.Utils.Consts;
import edu.usc.sunset.team7.www.parkhere.objectmodule.ParkingSpot;

/**
 * Created by kunal on 11/19/16.
 */

public class CustomParkingSpaceSelectionAdapter extends BaseAdapter {
    private ParkingSpot[] myParkingSpaces;
    private static LayoutInflater inflater = null;
    private Context context;

    public CustomParkingSpaceSelectionAdapter(Activity activity, ParkingSpot[] allParkingSpaces) {
        this.context = activity;
        this.myParkingSpaces = allParkingSpaces;
    }

    @Override
    public int getCount() {
        return myParkingSpaces.length;
    }

    @Override
    public Object getItem(int i) {
        if (i < myParkingSpaces.length && i >= 0) {
            return myParkingSpaces[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemShell item;
        View rowView = view;
        if(rowView == null) {
            inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(R.layout.parking_spot_view, viewGroup, false);

            item = new ItemShell();
            item.parkingLabel = (TextView) rowView.findViewById(R.id.parking_spot_name_label);
            item.imgView = (ImageView) rowView.findViewById(R.id.parking_spot_image);
            rowView.setTag(item);

        } else {
            item = (ItemShell) rowView.getTag();
        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: IMPLEMENT THIS TO RETURN THE OBJECT FOR ACTIVITY RESULT
            }
        });

        ParkingSpot currentSpace = (ParkingSpot)getItem(i);

        Picasso.with(this.context).load(currentSpace.getImageURL()).into(item.imgView);
        item.parkingLabel.setText(currentSpace.getName());

        return rowView;
    }

    private class ItemShell {
        TextView parkingLabel;
        ImageView imgView;
    }

}
