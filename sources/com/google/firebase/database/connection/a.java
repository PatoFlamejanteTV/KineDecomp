package com.google.firebase.database.connection;

import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.logging.LogWrapper;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class a implements ConnectionAuthTokenProvider.GetTokenCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f16776a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f16777b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, long j) {
        this.f16777b = bVar;
        this.f16776a = j;
    }

    @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider.GetTokenCallback
    public void a(String str) {
        long j;
        LogWrapper logWrapper;
        PersistentConnectionImpl.ConnectionState connectionState;
        PersistentConnectionImpl.ConnectionState connectionState2;
        PersistentConnectionImpl.ConnectionState connectionState3;
        LogWrapper logWrapper2;
        LogWrapper logWrapper3;
        long j2 = this.f16776a;
        j = this.f16777b.f16779b.x;
        if (j2 == j) {
            connectionState = this.f16777b.f16779b.i;
            if (connectionState == PersistentConnectionImpl.ConnectionState.GettingToken) {
                logWrapper3 = this.f16777b.f16779b.u;
                logWrapper3.a("Successfully fetched token, opening connection", new Object[0]);
                this.f16777b.f16779b.g(str);
                return;
            } else {
                connectionState2 = this.f16777b.f16779b.i;
                boolean z = connectionState2 == PersistentConnectionImpl.ConnectionState.Disconnected;
                connectionState3 = this.f16777b.f16779b.i;
                ConnectionUtils.a(z, "Expected connection state disconnected, but was %s", connectionState3);
                logWrapper2 = this.f16777b.f16779b.u;
                logWrapper2.a("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
                return;
            }
        }
        logWrapper = this.f16777b.f16779b.u;
        logWrapper.a("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
    }

    @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider.GetTokenCallback
    public void onError(String str) {
        long j;
        LogWrapper logWrapper;
        LogWrapper logWrapper2;
        long j2 = this.f16776a;
        j = this.f16777b.f16779b.x;
        if (j2 != j) {
            logWrapper = this.f16777b.f16779b.u;
            logWrapper.a("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
            return;
        }
        this.f16777b.f16779b.i = PersistentConnectionImpl.ConnectionState.Disconnected;
        logWrapper2 = this.f16777b.f16779b.u;
        logWrapper2.a("Error fetching token: " + str, new Object[0]);
        this.f16777b.f16779b.o();
    }
}
