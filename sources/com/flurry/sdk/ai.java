package com.flurry.sdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.flurry.sdk.af;

/* loaded from: classes.dex */
public class ai implements af.a {
    private static final String c = ai.class.getSimpleName();
    private static ai l;
    boolean b;
    private LocationManager f;
    private Criteria g;
    private Location h;
    private String j;
    private final long d = 1800000;
    private final long e = 0;

    /* renamed from: a, reason: collision with root package name */
    boolean f456a = false;
    private int k = 0;
    private a i = new a();

    private ai() {
        af a2 = ae.a();
        this.g = (Criteria) a2.a("LocationCriteria");
        a2.a("LocationCriteria", (af.a) this);
        as.a(4, c, "initSettings, LocationCriteria = " + this.g);
        this.b = ((Boolean) a2.a("ReportLocation")).booleanValue();
        a2.a("ReportLocation", (af.a) this);
        as.a(4, c, "initSettings, ReportLocation = " + this.b);
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            if (l == null) {
                l = new ai();
            }
            aiVar = l;
        }
        return aiVar;
    }

    public synchronized void b() {
        if (this.f == null) {
            this.f = (LocationManager) ad.a().b().getSystemService("location");
        }
    }

    public synchronized void c() {
        as.a(4, c, "Location provider subscribed");
        this.k++;
        if (!this.f456a) {
            h();
        }
    }

    public synchronized void d() {
        as.a(4, c, "Location provider unsubscribed");
        if (this.k <= 0) {
            as.a(6, c, "Error! Unsubscribed too many times!");
        } else {
            this.k--;
            if (this.k == 0) {
                g();
            }
        }
    }

    private void g() {
        this.f.removeUpdates(this.i);
        this.f456a = false;
        as.a(4, c, "LocationProvider stoped");
    }

    private void h() {
        if (this.b) {
            Context b = ad.a().b();
            if (b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                g();
                String i = i();
                a(i);
                this.h = b(i);
                this.f456a = true;
                as.a(4, c, "LocationProvider started");
            }
        }
    }

    private String i() {
        String str;
        Criteria criteria = this.g;
        if (criteria == null) {
            criteria = new Criteria();
        }
        if (TextUtils.isEmpty(this.j)) {
            str = this.f.getBestProvider(criteria, true);
        } else {
            str = this.j;
        }
        as.a(4, c, "provider = " + str);
        return str;
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f.requestLocationUpdates(str, 1800000L, 0.0f, this.i, Looper.getMainLooper());
        }
    }

    private Location b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f.getLastKnownLocation(str);
    }

    public Location e() {
        Location location = null;
        if (this.b) {
            Location b = b(i());
            if (b != null) {
                this.h = b;
            }
            location = this.h;
        }
        as.a(4, c, "getLocation() = " + location);
        return location;
    }

    public void f() {
        this.k = 0;
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                ai.this.h = location;
            }
        }
    }

    @Override // com.flurry.sdk.af.a
    public void a(String str, Object obj) {
        if (str.equals("LocationCriteria")) {
            this.g = (Criteria) obj;
            as.a(4, c, "onSettingUpdate, LocationCriteria = " + this.g);
            if (this.f456a) {
                h();
                return;
            }
            return;
        }
        if (str.equals("ReportLocation")) {
            this.b = ((Boolean) obj).booleanValue();
            as.a(4, c, "onSettingUpdate, ReportLocation = " + this.b);
            if (this.b) {
                if (!this.f456a && this.k > 0) {
                    h();
                    return;
                }
                return;
            }
            g();
            return;
        }
        as.a(6, c, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
    }
}
