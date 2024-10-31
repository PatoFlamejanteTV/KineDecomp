package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzef extends zzaj implements Api.ApiOptions.HasOptions {

    /* renamed from: b */
    private final String f16480b;

    private zzef(String str) {
        Preconditions.a(str, (Object) "A valid API key must be provided");
        this.f16480b = str;
    }

    @Override // com.google.firebase.auth.api.internal.zzaj
    /* renamed from: c */
    public final /* synthetic */ zzaj clone() {
        return (zzef) clone();
    }

    @Override // com.google.firebase.auth.api.internal.zzaj
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzeg(this.f16480b).a();
    }

    public final String d() {
        return this.f16480b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzef) {
            return Objects.a(this.f16480b, ((zzef) obj).f16480b);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.a(this.f16480b);
    }

    public /* synthetic */ zzef(String str, O o) {
        this(str);
    }
}
