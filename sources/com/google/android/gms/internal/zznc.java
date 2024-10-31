package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class zznc {
    private static final Method zzaip = zzqG();
    private static final Method zzaiq = zzqH();
    private static final Method zzair = zzqI();
    private static final Method zzais = zzqJ();
    private static final Method zzait = zzqK();

    public static int zza(WorkSource workSource) {
        if (zzair != null) {
            try {
                return ((Integer) zzair.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static String zza(WorkSource workSource, int i) {
        if (zzait != null) {
            try {
                return (String) zzait.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        if (zzaiq != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzaiq.invoke(workSource, Integer.valueOf(i), str);
                return;
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                return;
            }
        }
        if (zzaip != null) {
            try {
                zzaip.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean zzar(Context context) {
        return context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    public static List<String> zzb(WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zznb.zzcA(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static WorkSource zzf(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    public static WorkSource zzm(Context context, String str) {
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zzf(applicationInfo.uid, str);
            }
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + str);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: " + str);
            return null;
        }
    }

    private static Method zzqG() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzqH() {
        if (!zzmx.zzqA()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzqI() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzqJ() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzqK() {
        if (!zzmx.zzqA()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }
}
