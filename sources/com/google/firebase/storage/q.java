package com.google.firebase.storage;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final q f18189a = new q();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, WeakReference<StorageTask>> f18190b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Object f18191c = new Object();

    q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q a() {
        return f18189a;
    }

    public void b(StorageTask storageTask) {
        synchronized (this.f18191c) {
            String storageReference = storageTask.h().toString();
            WeakReference<StorageTask> weakReference = this.f18190b.get(storageReference);
            StorageTask storageTask2 = weakReference != null ? weakReference.get() : null;
            if (storageTask2 == null || storageTask2 == storageTask) {
                this.f18190b.remove(storageReference);
            }
        }
    }

    public void a(StorageTask storageTask) {
        synchronized (this.f18191c) {
            this.f18190b.put(storageTask.h().toString(), new WeakReference<>(storageTask));
        }
    }
}
