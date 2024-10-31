package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StreamDownloadTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class c implements OnSuccessListener<StreamDownloadTask.TaskSnapshot> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f18137a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StorageReference f18138b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(StorageReference storageReference, TaskCompletionSource taskCompletionSource) {
        this.f18138b = storageReference;
        this.f18137a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    @PublicApi
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        if (this.f18137a.a().d()) {
            return;
        }
        Log.e("StorageReference", "getBytes 'succeeded', but failed to set a Result.");
        this.f18137a.a((Exception) StorageException.fromErrorStatus(Status.f10706c));
    }
}
