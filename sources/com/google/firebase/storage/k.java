package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18173a;

    private k(StorageTask storageTask) {
        this.f18173a = storageTask;
    }

    public static v.a a(StorageTask storageTask) {
        return new k(storageTask);
    }

    @Override // com.google.firebase.storage.v.a
    public void a(Object obj, Object obj2) {
        StorageTask.a(this.f18173a, (OnFailureListener) obj, (StorageTask.ProvideError) obj2);
    }
}
