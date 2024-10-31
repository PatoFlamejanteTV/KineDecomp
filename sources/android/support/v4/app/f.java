package android.support.v4.app;

import android.support.v4.app.d;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public class f implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f56a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ d.b d;
    final /* synthetic */ boolean e;
    final /* synthetic */ Fragment f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ d h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, View view, Object obj, ArrayList arrayList, d.b bVar, boolean z, Fragment fragment, Fragment fragment2) {
        this.h = dVar;
        this.f56a = view;
        this.b = obj;
        this.c = arrayList;
        this.d = bVar;
        this.e = z;
        this.f = fragment;
        this.g = fragment2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        android.support.v4.f.a a2;
        this.f56a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            x.a(this.b, (ArrayList<View>) this.c);
            this.c.clear();
            a2 = this.h.a(this.d, this.e, this.f);
            this.c.add(this.d.d);
            this.c.addAll(a2.values());
            x.b(this.b, (ArrayList<View>) this.c);
            this.h.a((android.support.v4.f.a<String, View>) a2, this.d);
            this.h.a(this.d, this.f, this.g, this.e, (android.support.v4.f.a<String, View>) a2);
            return true;
        }
        return true;
    }
}
