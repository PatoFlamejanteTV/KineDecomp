package com.google.firebase.storage;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18175a;

    private m(StorageTask storageTask) {
        this.f18175a = storageTask;
    }

    public static v.a a(StorageTask storageTask) {
        return new m(storageTask);
    }

    @Override // com.google.firebase.storage.v.a
    public void a(Object obj, Object obj2) {
        StorageTask.a(this.f18175a, (OnCanceledListener) obj, (StorageTask.ProvideError) obj2);
    }
}
