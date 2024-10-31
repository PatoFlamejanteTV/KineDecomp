package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class j implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f14299a;

    /* renamed from: b */
    private final /* synthetic */ i f14300b;

    public j(i iVar, Task task) {
        this.f14300b = iVar;
        this.f14299a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCompleteListener onCompleteListener;
        OnCompleteListener onCompleteListener2;
        obj = this.f14300b.f14297b;
        synchronized (obj) {
            onCompleteListener = this.f14300b.f14298c;
            if (onCompleteListener != null) {
                onCompleteListener2 = this.f14300b.f14298c;
                onCompleteListener2.onComplete(this.f14299a);
            }
        }
    }
}
