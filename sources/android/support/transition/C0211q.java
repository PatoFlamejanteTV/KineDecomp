package android.support.transition;

import android.view.View;

/* compiled from: Fade.java */
/* renamed from: android.support.transition.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0211q extends N {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f624a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f625b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0211q(r rVar, View view) {
        this.f625b = rVar;
        this.f624a = view;
    }

    @Override // android.support.transition.M.c
    public void d(M m) {
        ka.a(this.f624a, 1.0f);
        ka.a(this.f624a);
        m.b(this);
    }
}
