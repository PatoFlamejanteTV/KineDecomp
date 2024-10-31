package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzur {

    @VisibleForTesting
    zzfa zzcbz;

    @VisibleForTesting
    boolean zzcca;

    public zzur(Context context, String str, String str2) {
        zzaan.initialize(context);
        try {
            this.zzcbz = (zzfa) zzbbe.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", Wm.f11952a);
            ObjectWrapper.a(context);
            this.zzcbz.zza(ObjectWrapper.a(context), str, null);
            this.zzcca = true;
        } catch (RemoteException | zzbbg | NullPointerException unused) {
            zzbbd.zzdn("Cannot dynamite load clearcut");
        }
    }

    public final zzuv zzg(byte[] bArr) {
        return new zzuv(this, bArr);
    }

    public zzur(Context context) {
        zzaan.initialize(context);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwp)).booleanValue()) {
            try {
                this.zzcbz = (zzfa) zzbbe.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", Xm.f11970a);
                ObjectWrapper.a(context);
                this.zzcbz.zza(ObjectWrapper.a(context), "GMA_SDK");
                this.zzcca = true;
            } catch (RemoteException | zzbbg | NullPointerException unused) {
                zzbbd.zzdn("Cannot dynamite load clearcut");
            }
        }
    }

    public zzur() {
    }
}
