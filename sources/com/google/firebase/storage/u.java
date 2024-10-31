package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final v f18198a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f18199b;

    /* renamed from: c, reason: collision with root package name */
    private final StorageTask.ProvideError f18200c;

    private u(v vVar, Object obj, StorageTask.ProvideError provideError) {
        this.f18198a = vVar;
        this.f18199b = obj;
        this.f18200c = provideError;
    }

    public static Runnable a(v vVar, Object obj, StorageTask.ProvideError provideError) {
        return new u(vVar, obj, provideError);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18198a.f18205e.a(this.f18199b, this.f18200c);
    }
}
