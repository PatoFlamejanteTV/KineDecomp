package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public final class BatchResult implements Result {

    /* renamed from: a */
    private final Status f10680a;

    /* renamed from: b */
    private final PendingResult<?>[] f10681b;

    public BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f10680a = status;
        this.f10681b = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f10680a;
    }
}
