package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzcp;

/* loaded from: classes.dex */
public class zzda extends com.google.android.gms.dynamic.zzg<zzcp> {
    public zzda() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzco zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            return zzco.zza.zzu(zzas(context).zza(com.google.android.gms.dynamic.zze.a(context), com.google.android.gms.dynamic.zze.a(frameLayout), com.google.android.gms.dynamic.zze.a(frameLayout2), 8115000));
        } catch (RemoteException | zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzD */
    public zzcp zzd(IBinder iBinder) {
        return zzcp.zza.zzv(iBinder);
    }

    public zzco zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzco zzb;
        if (com.google.android.gms.ads.internal.client.zzl.a().b(context) && (zzb = zzb(context, frameLayout, frameLayout2)) != null) {
            return zzb;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Using NativeAdViewDelegate from the client jar.");
        return new com.google.android.gms.ads.internal.formats.zzj(frameLayout, frameLayout2);
    }
}
