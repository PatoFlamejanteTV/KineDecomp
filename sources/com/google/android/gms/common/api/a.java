package com.google.android.gms.common.api;

import android.support.v4.app.l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzlp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleApiClient f980a;
    final /* synthetic */ GoogleApiClient.Builder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoogleApiClient.Builder builder, GoogleApiClient googleApiClient) {
        this.b = builder;
        this.f980a = googleApiClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        l lVar2;
        l lVar3;
        lVar = this.b.j;
        if (lVar.isFinishing()) {
            return;
        }
        lVar2 = this.b.j;
        if (lVar2.getSupportFragmentManager().d()) {
            return;
        }
        GoogleApiClient.Builder builder = this.b;
        lVar3 = this.b.j;
        builder.a(zzlp.zzb(lVar3), this.f980a);
    }
}
