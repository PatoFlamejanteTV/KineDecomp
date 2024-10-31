package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final v f18195a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f18196b;

    /* renamed from: c, reason: collision with root package name */
    private final StorageTask.ProvideError f18197c;

    private t(v vVar, Object obj, StorageTask.ProvideError provideError) {
        this.f18195a = vVar;
        this.f18196b = obj;
        this.f18197c = provideError;
    }

    public static Runnable a(v vVar, Object obj, StorageTask.ProvideError provideError) {
        return new t(vVar, obj, provideError);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18195a.f18205e.a(this.f18196b, this.f18197c);
    }
}
