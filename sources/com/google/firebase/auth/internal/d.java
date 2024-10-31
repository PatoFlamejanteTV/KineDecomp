package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

/* loaded from: classes2.dex */
final class d implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c f16500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f16500a = cVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Logger logger;
        if (exc instanceof FirebaseNetworkException) {
            logger = zzs.f16544a;
            logger.d("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f16500a.f16499b.c();
        }
    }
}
