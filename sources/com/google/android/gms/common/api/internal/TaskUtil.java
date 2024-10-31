package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public class TaskUtil {
    @KeepForSdk
    public static void a(Status status, TaskCompletionSource<Void> taskCompletionSource) {
        a(status, null, taskCompletionSource);
    }

    @KeepForSdk
    public static <TResult> void a(Status status, TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.Q()) {
            taskCompletionSource.a((TaskCompletionSource<TResult>) tresult);
        } else {
            taskCompletionSource.a((Exception) new ApiException(status));
        }
    }
}
