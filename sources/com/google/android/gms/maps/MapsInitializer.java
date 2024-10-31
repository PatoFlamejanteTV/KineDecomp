package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes.dex */
public final class MapsInitializer {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f1917a = false;

    private MapsInitializer() {
    }

    public static synchronized int a(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            zzx.a(context, "Context is null");
            if (!f1917a) {
                try {
                    a(zzy.a(context));
                    f1917a = true;
                } catch (GooglePlayServicesNotAvailableException e) {
                    i = e.errorCode;
                }
            }
        }
        return i;
    }

    public static void a(zzc zzcVar) {
        try {
            CameraUpdateFactory.a(zzcVar.a());
            BitmapDescriptorFactory.a(zzcVar.b());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
