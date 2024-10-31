package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionAuthTokenProvider;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.e */
/* loaded from: classes2.dex */
public class C1589e implements ConnectionAuthTokenProvider {

    /* renamed from: a */
    final /* synthetic */ AuthTokenProvider f16973a;

    public C1589e(AuthTokenProvider authTokenProvider) {
        this.f16973a = authTokenProvider;
    }

    @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider
    public void a(boolean z, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
        this.f16973a.a(z, new C1588d(this, getTokenCallback));
    }
}
