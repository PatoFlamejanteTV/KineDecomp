package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private static final n f18176a = new n();

    private n() {
    }

    public static v.a a() {
        return f18176a;
    }

    @Override // com.google.firebase.storage.v.a
    public void a(Object obj, Object obj2) {
        ((OnProgressListener) obj).a((StorageTask.ProvideError) obj2);
    }
}
