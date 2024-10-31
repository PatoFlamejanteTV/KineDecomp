package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.logging.LogWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f16778a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PersistentConnectionImpl f16779b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersistentConnectionImpl persistentConnectionImpl, boolean z) {
        this.f16779b = persistentConnectionImpl;
        this.f16778a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogWrapper logWrapper;
        PersistentConnectionImpl.ConnectionState connectionState;
        PersistentConnectionImpl.ConnectionState connectionState2;
        long j;
        ConnectionAuthTokenProvider connectionAuthTokenProvider;
        logWrapper = this.f16779b.u;
        logWrapper.a("Trying to fetch auth token", new Object[0]);
        connectionState = this.f16779b.i;
        boolean z = connectionState == PersistentConnectionImpl.ConnectionState.Disconnected;
        connectionState2 = this.f16779b.i;
        ConnectionUtils.a(z, "Not in disconnected state: %s", connectionState2);
        this.f16779b.i = PersistentConnectionImpl.ConnectionState.GettingToken;
        PersistentConnectionImpl.n(this.f16779b);
        j = this.f16779b.x;
        connectionAuthTokenProvider = this.f16779b.s;
        connectionAuthTokenProvider.a(this.f16778a, new a(this, j));
    }
}
