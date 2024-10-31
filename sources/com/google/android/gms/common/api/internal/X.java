package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class X implements zabt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ U f10816a;

    private X(U u) {
        this.f10816a = u;
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f10816a.m;
        lock.lock();
        try {
            this.f10816a.k = ConnectionResult.f10647a;
            this.f10816a.f();
        } finally {
            lock2 = this.f10816a.m;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ X(U u, V v) {
        this(u);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f10816a.m;
        lock.lock();
        try {
            this.f10816a.k = connectionResult;
            this.f10816a.f();
        } finally {
            lock2 = this.f10816a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        zabe zabeVar;
        lock = this.f10816a.m;
        lock.lock();
        try {
            z2 = this.f10816a.l;
            if (z2) {
                this.f10816a.l = false;
                this.f10816a.a(i, z);
            } else {
                this.f10816a.l = true;
                zabeVar = this.f10816a.f10808d;
                zabeVar.onConnectionSuspended(i);
            }
        } finally {
            lock2 = this.f10816a.m;
            lock2.unlock();
        }
    }
}
