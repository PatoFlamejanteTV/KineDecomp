package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzk {

    /* renamed from: a */
    private final zzp<zzi> f1862a;
    private final Context b;
    private ContentProviderClient c = null;
    private boolean d = false;
    private Map<LocationListener, b> e = new HashMap();
    private Map<LocationCallback, a> f = new HashMap();

    /* loaded from: classes.dex */
    public static class a extends zzc.zza {

        /* renamed from: a */
        private Handler f1863a;

        private void a(int i, Object obj) {
            if (this.f1863a == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.f1863a.sendMessage(obtain);
        }

        @Override // com.google.android.gms.location.zzc
        public void a(LocationAvailability locationAvailability) {
            a(1, locationAvailability);
        }

        @Override // com.google.android.gms.location.zzc
        public void a(LocationResult locationResult) {
            a(0, locationResult);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends zzd.zza {

        /* renamed from: a */
        private Handler f1864a;

        @Override // com.google.android.gms.location.zzd
        public void a(Location location) {
            if (this.f1864a == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.f1864a.sendMessage(obtain);
        }
    }

    public zzk(Context context, zzp<zzi> zzpVar) {
        this.b = context;
        this.f1862a = zzpVar;
    }

    public void a() {
        try {
            synchronized (this.e) {
                for (b bVar : this.e.values()) {
                    if (bVar != null) {
                        this.f1862a.c().a(LocationRequestUpdateData.a(bVar, (zzg) null));
                    }
                }
                this.e.clear();
                for (a aVar : this.f.values()) {
                    if (aVar != null) {
                        this.f1862a.c().a(LocationRequestUpdateData.a(aVar, (zzg) null));
                    }
                }
                this.f.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void a(boolean z) throws RemoteException {
        this.f1862a.a();
        this.f1862a.c().a(z);
        this.d = z;
    }

    public void b() {
        if (this.d) {
            try {
                a(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
