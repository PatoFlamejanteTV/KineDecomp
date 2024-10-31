package com.google.firebase.storage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class l implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18174a;

    private l(StorageTask storageTask) {
        this.f18174a = storageTask;
    }

    public static v.a a(StorageTask storageTask) {
        return new l(storageTask);
    }

    @Override // com.google.firebase.storage.v.a
    public void a(Object obj, Object obj2) {
        StorageTask.a(this.f18174a, (OnCompleteListener) obj, (StorageTask.ProvideError) obj2);
    }
}
