package com.qq.e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.facebook.places.model.PlaceFields;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class DeviceStatus {

    /* renamed from: a */
    private String f25002a;

    /* renamed from: b */
    private String f25003b;

    /* renamed from: c */
    private int f25004c;

    /* renamed from: d */
    private int f25005d;

    /* renamed from: e */
    private int f25006e;

    /* renamed from: f */
    private String f25007f;

    /* renamed from: g */
    private String f25008g;

    /* renamed from: h */
    private String f25009h;
    private String i;
    private String j;
    private volatile String k;
    private volatile String l;
    private volatile float m;
    public final String model = Build.MODEL;
    private Context n;

    /* renamed from: com.qq.e.comm.managers.status.DeviceStatus$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements LocationListener {

        /* renamed from: a */
        private /* synthetic */ LocationManager f25010a;

        AnonymousClass1(LocationManager locationManager) {
            locationManager = locationManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                DeviceStatus deviceStatus = DeviceStatus.this;
                StringBuilder sb = new StringBuilder();
                sb.append(location.getLatitude());
                deviceStatus.k = sb.toString();
                DeviceStatus deviceStatus2 = DeviceStatus.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(location.getLongitude());
                deviceStatus2.l = sb2.toString();
                locationManager.removeUpdates(this);
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public DeviceStatus(Context context) {
        this.n = context.getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f25006e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f25004c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f25005d = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        a();
    }

    private int a(float f2, int i) {
        return (this.n.getApplicationInfo().flags & 8192) != 0 ? (int) (i / f2) : i;
    }

    private void a() {
        try {
            LocationManager locationManager = (LocationManager) this.n.getSystemService(PlaceFields.LOCATION);
            if (locationManager == null) {
                return;
            }
            Criteria criteria = new Criteria();
            criteria.setAccuracy(2);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
            if (lastKnownLocation != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(lastKnownLocation.getLatitude());
                this.k = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(lastKnownLocation.getLongitude());
                this.l = sb2.toString();
                this.m = lastKnownLocation.getAccuracy();
            } else {
                locationManager.requestLocationUpdates(bestProvider, 2000L, 7000.0f, new LocationListener() { // from class: com.qq.e.comm.managers.status.DeviceStatus.1

                    /* renamed from: a */
                    private /* synthetic */ LocationManager f25010a;

                    AnonymousClass1(LocationManager locationManager2) {
                        locationManager = locationManager2;
                    }

                    @Override // android.location.LocationListener
                    public void onLocationChanged(Location location) {
                        try {
                            DeviceStatus deviceStatus = DeviceStatus.this;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(location.getLatitude());
                            deviceStatus.k = sb3.toString();
                            DeviceStatus deviceStatus2 = DeviceStatus.this;
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append(location.getLongitude());
                            deviceStatus2.l = sb22.toString();
                            locationManager.removeUpdates(this);
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str) {
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str) {
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str, int i, Bundle bundle) {
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                return Carrier.CMCC;
            }
            if (operator.equals("46001") || operator.equals("46006")) {
                return Carrier.UNICOM;
            }
            if (operator.equals("46003") || operator.equals("46005")) {
                return Carrier.TELECOM;
            }
        }
        return Carrier.UNKNOWN;
    }

    public String getDataNet() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) this.n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return null;
        }
        int type = networkInfo.getType();
        this.i = type != 0 ? type != 1 ? "unknow" : "wi" : "ed";
        return this.i;
    }

    public int getDeviceDensity() {
        return this.f25006e;
    }

    public int getDeviceHeight() {
        return this.f25005d;
    }

    public int getDeviceWidth() {
        return this.f25004c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
    }

    public Map<String, String> getLacAndCeilId() {
        int i;
        GsmCellLocation gsmCellLocation;
        String operator = getOperator();
        HashMap hashMap = new HashMap();
        if (!StringUtil.isEmpty(operator) && !"null".equalsIgnoreCase(operator)) {
            int i2 = 0;
            try {
                if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService(PlaceFields.PHONE);
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i2 = cdmaCellLocation.getNetworkId();
                        i = cdmaCellLocation.getBaseStationId();
                    } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                        i = 0;
                    } else {
                        i2 = gsmCellLocation.getLac();
                        i = gsmCellLocation.getCid();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    hashMap.put("lac", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    hashMap.put("cellid", sb2.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.f25003b == null) {
            this.f25003b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            if (this.f25003b.length() == 0) {
                this.f25003b = "en";
            }
        }
        return this.f25003b;
    }

    public String getLat() {
        return this.k;
    }

    public String getLng() {
        return this.l;
    }

    public float getLocationAccuracy() {
        return this.m;
    }

    public NetworkType getNetworkType() {
        int i;
        String dataNet = getDataNet();
        try {
            i = Integer.parseInt(getPhoneNet());
        } catch (NumberFormatException unused) {
            i = 0;
        }
        if (dataNet != null && dataNet.equals("wi")) {
            return NetworkType.WIFI;
        }
        switch (i) {
            case 1:
            case 2:
                return NetworkType.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
                return NetworkType.NET_3G;
            case 13:
            case 15:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    public String getOperator() {
        try {
            this.f25008g = ((TelephonyManager) this.n.getSystemService(PlaceFields.PHONE)).getNetworkOperator();
        } catch (Exception unused) {
        }
        return this.f25008g;
    }

    public String getPhoneNet() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService(PlaceFields.PHONE);
            StringBuilder sb = new StringBuilder();
            sb.append(telephonyManager.getNetworkType());
            this.f25009h = sb.toString();
        } catch (Exception unused) {
        }
        return this.f25009h;
    }

    public String getPlainDid() {
        if (!StringUtil.isEmpty(this.j)) {
            return this.j;
        }
        try {
            this.j = ((TelephonyManager) this.n.getSystemService(PlaceFields.PHONE)).getDeviceId();
        } catch (Exception e2) {
            GDTLogger.d("Get imei encounter error: " + e2.getMessage());
        }
        return StringUtil.isEmpty(this.j) ? "" : this.j;
    }

    public String getScreenOrientation() {
        this.f25007f = this.n.getResources().getConfiguration().orientation == 2 ? Constants.LANDSCAPE : "p";
        return this.f25007f;
    }

    public String getUid() {
        if (this.f25002a == null) {
            String string = Settings.Secure.getString(this.n.getContentResolver(), "android_id");
            if (string == null) {
                string = "emulator";
            }
            this.f25002a = Md5Util.encode(string);
        }
        return this.f25002a;
    }

    public int getVersion() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }
}
