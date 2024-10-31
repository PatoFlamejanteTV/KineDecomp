package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class h implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ g f14295a;

    public h(g gVar) {
        this.f14295a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.f14295a.f14293b;
        synchronized (obj) {
            onCanceledListener = this.f14295a.f14294c;
            if (onCanceledListener != null) {
                onCanceledListener2 = this.f14295a.f14294c;
                onCanceledListener2.a();
            }
        }
    }
}
