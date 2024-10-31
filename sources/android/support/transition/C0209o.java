package android.support.transition;

import android.view.ViewGroup;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0209o extends N {

    /* renamed from: a, reason: collision with root package name */
    boolean f610a = false;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewGroup f611b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0210p f612c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0209o(C0210p c0210p, ViewGroup viewGroup) {
        this.f612c = c0210p;
        this.f611b = viewGroup;
    }

    @Override // android.support.transition.N, android.support.transition.M.c
    public void a(M m) {
        aa.a(this.f611b, true);
    }

    @Override // android.support.transition.N, android.support.transition.M.c
    public void b(M m) {
        aa.a(this.f611b, false);
    }

    @Override // android.support.transition.M.c
    public void d(M m) {
        if (!this.f610a) {
            aa.a(this.f611b, false);
        }
        m.b(this);
    }
}
