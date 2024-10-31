package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18142a;

    /* renamed from: b, reason: collision with root package name */
    private final Continuation f18143b;

    /* renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f18144c;

    /* renamed from: d, reason: collision with root package name */
    private final CancellationTokenSource f18145d;

    private e(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.f18142a = storageTask;
        this.f18143b = continuation;
        this.f18144c = taskCompletionSource;
        this.f18145d = cancellationTokenSource;
    }

    public static OnCompleteListener a(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        return new e(storageTask, continuation, taskCompletionSource, cancellationTokenSource);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        StorageTask.a(this.f18142a, this.f18143b, this.f18144c, this.f18145d, task);
    }
}
