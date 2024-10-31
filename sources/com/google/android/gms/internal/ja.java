package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.search.GoogleNowAuthState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ja extends zzqt.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzqt.c f1643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ja(zzqt.c cVar) {
        this.f1643a = cVar;
    }

    @Override // com.google.android.gms.internal.zzqt.a, com.google.android.gms.internal.zzqq
    public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
        boolean z;
        z = this.f1643a.c;
        if (z) {
            Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
        }
        this.f1643a.zzb((zzqt.c) new zzqt.d(status, googleNowAuthState));
    }
}
