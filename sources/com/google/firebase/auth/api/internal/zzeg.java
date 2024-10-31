package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzeg {

    /* renamed from: a */
    private String f16481a;

    public zzeg(String str) {
        Preconditions.b(str);
        this.f16481a = str;
    }

    public final zzef a() {
        return new zzef(this.f16481a, null);
    }
}
