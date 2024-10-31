package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.core.AuthTokenProvider;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.d */
/* loaded from: classes2.dex */
class C1588d implements AuthTokenProvider.GetTokenCompletionListener {

    /* renamed from: a */
    final /* synthetic */ ConnectionAuthTokenProvider.GetTokenCallback f16971a;

    /* renamed from: b */
    final /* synthetic */ C1589e f16972b;

    public C1588d(C1589e c1589e, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
        this.f16972b = c1589e;
        this.f16971a = getTokenCallback;
    }

    @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
    public void a(String str) {
        this.f16971a.a(str);
    }

    @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
    public void onError(String str) {
        this.f16971a.onError(str);
    }
}
