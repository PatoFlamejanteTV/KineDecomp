package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.wearable.internal.f;
import com.google.android.gms.wearable.internal.zzax;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a */
    private final Map<T, g<T>> f2365a = new HashMap();

    /* renamed from: com.google.android.gms.wearable.internal.a$a */
    /* loaded from: classes.dex */
    public static class BinderC0046a<T> extends f.a<Status> {

        /* renamed from: a */
        private WeakReference<Map<T, g<T>>> f2366a;
        private WeakReference<T> b;

        BinderC0046a(Map<T, g<T>> map, T t, zzlb.zzb<Status> zzbVar) {
            super(zzbVar);
            this.f2366a = new WeakReference<>(map);
            this.b = new WeakReference<>(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void a(Status status) {
            Map<T, g<T>> map = this.f2366a.get();
            T t = this.b.get();
            if (!status.getStatus().d() && map != null && t != null) {
                synchronized (map) {
                    g<T> remove = map.remove(t);
                    if (remove != null) {
                        remove.a();
                    }
                }
            }
            a((BinderC0046a<T>) status);
        }
    }

    public void a(IBinder iBinder) {
        synchronized (this.f2365a) {
            zzax a2 = zzax.zza.a(iBinder);
            f.b bVar = new f.b();
            for (Map.Entry<T, g<T>> entry : this.f2365a.entrySet()) {
                g<T> value = entry.getValue();
                try {
                    a2.a(bVar, new AddListenerRequest(value));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + value);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + value);
                }
            }
        }
    }

    public void a(zzbo zzboVar) {
        synchronized (this.f2365a) {
            f.b bVar = new f.b();
            for (Map.Entry<T, g<T>> entry : this.f2365a.entrySet()) {
                g<T> value = entry.getValue();
                if (value != null) {
                    value.a();
                    if (zzboVar.isConnected()) {
                        try {
                            zzboVar.zzpc().a(bVar, new RemoveListenerRequest(value));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + value);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + value);
                        }
                    }
                }
            }
            this.f2365a.clear();
        }
    }

    public void a(zzbo zzboVar, zzlb.zzb<Status> zzbVar, T t, g<T> gVar) throws RemoteException {
        synchronized (this.f2365a) {
            if (this.f2365a.get(t) != null) {
                zzbVar.zzp(new Status(LicenseErrCode.ERROR_LICENSE_GETAUTHFILE));
                return;
            }
            this.f2365a.put(t, gVar);
            try {
                zzboVar.zzpc().a(new BinderC0046a(this.f2365a, t, zzbVar), new AddListenerRequest(gVar));
            } catch (RemoteException e) {
                this.f2365a.remove(t);
                throw e;
            }
        }
    }
}
