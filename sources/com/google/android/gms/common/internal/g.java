package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class g implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PendingResult f11149a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f11150b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ PendingResultUtil.ResultConverter f11151c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ PendingResultUtil.zaa f11152d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaaVar) {
        this.f11149a = pendingResult;
        this.f11150b = taskCompletionSource;
        this.f11151c = resultConverter;
        this.f11152d = zaaVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        if (status.Q()) {
            this.f11150b.a((TaskCompletionSource) this.f11151c.a(this.f11149a.a(0L, TimeUnit.MILLISECONDS)));
        } else {
            this.f11150b.a((Exception) this.f11152d.a(status));
        }
    }
}
