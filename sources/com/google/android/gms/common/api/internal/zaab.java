package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zaab {

    /* renamed from: a, reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f10865a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final Map<TaskCompletionSource<?>, Boolean> f10866b = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.f10865a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.a((PendingResult.StatusListener) new C0798b(this, basePendingResult));
    }

    public final void b() {
        a(false, GoogleApiManager.f10739a);
    }

    public final void c() {
        a(true, zacp.f10923a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <TResult> void a(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        this.f10866b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.a().a(new C0799c(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return (this.f10865a.isEmpty() && this.f10866b.isEmpty()) ? false : true;
    }

    private final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f10865a) {
            hashMap = new HashMap(this.f10865a);
        }
        synchronized (this.f10866b) {
            hashMap2 = new HashMap(this.f10866b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).b((Exception) new ApiException(status));
            }
        }
    }
}
