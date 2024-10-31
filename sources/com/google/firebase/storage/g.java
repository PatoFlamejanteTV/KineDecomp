package com.google.firebase.storage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements OnSuccessListener {

    /* renamed from: a */
    private final TaskCompletionSource f18147a;

    private g(TaskCompletionSource taskCompletionSource) {
        this.f18147a = taskCompletionSource;
    }

    public static OnSuccessListener a(TaskCompletionSource taskCompletionSource) {
        return new g(taskCompletionSource);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        this.f18147a.a((TaskCompletionSource) obj);
    }
}
