package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzlc;

/* loaded from: classes.dex */
public final class Batch extends zzlc<BatchResult> {

    /* renamed from: a, reason: collision with root package name */
    private final PendingResult<?>[] f972a;

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BatchResult zzb(Status status) {
        return new BatchResult(status, this.f972a);
    }

    @Override // com.google.android.gms.internal.zzlc, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.f972a) {
            pendingResult.cancel();
        }
    }
}
