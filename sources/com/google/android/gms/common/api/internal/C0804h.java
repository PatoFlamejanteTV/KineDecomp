package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.internal.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0804h implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<zaak> f10835a;

    /* renamed from: b, reason: collision with root package name */
    private final Api<?> f10836b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f10837c;

    public C0804h(zaak zaakVar, Api<?> api, boolean z) {
        this.f10835a = new WeakReference<>(zaakVar);
        this.f10836b = api;
        this.f10837c = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void a(ConnectionResult connectionResult) {
        zabe zabeVar;
        Lock lock;
        Lock lock2;
        boolean a2;
        boolean b2;
        zaak zaakVar = this.f10835a.get();
        if (zaakVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        zabeVar = zaakVar.f10872a;
        Preconditions.b(myLooper == zabeVar.n.g(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = zaakVar.f10873b;
        lock.lock();
        try {
            a2 = zaakVar.a(0);
            if (a2) {
                if (!connectionResult.R()) {
                    zaakVar.b(connectionResult, this.f10836b, this.f10837c);
                }
                b2 = zaakVar.b();
                if (b2) {
                    zaakVar.c();
                }
            }
        } finally {
            lock2 = zaakVar.f10873b;
            lock2.unlock();
        }
    }
}
