package com.google.firebase.auth.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class X implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Y f16445a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ S f16446b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(S s, Y y) {
        this.f16446b = s;
        this.f16445a = y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16446b.f16440a.f16439h) {
            if (!this.f16446b.f16440a.f16439h.isEmpty()) {
                this.f16445a.a(this.f16446b.f16440a.f16439h.get(0), new Object[0]);
            }
        }
    }
}
