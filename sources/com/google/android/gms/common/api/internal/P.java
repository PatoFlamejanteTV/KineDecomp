package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class P {

    /* renamed from: a */
    private final int f10787a;

    /* renamed from: b */
    private final ConnectionResult f10788b;

    public P(ConnectionResult connectionResult, int i) {
        Preconditions.a(connectionResult);
        this.f10788b = connectionResult;
        this.f10787a = i;
    }

    public final ConnectionResult a() {
        return this.f10788b;
    }

    public final int b() {
        return this.f10787a;
    }
}
