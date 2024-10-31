package com.google.android.gms.internal.config;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzn {
    private static AppMeasurement zza(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public static List<zzl> zzb(Context context) {
        Map<String, Object> map;
        AppMeasurement zza = zza(context);
        if (zza == null) {
            if (Log.isLoggable("FRCAnalytics", 3)) {
                Log.d("FRCAnalytics", "Unable to get user properties: analytics library is missing.");
            }
            return null;
        }
        try {
            map = zza.a(false);
        } catch (NullPointerException e2) {
            if (Log.isLoggable("FRCAnalytics", 3)) {
                Log.d("FRCAnalytics", "Unable to get user properties.", e2);
            }
            map = null;
        }
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                arrayList.add(new zzl(entry.getKey(), entry.getValue().toString()));
            }
        }
        return arrayList;
    }
}
