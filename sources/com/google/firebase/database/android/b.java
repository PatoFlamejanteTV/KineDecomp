package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.AuthTokenProvider;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class b implements OnSuccessListener<GetTokenResult> {

    /* renamed from: a */
    final /* synthetic */ AuthTokenProvider.GetTokenCompletionListener f16666a;

    /* renamed from: b */
    final /* synthetic */ AndroidAuthTokenProvider f16667b;

    public b(AndroidAuthTokenProvider androidAuthTokenProvider, AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f16667b = androidAuthTokenProvider;
        this.f16666a = getTokenCompletionListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a */
    public void onSuccess(GetTokenResult getTokenResult) {
        this.f16666a.a(getTokenResult.c());
    }
}
