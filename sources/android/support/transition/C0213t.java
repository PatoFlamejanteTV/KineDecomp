package android.support.transition;

import android.support.transition.M;
import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransitionSupport.java */
/* renamed from: android.support.transition.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0213t implements M.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f645a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f646b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ FragmentTransitionSupport f647c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0213t(FragmentTransitionSupport fragmentTransitionSupport, View view, ArrayList arrayList) {
        this.f647c = fragmentTransitionSupport;
        this.f645a = view;
        this.f646b = arrayList;
    }

    @Override // android.support.transition.M.c
    public void a(M m) {
    }

    @Override // android.support.transition.M.c
    public void b(M m) {
    }

    @Override // android.support.transition.M.c
    public void c(M m) {
    }

    @Override // android.support.transition.M.c
    public void d(M m) {
        m.b(this);
        this.f645a.setVisibility(8);
        int size = this.f646b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f646b.get(i)).setVisibility(0);
        }
    }
}
