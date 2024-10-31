package com.google.firebase.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final StorageTask f18146a;

    private f(StorageTask storageTask) {
        this.f18146a = storageTask;
    }

    public static Runnable a(StorageTask storageTask) {
        return new f(storageTask);
    }

    @Override // java.lang.Runnable
    public void run() {
        StorageTask.a(this.f18146a);
    }
}
