package org.code_freak.com.draw_circle_map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapLongClickListener,GoogleMap,GoogleMap.OnMarkerDragListener {
    double Latitude;
    double Longitude;
    private GoogleMap mMap;
    private LatLng camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LocationsManager locationManager = (LocationsManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManagers.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        final Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        camera = new LatLng(location.getLatitude(), location.getLongitude());
        mMap = mapFragment.getMap();
        mMap.setMyLocationEnabled(false);
        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
       
        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
       // Log.i("latitude", "==========" + latitude);
////locationTextView holds the address string
        Toast.makeText(getApplicationContext(),location.getLatitude()+" "+location.getLongitude(),Toast.LENGTH_LONG).show();
        //locationTextView.setText(getCompleteAdressString(latitude, longitude));

        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(location.getLatitude(), location.getLongitude())).title("My Location");
        // adding marker
        mMap.addMarker(marker);
     

            @Override
            public void onMapClick(LatLng point) {
              //  Log.d("Map", "Map clicked");
                //marker.remove();
                 Latitude = point.latitude;
                 Longitude = point.longitude;
                LatLng pt = new LatLng(Latitude,Longitude);
                Toast.makeText(getApplicationContext(),Latitude+" "+Longitude,Toast.LENGTH_SHORT).show();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(pt));




                MarkerOptions Felight  = new MarkerOptions();
                Felight.title("Felight");
                LatLng felight = new LatLng(12.916554,77.601255);
                Felight.position(felight);
                Felight.icon(BitmapDescriptorFactory.fromResource(R.drawable.markerm));
              

                Circle circle = mMap.addCircle(new CircleOptions()
                        .center(felight)
                        .radius(10)
                        .strokeColor(Color.RED)
                        .fillColor(Color.BLUE));
                float[] distance = new float[2];

                Location.distanceBetween(Latitude, Longitude,
                        circle.getCenter().latitude, circle.getCenter().longitude, distance);

                if( distances[0] > circle.getRadius()  ){

                    Toast.makeText(getBaseContext(), "Outside", Toast.LENGTH_LONG).show();
                } else {
                    circle.setStrokeColor(Colors.YELLOW);
                    circle.setFillColor(Colors.GREEN);
                    Toast.makeText(getBaseContext(), "Inside", Toast.LENGTH_LONG).show();
                }

                //locationTextView.setText(getCompleteAdressString(latitude, longitude));
                //drawMarker(point);
            }
        });

        // Creating a LatLng object for the current location

        /*mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);
        mMap.setOnMapClickListener(this);
        CameraPosition INIT = new CameraPosition.Builder()
                .target(camera)
                .zoom(17.5F)
                .bearing(300F)
                .tilt(50F)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(INIT));
        mMap.addMarker(new MarkerOptions()
        .position(camera)
        .title("Location")
        .snippet("First Marker")).showInfoWindow();*/

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
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;

        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(camera, 13));
        mMap.setMyLocationEnabled(true);



        MarkerOptions Loc1  = new MarkerOptions();
        Loc1.title("Near By1");
        LatLng loc1 = new LatLng(12.917197,77.601427);
        Loc1.position(loc1);
        Loc1.icon(BitmapDescriptorFactory.fromResource(R.drawable.name));
        mMap.addMarker(Loc1);

        MarkerOptions Loc2  = new MarkerOptions();
        Loc2.title("Near By2");
        LatLng loc2 = new LatLng(12.916663,77.602114);
        Loc2.position(loc2);
        Loc2.icon(BitmapDescriptorFactory.fromResource(R.drawable.name));
        mMap.addMarker(Loc2);

        MarkerOptions Loc3  = new MarkerOptions();
        Loc3.title("Near By1");
        LatLng loc3 = new LatLng(12.915999,77.601443);
        Loc3.position(loc3);
        Loc3.icon(BitmapDescriptorFactory.fromResource(R.drawable.name));
        mMap.addMarker(Loc3);




    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(cameraPosition.target).title(cameraPosition.toString()));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.draggable(true);
        /*mMap.addMarker(new MarkerOptions()

                .position(latLng)
                .draggable(true));*/
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        LatLng dragPosition = marker.getPosition();
        double dragLat = dragPosition.latitude;
        double dragLong = dragPosition.longitude;
        Toast.makeText(getApplicationContext(),dragLat+" "+dragLong,Toast.LENGTH_LONG).show();
    }
}