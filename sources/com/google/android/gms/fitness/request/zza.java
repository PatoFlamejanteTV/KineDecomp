package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzn;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zza extends zzn.zza {

    /* renamed from: a, reason: collision with root package name */
    private final BleScanCallback f1279a;

    /* renamed from: com.google.android.gms.fitness.request.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0033zza {

        /* renamed from: a, reason: collision with root package name */
        private static final C0033zza f1280a = new C0033zza();
        private final Map<BleScanCallback, zza> b = new HashMap();

        private C0033zza() {
        }

        public static C0033zza a() {
            return f1280a;
        }

        public zza a(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.b) {
                zzaVar = this.b.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                }
            }
            return zzaVar;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.f1279a = (BleScanCallback) com.google.android.gms.common.internal.zzx.a(bleScanCallback);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void a() throws RemoteException {
        this.f1279a.a();
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void a(BleDevice bleDevice) throws RemoteException {
        this.f1279a.a(bleDevice);
    }
}
