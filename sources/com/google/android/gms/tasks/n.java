package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class n implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f14309a;

    /* renamed from: b */
    private final /* synthetic */ m f14310b;

    public n(m mVar, Task task) {
        this.f14310b = mVar;
        this.f14309a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.f14310b.f14307b;
        synchronized (obj) {
            onSuccessListener = this.f14310b.f14308c;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.f14310b.f14308c;
                onSuccessListener2.onSuccess(this.f14309a.b());
            }
        }
    }
}
