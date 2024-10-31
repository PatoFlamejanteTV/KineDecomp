package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class a implements OnFailureListener {

    /* renamed from: a */
    final /* synthetic */ AuthTokenProvider.GetTokenCompletionListener f16664a;

    /* renamed from: b */
    final /* synthetic */ AndroidAuthTokenProvider f16665b;

    public a(AndroidAuthTokenProvider androidAuthTokenProvider, AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f16665b = androidAuthTokenProvider;
        this.f16664a = getTokenCompletionListener;
    }

    private boolean a(Exception exc) {
        return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        if (a(exc)) {
            this.f16664a.a(null);
        } else {
            this.f16664a.onError(exc.getMessage());
        }
    }
}
