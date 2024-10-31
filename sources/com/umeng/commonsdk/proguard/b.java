package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.facebook.places.model.PlaceFields;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: UMSysLocation.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private static final String f26219a = "UMSysLocation";

    /* renamed from: c */
    private static final int f26220c = 10000;

    /* renamed from: b */
    private LocationManager f26221b;

    /* renamed from: d */
    private Context f26222d;

    /* renamed from: e */
    private d f26223e;

    private b() {
    }

    public synchronized void a(d dVar) {
        boolean isProviderEnabled;
        boolean isProviderEnabled2;
        Location lastKnownLocation;
        ULog.i(f26219a, "getSystemLocation");
        if (dVar != null && this.f26222d != null) {
            this.f26223e = dVar;
            boolean checkPermission = UMUtils.checkPermission(this.f26222d, "android.permission.ACCESS_COARSE_LOCATION");
            boolean checkPermission2 = UMUtils.checkPermission(this.f26222d, "android.permission.ACCESS_FINE_LOCATION");
            if (!checkPermission && !checkPermission2) {
                if (this.f26223e != null) {
                    this.f26223e.a(null);
                }
                return;
            }
            try {
                if (this.f26221b != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        isProviderEnabled = this.f26221b.isProviderEnabled("gps");
                        isProviderEnabled2 = this.f26221b.isProviderEnabled("network");
                    } else {
                        isProviderEnabled = checkPermission2 ? this.f26221b.isProviderEnabled("gps") : false;
                        isProviderEnabled2 = checkPermission ? this.f26221b.isProviderEnabled("network") : false;
                    }
                    if (isProviderEnabled || isProviderEnabled2) {
                        ULog.i(f26219a, "getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)");
                        if (checkPermission2) {
                            lastKnownLocation = this.f26221b.getLastKnownLocation("passive");
                        } else if (checkPermission) {
                            lastKnownLocation = this.f26221b.getLastKnownLocation("network");
                        }
                        this.f26223e.a(lastKnownLocation);
                    }
                    lastKnownLocation = null;
                    this.f26223e.a(lastKnownLocation);
                }
            } catch (Throwable th) {
                ULog.i(f26219a, "e is " + th);
                if (dVar != null) {
                    try {
                        dVar.a(null);
                    } catch (Throwable th2) {
                        UMCrashManager.reportCrash(this.f26222d, th2);
                    }
                }
                UMCrashManager.reportCrash(this.f26222d, th);
            }
        }
    }

    public b(Context context) {
        if (context == null) {
            MLog.e("Context参数不能为null");
        } else {
            this.f26222d = context.getApplicationContext();
            this.f26221b = (LocationManager) context.getApplicationContext().getSystemService(PlaceFields.LOCATION);
        }
    }

    public synchronized void a() {
        ULog.i(f26219a, "destroy");
        try {
            if (this.f26221b != null) {
                this.f26221b = null;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f26222d, th);
        }
    }
}
