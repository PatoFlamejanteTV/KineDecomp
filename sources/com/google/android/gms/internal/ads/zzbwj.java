package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class zzbwj extends b.b.c.l {
    private WeakReference<zzbwk> zzgdf;

    public zzbwj(zzbwk zzbwkVar) {
        this.zzgdf = new WeakReference<>(zzbwkVar);
    }

    @Override // b.b.c.l
    public final void onCustomTabsServiceConnected(ComponentName componentName, b.b.c.h hVar) {
        zzbwk zzbwkVar = this.zzgdf.get();
        if (zzbwkVar != null) {
            zzbwkVar.zza(hVar);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbwk zzbwkVar = this.zzgdf.get();
        if (zzbwkVar != null) {
            zzbwkVar.zzrl();
        }
    }
}
