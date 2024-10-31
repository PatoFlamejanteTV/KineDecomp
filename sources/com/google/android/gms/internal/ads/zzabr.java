package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzabr extends zzadc {
    private final Uri mUri;
    private final Drawable zzdau;
    private final double zzdav;

    public zzabr(Drawable drawable, Uri uri, double d2) {
        this.zzdau = drawable;
        this.mUri = uri;
        this.zzdav = d2;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final double getScale() {
        return this.zzdav;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final Uri getUri() throws RemoteException {
        return this.mUri;
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final IObjectWrapper zzsa() throws RemoteException {
        return ObjectWrapper.a(this.zzdau);
    }
}
