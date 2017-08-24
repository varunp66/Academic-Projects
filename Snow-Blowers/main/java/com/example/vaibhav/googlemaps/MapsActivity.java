package com.example.vaibhav.googlemaps;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.vaibhav.googlemaps.R;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Table myDb;
    EditText editName,editPhone;
    Button btnAddData;
    Button btnRetrive;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myDb = new Table(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editPhone = (EditText) findViewById(R.id.editText2_phone);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnRetrive = (Button) findViewById(R.id.retrive);

        AddData();
        viewAll();


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }



    private void setUpMapIfNeeded() {
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

            @Override
            public void onMyLocationChange(Location arg0) {
                // TODO Auto-generated method stub

                mMap.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("Find Me Here"));
            }
        });
    }

    private final LatLng LOCATION_FIND = new LatLng(40.7697,-73.9825);

    public void onClick_Find(View v){
        CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_FIND);
        LatLng my = new LatLng(40.7697,-73.9825);
        mMap.addMarker(new MarkerOptions().position(my).title("Find Me Here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(my));

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        update = CameraUpdateFactory.newLatLngZoom(LOCATION_FIND, 18);
        mMap.animateCamera(update);


    }
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editPhone.getText().toString().equals("") || editName.getText().toString().equals("")||editPhone.getText().toString().matches(".*[a-z].*") ||editPhone.getText().toString().matches(".*[A-Z].*")||editPhone.getText().toString().length()<10) {
                            Toast.makeText(MapsActivity.this, "Please enter a valid Name and PhoneNumber!", Toast.LENGTH_LONG).show();

                        } else {
                            boolean isInserted = myDb.insertData(editName.getText().toString(),
                                    editPhone.getText().toString());
                            if (isInserted = true)
                                Toast.makeText(MapsActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MapsActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                        }


                    }


                }
        );
    }

    public void viewAll(){
        btnRetrive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result = myDb.getRetriveData();
                        if (result.getCount() == 0) {
                            // Show Mesage
                            showMessage("Error", "No Data Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (result.moveToNext()) {
                            buffer.append("Name :" + result.getString(1) + "\n");
                            buffer.append("Phone :" + result.getString(2) + "\n\n");

                        }
                        // Show All Data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }
}





