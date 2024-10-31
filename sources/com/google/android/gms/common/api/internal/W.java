package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class W implements zabt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ U f10815a;

    private W(U u) {
        this.f10815a = u;
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f10815a.m;
        lock.lock();
        try {
            this.f10815a.a(bundle);
            this.f10815a.j = ConnectionResult.f10647a;
            this.f10815a.f();
        } finally {
            lock2 = this.f10815a.m;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ W(U u, V v) {
        this(u);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f10815a.m;
        lock.lock();
        try {
            this.f10815a.j = connectionResult;
            this.f10815a.f();
        } finally {
            lock2 = this.f10815a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        zabe zabeVar;
        lock = this.f10815a.m;
        lock.lock();
        try {
            z2 = this.f10815a.l;
            if (!z2) {
                connectionResult = this.f10815a.k;
                if (connectionResult != null) {
                    connectionResult2 = this.f10815a.k;
                    if (connectionResult2.R()) {
                        this.f10815a.l = true;
                        zabeVar = this.f10815a.f10809e;
                        zabeVar.onConnectionSuspended(i);
                        return;
                    }
                }
            }
            this.f10815a.l = false;
            this.f10815a.a(i, z);
        } finally {
            lock2 = this.f10815a.m;
            lock2.unlock();
        }
    }
}
