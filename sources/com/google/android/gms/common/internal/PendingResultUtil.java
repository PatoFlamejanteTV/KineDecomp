package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public class PendingResultUtil {

    /* renamed from: a */
    private static final zaa f11119a = new f();

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ResultConverter<R extends Result, T> {
        @KeepForSdk
        T a(R r);
    }

    /* loaded from: classes.dex */
    public interface zaa {
        ApiException a(Status status);
    }

    @KeepForSdk
    public static <R extends Result, T> Task<T> a(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter) {
        zaa zaaVar = f11119a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.a(new g(pendingResult, taskCompletionSource, resultConverter, zaaVar));
        return taskCompletionSource.a();
    }

    @KeepForSdk
    public static <R extends Result> Task<Void> a(PendingResult<R> pendingResult) {
        return a(pendingResult, new h());
    }
}
