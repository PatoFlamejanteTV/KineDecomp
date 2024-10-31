package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import java.util.Calendar;

/* loaded from: classes.dex */
class TwilightManager {

    /* renamed from: a */
    private static TwilightManager f2214a;

    /* renamed from: b */
    private final Context f2215b;

    /* renamed from: c */
    private final LocationManager f2216c;

    /* renamed from: d */
    private final TwilightState f2217d = new TwilightState();

    /* loaded from: classes.dex */
    public static class TwilightState {

        /* renamed from: a */
        boolean f2218a;

        /* renamed from: b */
        long f2219b;

        /* renamed from: c */
        long f2220c;

        /* renamed from: d */
        long f2221d;

        /* renamed from: e */
        long f2222e;

        /* renamed from: f */
        long f2223f;

        TwilightState() {
        }
    }

    TwilightManager(Context context, LocationManager locationManager) {
        this.f2215b = context;
        this.f2216c = locationManager;
    }

    public static TwilightManager a(Context context) {
        if (f2214a == null) {
            Context applicationContext = context.getApplicationContext();
            f2214a = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService(PlaceFields.LOCATION));
        }
        return f2214a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location a2 = PermissionChecker.checkSelfPermission(this.f2215b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location a3 = PermissionChecker.checkSelfPermission(this.f2215b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    private boolean c() {
        return this.f2217d.f2223f > System.currentTimeMillis();
    }

    public boolean a() {
        TwilightState twilightState = this.f2217d;
        if (c()) {
            return twilightState.f2218a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return twilightState.f2218a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location a(String str) {
        try {
            if (this.f2216c.isProviderEnabled(str)) {
                return this.f2216c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private void a(Location location) {
        long j;
        TwilightState twilightState = this.f2217d;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator a2 = TwilightCalculator.a();
        a2.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.sunset;
        a2.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.state == 1;
        long j3 = a2.sunrise;
        long j4 = a2.sunset;
        boolean z2 = z;
        a2.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.sunrise;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        twilightState.f2218a = z2;
        twilightState.f2219b = j2;
        twilightState.f2220c = j3;
        twilightState.f2221d = j4;
        twilightState.f2222e = j5;
        twilightState.f2223f = j;
    }
}
