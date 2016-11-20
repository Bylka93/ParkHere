package edu.usc.sunset.team7.www.parkhere.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.ButterKnife;
import edu.usc.sunset.team7.www.parkhere.R;
import edu.usc.sunset.team7.www.parkhere.Utils.Consts;
import edu.usc.sunset.team7.www.parkhere.objectmodule.Listing;
import edu.usc.sunset.team7.www.parkhere.objectmodule.ParkingSpot;

/**
 * Created by johnsonhui on 11/19/16.
 */

public class MyParkingSpacesActivity extends AppCompatActivity {

    public static void startActivityForResult(int requestCode, Activity activity) {
        Intent intent = new Intent(activity, MyParkingSpacesActivity.class);
        activity.startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make xml file
        setContentView(R.layout.activity_my_parking_spaces);
        ButterKnife.bind(this);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final String userID = mAuth.getCurrentUser().getUid();
        final ArrayList<ParkingSpot> userListings = new ArrayList<ParkingSpot>();

        /*DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child
                (Consts.PARKING_SPOT_DATABASE).child(userID).child(Consts.ACTIVE_LISTINGS);*/
    }




}