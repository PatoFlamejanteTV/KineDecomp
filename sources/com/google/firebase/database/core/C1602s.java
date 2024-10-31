package com.google.firebase.database.core;

import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.logging.LogWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1602s implements AuthTokenProvider.TokenChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo f17046a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1602s(Repo repo) {
        this.f17046a = repo;
    }

    @Override // com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener
    public void a(String str) {
        LogWrapper logWrapper;
        PersistentConnection persistentConnection;
        logWrapper = this.f17046a.j;
        logWrapper.a("Auth token changed, triggering auth token refresh", new Object[0]);
        persistentConnection = this.f17046a.f16905c;
        persistentConnection.e(str);
    }
}
