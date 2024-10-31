package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzp {

    /* renamed from: a, reason: collision with root package name */
    private static zzp f10608a;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private Storage f10609b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private GoogleSignInAccount f10610c;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private GoogleSignInOptions f10611d;

    private zzp(Context context) {
        this.f10609b = Storage.a(context);
        this.f10610c = this.f10609b.b();
        this.f10611d = this.f10609b.c();
    }

    public static synchronized zzp a(Context context) {
        zzp b2;
        synchronized (zzp.class) {
            b2 = b(context.getApplicationContext());
        }
        return b2;
    }

    private static synchronized zzp b(Context context) {
        zzp zzpVar;
        synchronized (zzp.class) {
            if (f10608a == null) {
                f10608a = new zzp(context);
            }
            zzpVar = f10608a;
        }
        return zzpVar;
    }

    public final synchronized void a() {
        this.f10609b.a();
        this.f10610c = null;
        this.f10611d = null;
    }

    public final synchronized void a(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f10609b.a(googleSignInAccount, googleSignInOptions);
        this.f10610c = googleSignInAccount;
        this.f10611d = googleSignInOptions;
    }
}
