package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.zzpx;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ig extends zzpx.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1623a;
    final /* synthetic */ Uri b;
    final /* synthetic */ zzpx c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ig(Context context, Uri uri, zzpx zzpxVar) {
        this.f1623a = context;
        this.b = uri;
        this.c = zzpxVar;
    }

    @Override // com.google.android.gms.internal.zzpx
    public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
        zzpz.zza(this.f1623a, this.b);
        this.c.zza(i, bundle, i2, intent);
    }
}
