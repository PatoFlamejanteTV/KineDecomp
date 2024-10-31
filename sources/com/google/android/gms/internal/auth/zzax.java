package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class zzax implements ProxyApi.SpatulaHeaderResult {
    private Status mStatus;
    private String zzci;

    public zzax(@Nonnull String str) {
        Preconditions.a(str);
        this.zzci = str;
        this.mStatus = Status.f10704a;
    }

    @Nullable
    public final String getSpatulaHeader() {
        return this.zzci;
    }

    @Override // com.google.android.gms.common.api.Result
    @Nullable
    public final Status getStatus() {
        return this.mStatus;
    }

    public zzax(@Nonnull Status status) {
        Preconditions.a(status);
        this.mStatus = status;
    }
}
