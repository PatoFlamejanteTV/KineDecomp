package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public final class BatchResult implements Result {

    /* renamed from: a, reason: collision with root package name */
    private final Status f973a;
    private final PendingResult<?>[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f973a = status;
        this.b = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f973a;
    }
}
