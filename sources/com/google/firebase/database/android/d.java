package com.google.firebase.database.android;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class d implements FirebaseApp.IdTokenListener {

    /* renamed from: a */
    final /* synthetic */ AuthTokenProvider.TokenChangeListener f16670a;

    /* renamed from: b */
    final /* synthetic */ AndroidAuthTokenProvider f16671b;

    public d(AndroidAuthTokenProvider androidAuthTokenProvider, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        this.f16671b = androidAuthTokenProvider;
        this.f16670a = tokenChangeListener;
    }

    @Override // com.google.firebase.FirebaseApp.IdTokenListener
    public void a(InternalTokenResult internalTokenResult) {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f16671b.f16653a;
        scheduledExecutorService.execute(new c(this, internalTokenResult));
    }
}
