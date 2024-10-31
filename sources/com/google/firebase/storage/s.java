package com.google.firebase.storage;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a */
    private final v f18193a;

    /* renamed from: b */
    private final Object f18194b;

    private s(v vVar, Object obj) {
        this.f18193a = vVar;
        this.f18194b = obj;
    }

    public static Runnable a(v vVar, Object obj) {
        return new s(vVar, obj);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18193a.a(this.f18194b);
    }
}
