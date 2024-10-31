package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [ResultT] */
/* renamed from: com.google.firebase.auth.api.internal.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1563c<ResultT> implements Continuation<ResultT, Task<ResultT>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzam f16453a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzao f16454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1563c(zzao zzaoVar, zzam zzamVar) {
        this.f16454b = zzaoVar;
        this.f16453a = zzamVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) throws Exception {
        return task.a() instanceof UnsupportedApiCallException ? this.f16454b.a(this.f16453a.c()) : task;
    }
}
