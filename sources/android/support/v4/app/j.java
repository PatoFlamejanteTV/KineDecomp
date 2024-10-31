package android.support.v4.app;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Fragment.java */
/* loaded from: classes.dex */
public class j implements o {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f58a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Fragment fragment) {
        this.f58a = fragment;
    }

    @Override // android.support.v4.app.o
    public View a(int i) {
        if (this.f58a.mView == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return this.f58a.mView.findViewById(i);
    }

    @Override // android.support.v4.app.o
    public boolean a() {
        return this.f58a.mView != null;
    }
}
