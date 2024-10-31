package android.support.v4.app;

import android.support.v4.app.d;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public class g implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f57a;
    final /* synthetic */ d.b b;
    final /* synthetic */ int c;
    final /* synthetic */ Object d;
    final /* synthetic */ d e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, View view, d.b bVar, int i, Object obj) {
        this.e = dVar;
        this.f57a = view;
        this.b = bVar;
        this.c = i;
        this.d = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f57a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.e.a(this.b, this.c, this.d);
        return true;
    }
}
