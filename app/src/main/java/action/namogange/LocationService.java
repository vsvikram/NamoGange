package action.namogange;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

/**
 * Created by vicky on 8/30/2016.
 */
public class LocationService extends Service implements com.google.android.gms.location.LocationListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    // LogCat tag
    private static final String TAG = "LocationService";


    private LocationRequest locationRequest;
    private Location location;
    private GoogleApiClient googleApiClient;
    private static Location currentLocation = new Location("");

    // Location updates intervals in sec
    private static int UPDATE_INTERVAL = 10000; // 10 sec
    private static int FASTEST_INTERVAL = 5000; // 5 sec
    private static int DISPLACEMENT = 10; // 10 meters

    final Location Loc_HARI_KI_PAURI = new Location("");
    final Location Loc_MANSA_DEVI = new Location("");
    final Location Loc_BHARAT_MATA_MANDIR = new Location("");
    final Location Loc_CHANDI_DEVI_MANDIR = new Location("");
    final Location Loc_VAISHNO_DEVI_MANDIR = new Location("");
    final Location Loc_DAKSHA_MAHADEV_TEMPLE = new Location("");
    final Location Loc_SATI_KHUND = new Location("");
    final Location Loc_SHANTI_KUNJ = new Location("");

    final Location Loc_VIP_GHAT = new Location("");
    final Location Loc_GAU_GHAT = new Location("");
    final Location Loc_KUSHAVARTA_GHAT = new Location("");
    final Location Loc_VISHNU_GHAT = new Location("");
    final Location Loc_BIRLA_GHAT = new Location("");
    final Location Loc_ASTHI_PARVAT_GHAT = new Location("");
    final Location Loc_SHUBHAS_GHAT = new Location("");
    final Location Loc_RAM_GHAT = new Location("");
    final Location Loc_PREM_NAGAR_GHAT = new Location("");
    final Location Loc_SINGH_DWAR_GHAT = new Location("");
    final Location Loc_JATWARA_PUL_GHAT = new Location("");
    final Location Loc_MY_LOCATION = new Location("");
    final Location Loc_GURUKUL_KANGRI = new Location("");
    final Location Loc_FET = new Location("");
    final Location Loc_BAHADARABAD = new Location("");


    @Override
    public void onCreate() {
        super.onCreate();
        Loc_HARI_KI_PAURI.setLatitude(29.956603);
        Loc_HARI_KI_PAURI.setLongitude(78.171496);
        Loc_MANSA_DEVI.setLatitude(29.957632);
        Loc_MANSA_DEVI.setLongitude(78.165240);
        Loc_BHARAT_MATA_MANDIR.setLatitude(29.984871);
        Loc_BHARAT_MATA_MANDIR.setLongitude(78.191897);
        Loc_CHANDI_DEVI_MANDIR.setLatitude(29.993659);
        Loc_CHANDI_DEVI_MANDIR.setLongitude(78.179867);
        Loc_VAISHNO_DEVI_MANDIR.setLatitude(29.930595);
        Loc_VAISHNO_DEVI_MANDIR.setLongitude(78.119500);
        Loc_DAKSHA_MAHADEV_TEMPLE.setLatitude(29.921800);
        Loc_DAKSHA_MAHADEV_TEMPLE.setLongitude(78.145893);
        Loc_SATI_KHUND.setLatitude(29.920582);
        Loc_SATI_KHUND.setLongitude(78.138275);
        Loc_SHANTI_KUNJ.setLatitude(29.988800);
        Loc_SHANTI_KUNJ.setLongitude(78.191895);

        Loc_VIP_GHAT.setLatitude(29.957087);
        Loc_VIP_GHAT.setLongitude(78.173629);
        Loc_GAU_GHAT.setLatitude(29.954063);
        Loc_GAU_GHAT.setLongitude(78.169415);
        Loc_KUSHAVARTA_GHAT.setLatitude(29.953305);
        Loc_KUSHAVARTA_GHAT.setLongitude(78.168668);
        Loc_VISHNU_GHAT.setLatitude(29.951131);
        Loc_VISHNU_GHAT.setLongitude(78.165816);
        Loc_BIRLA_GHAT.setLatitude(29.947786);
        Loc_BIRLA_GHAT.setLongitude(78.161945);
        Loc_ASTHI_PARVAT_GHAT.setLatitude(29.948310);
        Loc_ASTHI_PARVAT_GHAT.setLongitude(78.162265);
        Loc_SHUBHAS_GHAT.setLatitude(29.954771);
        Loc_SHUBHAS_GHAT.setLongitude(78.170109);
        Loc_RAM_GHAT.setLatitude(29.951718);
        Loc_RAM_GHAT.setLongitude(78.166497);
        Loc_PREM_NAGAR_GHAT.setLatitude(29.930107);
        Loc_PREM_NAGAR_GHAT.setLongitude(78.135989);
        Loc_SINGH_DWAR_GHAT.setLatitude(29.926134);
        Loc_SINGH_DWAR_GHAT.setLongitude(78.131732);
        Loc_JATWARA_PUL_GHAT.setLatitude(29.918943);
        Loc_JATWARA_PUL_GHAT.setLongitude(78.103515);

        Loc_GURUKUL_KANGRI.setLatitude(29.923887);
        Loc_GURUKUL_KANGRI.setLongitude(78.127502);
        Loc_FET.setLatitude(29.916866);
        Loc_FET.setLongitude(78.063784);
        Loc_BAHADARABAD.setLatitude(29.921753);
        Loc_GURUKUL_KANGRI.setLongitude(78.042519);

        Loc_MY_LOCATION.setLatitude(29.929978);
        Loc_MY_LOCATION.setLongitude(78.131292);

        final ArrayList<Location> locList = new ArrayList<>();
        locList.add(Loc_HARI_KI_PAURI);
        locList.add(Loc_MANSA_DEVI);
        locList.add(Loc_BHARAT_MATA_MANDIR);
        locList.add(Loc_CHANDI_DEVI_MANDIR);
        locList.add(Loc_VAISHNO_DEVI_MANDIR);
        locList.add(Loc_DAKSHA_MAHADEV_TEMPLE);
        locList.add(Loc_SHANTI_KUNJ);
        locList.add(Loc_GAU_GHAT);
        locList.add(Loc_KUSHAVARTA_GHAT);
        locList.add(Loc_VISHNU_GHAT);
        locList.add(Loc_ASTHI_PARVAT_GHAT);
        locList.add(Loc_SHUBHAS_GHAT);
        locList.add(Loc_GURUKUL_KANGRI);
        locList.add(Loc_FET);

        buildGoogleApiClient();
        createLocationRequest();

        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    protected void createLocationRequest() {
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(UPDATE_INTERVAL);
        locationRequest.setFastestInterval(FASTEST_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setSmallestDisplacement(DISPLACEMENT);
    }

    protected synchronized void buildGoogleApiClient() {
        this.googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        Toast.makeText(getApplicationContext(), "buildGoogleApiClient is called", Toast.LENGTH_LONG).show();
    }

    protected void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        } else {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast.makeText(this, "Location Client is Connected", Toast.LENGTH_LONG).show();
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Toast.makeText(this, "Connection failed", Toast.LENGTH_LONG).show();
    }
}
