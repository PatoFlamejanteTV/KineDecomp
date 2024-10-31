package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements OnFailureListener {

    /* renamed from: a */
    private final TaskCompletionSource f18148a;

    private h(TaskCompletionSource taskCompletionSource) {
        this.f18148a = taskCompletionSource;
    }

    public static OnFailureListener a(TaskCompletionSource taskCompletionSource) {
        return new h(taskCompletionSource);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        this.f18148a.a(exc);
    }
}
