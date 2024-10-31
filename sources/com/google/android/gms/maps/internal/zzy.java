package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes.dex */
public class zzy {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1970a;
    private static zzc b;

    public static zzc a(Context context) throws GooglePlayServicesNotAvailableException {
        com.google.android.gms.common.internal.zzx.a(context);
        if (b != null) {
            return b;
        }
        b(context);
        b = c(context);
        try {
            b.a(com.google.android.gms.dynamic.zze.a(d(context).getResources()), GooglePlayServicesUtil.f863a);
            return b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static <T> T a(Class<?> cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        }
    }

    private static <T> T a(ClassLoader classLoader, String str) {
        try {
            return (T) a(((ClassLoader) com.google.android.gms.common.internal.zzx.a(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    public static boolean a() {
        return false;
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void b(Context context) throws GooglePlayServicesNotAvailableException {
        int a2 = GooglePlayServicesUtil.a(context);
        switch (a2) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(a2);
        }
    }

    private static zzc c(Context context) {
        if (a()) {
            Log.i(zzy.class.getSimpleName(), "Making Creator statically");
            return (zzc) a(b());
        }
        Log.i(zzy.class.getSimpleName(), "Making Creator dynamically");
        return zzc.zza.a((IBinder) a(d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Context d(Context context) {
        if (f1970a == null) {
            if (a()) {
                f1970a = context.getApplicationContext();
            } else {
                f1970a = GooglePlayServicesUtil.e(context);
            }
        }
        return f1970a;
    }
}
