package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class l implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f14304a;

    /* renamed from: b */
    private final /* synthetic */ k f14305b;

    public l(k kVar, Task task) {
        this.f14305b = kVar;
        this.f14304a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.f14305b.f14302b;
        synchronized (obj) {
            onFailureListener = this.f14305b.f14303c;
            if (onFailureListener != null) {
                onFailureListener2 = this.f14305b.f14303c;
                onFailureListener2.onFailure(this.f14304a.a());
            }
        }
    }
}
