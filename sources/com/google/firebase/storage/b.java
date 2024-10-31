package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.annotations.PublicApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class b implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f18135a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StorageReference f18136b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(StorageReference storageReference, TaskCompletionSource taskCompletionSource) {
        this.f18136b = storageReference;
        this.f18135a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    @PublicApi
    public void onFailure(Exception exc) {
        this.f18135a.a((Exception) StorageException.fromExceptionAndHttpCode(exc, 0));
    }
}
