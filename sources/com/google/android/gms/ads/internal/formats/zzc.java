package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zzc extends zzcm.zza {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f573a;
    private final Uri b;
    private final double c;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.f573a = drawable;
        this.b = uri;
        this.c = d;
    }

    @Override // com.google.android.gms.internal.zzcm
    public double getScale() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.zzcm
    public Uri getUri() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.zzcm
    public com.google.android.gms.dynamic.zzd zzdv() throws RemoteException {
        return com.google.android.gms.dynamic.zze.a(this.f573a);
    }
}
