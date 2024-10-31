package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [TResult] */
/* renamed from: com.google.android.gms.common.api.internal.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0799c<TResult> implements OnCompleteListener<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f10828a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaab f10829b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0799c(zaab zaabVar, TaskCompletionSource taskCompletionSource) {
        this.f10829b = zaabVar;
        this.f10828a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<TResult> task) {
        Map map;
        map = this.f10829b.f10866b;
        map.remove(this.f10828a);
    }
}
