package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: classes2.dex */
public final class zzz {

    /* renamed from: a, reason: collision with root package name */
    private static final zzz f16555a = new zzz();

    /* renamed from: b, reason: collision with root package name */
    private final zzac f16556b;

    /* renamed from: c, reason: collision with root package name */
    private final zzx f16557c;

    private zzz() {
        this(zzac.a(), zzx.a());
    }

    public static zzz a() {
        return f16555a;
    }

    private zzz(zzac zzacVar, zzx zzxVar) {
        this.f16556b = zzacVar;
        this.f16557c = zzxVar;
    }

    public final void a(FirebaseAuth firebaseAuth) {
        this.f16556b.a(firebaseAuth);
    }

    public final void a(Context context) {
        this.f16556b.a(context);
    }
}
