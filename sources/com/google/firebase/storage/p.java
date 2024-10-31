package com.google.firebase.storage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class p implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18186a;

    /* renamed from: b, reason: collision with root package name */
    private final Continuation f18187b;

    /* renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f18188c;

    private p(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource) {
        this.f18186a = storageTask;
        this.f18187b = continuation;
        this.f18188c = taskCompletionSource;
    }

    public static OnCompleteListener a(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource) {
        return new p(storageTask, continuation, taskCompletionSource);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        StorageTask.a(this.f18186a, this.f18187b, this.f18188c, task);
    }
}
