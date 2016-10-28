package edu.usc.sunset.team7.www.parkhere.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.usc.sunset.team7.www.parkhere.Activities.ResultsActivity;
import edu.usc.sunset.team7.www.parkhere.R;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by kunal on 10/12/16.
 */

public class SearchFragment extends Fragment {

    private Place locationSelected;
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private GoogleApiClient mGoogleApiClient;

    @Override
    public void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        ButterKnife.bind(this, view);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getChildFragmentManager().findFragmentById(R.id.search_autocomplete_fragment);
        Log.i(TAG, "on create view");
        //set location to be the current location
        if (autocompleteFragment != null) {
            Log.i(TAG, "Autocomplete Fragment not null");
            autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(Place place) {
                    locationSelected = place;
                    Log.i(TAG, "Place: " + place.getName());
                    //send over latitude and longitude w/ place.latlng
                }

                @Override
                public void onError(Status status) {// TODO: Handle the error.
                    Log.i(TAG, "An error occurred: " + status);
                }
            });

        }
        return view;
    }

    @OnClick(R.id.search_button)
    protected void startSearch() {
        if (locationSelected != null) {
            LatLng latLng = locationSelected.getLatLng();
            ResultsActivity.startActivity(getActivity(), latLng.latitude, latLng.longitude, 0, 0);
        }
    }

    public void sendLocationToFirebase() {
        if(locationSelected == null) return;

        LatLng latLng = locationSelected.getLatLng();

        //send it over
//        try {
//            String url = "http://www.parkhere-ceccb.appspot.com/?"+
//                    "lat="+latLng.latitude+
//                    "&long="+latLng.longitude;
//            URL servletURL = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) servletURL.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type", "text/plain");
//            connection.setRequestProperty("charset", "utf-8");
//            connection.connect();
//
//            //reading back listings as json
//            InputStream is = connection.getInputStream();
//            JsonReader reader = new JsonReader(new InputStreamReader(is));
//            while(reader.hasNext()) {
//                reader.beginObject();
//
//            }
//        } catch (IOException ioe) {
//            System.out.println(ioe.getMessage());
//        }
    }


}
