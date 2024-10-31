package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {
    private final PendingResult<?>[] q;

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public final void a() {
        super.a();
        for (PendingResult<?> pendingResult : this.q) {
            pendingResult.a();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final BatchResult a(Status status) {
        return new BatchResult(status, this.q);
    }
}
