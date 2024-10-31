package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class o implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private static final o f18185a = new o();

    private o() {
    }

    public static v.a a() {
        return f18185a;
    }

    @Override // com.google.firebase.storage.v.a
    public void a(Object obj, Object obj2) {
        ((OnPausedListener) obj).a((StorageTask.ProvideError) obj2);
    }
}
