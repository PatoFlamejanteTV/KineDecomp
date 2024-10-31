package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class J implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Result f10770a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zacm f10771b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(zacm zacmVar, Result result) {
        this.f10771b = zacmVar;
        this.f10770a = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        K k;
        K k2;
        WeakReference weakReference2;
        ResultTransform resultTransform;
        K k3;
        K k4;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.f10720a.set(true);
                resultTransform = this.f10771b.f10916a;
                PendingResult a2 = resultTransform.a((ResultTransform) this.f10770a);
                k3 = this.f10771b.f10922g;
                k4 = this.f10771b.f10922g;
                k3.sendMessage(k4.obtainMessage(0, a2));
                BasePendingResult.f10720a.set(false);
                zacm zacmVar = this.f10771b;
                zacm.a(this.f10770a);
                weakReference3 = this.f10771b.f10921f;
                GoogleApiClient googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient != null) {
                    googleApiClient.a(this.f10771b);
                }
            } catch (RuntimeException e2) {
                k = this.f10771b.f10922g;
                k2 = this.f10771b.f10922g;
                k.sendMessage(k2.obtainMessage(1, e2));
                BasePendingResult.f10720a.set(false);
                zacm zacmVar2 = this.f10771b;
                zacm.a(this.f10770a);
                weakReference2 = this.f10771b.f10921f;
                GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference2.get();
                if (googleApiClient2 != null) {
                    googleApiClient2.a(this.f10771b);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.f10720a.set(false);
            zacm zacmVar3 = this.f10771b;
            zacm.a(this.f10770a);
            weakReference = this.f10771b.f10921f;
            GoogleApiClient googleApiClient3 = (GoogleApiClient) weakReference.get();
            if (googleApiClient3 != null) {
                googleApiClient3.a(this.f10771b);
            }
            throw th;
        }
    }
}
