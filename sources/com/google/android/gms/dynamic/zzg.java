package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public abstract class zzg<T> {
    private final String zzapA;
    private T zzapB;

    /* loaded from: classes.dex */
    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzg(String str) {
        this.zzapA = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T zzas(Context context) throws zza {
        if (this.zzapB == null) {
            zzx.a(context);
            Context e = GooglePlayServicesUtil.e(context);
            if (e == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.zzapB = zzd((IBinder) e.getClassLoader().loadClass(this.zzapA).newInstance());
            } catch (ClassNotFoundException e2) {
                throw new zza("Could not load creator class.", e2);
            } catch (IllegalAccessException e3) {
                throw new zza("Could not access creator.", e3);
            } catch (InstantiationException e4) {
                throw new zza("Could not instantiate creator.", e4);
            }
        }
        return this.zzapB;
    }

    protected abstract T zzd(IBinder iBinder);
}
