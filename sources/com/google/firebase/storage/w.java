package com.google.firebase.storage;

import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetworkRequest f18206a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ UploadTask f18207b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(UploadTask uploadTask, NetworkRequest networkRequest) {
        this.f18207b = uploadTask;
        this.f18206a = networkRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        StorageReference storageReference;
        StorageReference storageReference2;
        NetworkRequest networkRequest = this.f18206a;
        storageReference = this.f18207b.l;
        String a2 = Util.a(storageReference.a());
        storageReference2 = this.f18207b.l;
        networkRequest.a(a2, storageReference2.a().b());
    }
}
