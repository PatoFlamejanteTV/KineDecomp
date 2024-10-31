package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzk extends zzj.zza {

    /* renamed from: a, reason: collision with root package name */
    private final OnDataPointListener f1237a;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private static final zza f1238a = new zza();
        private final Map<OnDataPointListener, zzk> b = new HashMap();

        private zza() {
        }

        public static zza a() {
            return f1238a;
        }

        public zzk a(OnDataPointListener onDataPointListener) {
            zzk zzkVar;
            synchronized (this.b) {
                zzkVar = this.b.get(onDataPointListener);
                if (zzkVar == null) {
                    zzkVar = new zzk(onDataPointListener);
                    this.b.put(onDataPointListener, zzkVar);
                }
            }
            return zzkVar;
        }

        public zzk b(OnDataPointListener onDataPointListener) {
            zzk zzkVar;
            synchronized (this.b) {
                zzkVar = this.b.get(onDataPointListener);
            }
            return zzkVar;
        }

        public zzk c(OnDataPointListener onDataPointListener) {
            zzk remove;
            synchronized (this.b) {
                remove = this.b.remove(onDataPointListener);
                if (remove == null) {
                    remove = new zzk(onDataPointListener);
                }
            }
            return remove;
        }
    }

    private zzk(OnDataPointListener onDataPointListener) {
        this.f1237a = (OnDataPointListener) zzx.a(onDataPointListener);
    }

    @Override // com.google.android.gms.fitness.data.zzj
    public void a(DataPoint dataPoint) throws RemoteException {
        this.f1237a.a(dataPoint);
    }
}
