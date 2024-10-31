package com.google.firebase.storage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18172a;

    private j(StorageTask storageTask) {
        this.f18172a = storageTask;
    }

    public static v.a a(StorageTask storageTask) {
        return new j(storageTask);
    }

    @Override // com.google.firebase.storage.v.a
    public void a(Object obj, Object obj2) {
        StorageTask.a(this.f18172a, (OnSuccessListener) obj, (StorageTask.ProvideError) obj2);
    }
}
