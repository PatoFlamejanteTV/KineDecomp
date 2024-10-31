package com.google.firebase.database.android;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.core.AuthTokenProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class AndroidAuthTokenProvider implements AuthTokenProvider {

    /* renamed from: a */
    private final ScheduledExecutorService f16653a;

    /* renamed from: b */
    private final FirebaseApp f16654b;

    public AndroidAuthTokenProvider(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        this.f16654b = firebaseApp;
        this.f16653a = scheduledExecutorService;
    }

    private FirebaseApp.IdTokenListener b(AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        return new d(this, tokenChangeListener);
    }

    @Override // com.google.firebase.database.core.AuthTokenProvider
    public void a(boolean z, AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f16654b.a(z).a(this.f16653a, new b(this, getTokenCompletionListener)).a(this.f16653a, new a(this, getTokenCompletionListener));
    }

    @Override // com.google.firebase.database.core.AuthTokenProvider
    public void a(AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        this.f16654b.a(b(tokenChangeListener));
    }
}
