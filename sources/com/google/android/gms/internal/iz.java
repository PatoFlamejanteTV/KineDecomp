package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class iz extends zzqt.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzqt.b f1641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iz(zzqt.b bVar) {
        this.f1641a = bVar;
    }

    @Override // com.google.android.gms.internal.zzqt.a, com.google.android.gms.internal.zzqq
    public void zzbb(Status status) {
        boolean z;
        z = this.f1641a.c;
        if (z) {
            Log.d("SearchAuth", "ClearTokenImpl success");
        }
        this.f1641a.zzb((zzqt.b) status);
    }
}
