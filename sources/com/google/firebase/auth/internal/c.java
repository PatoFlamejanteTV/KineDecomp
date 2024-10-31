package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final String f16498a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzs f16499b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzs zzsVar, String str) {
        this.f16499b = zzsVar;
        Preconditions.b(str);
        this.f16498a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Logger logger;
        FirebaseApp a2 = FirebaseApp.a(this.f16498a);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(a2);
        zzy.a(a2.b());
        try {
            z = zzy.f16554a.a().booleanValue();
        } catch (SecurityException unused) {
            z = true;
        }
        if (firebaseAuth.a() == null || !z) {
            return;
        }
        Task<GetTokenResult> a3 = firebaseAuth.a(true);
        logger = zzs.f16544a;
        logger.d("Token refreshing started", new Object[0]);
        a3.a(new d(this));
    }
}
