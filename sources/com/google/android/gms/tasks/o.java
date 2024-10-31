package com.google.android.gms.tasks;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface o<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
