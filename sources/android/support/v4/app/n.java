package android.support.v4.app;

import android.view.View;
import android.view.Window;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class n implements o {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f61a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f61a = lVar;
    }

    @Override // android.support.v4.app.o
    public View a(int i) {
        return this.f61a.findViewById(i);
    }

    @Override // android.support.v4.app.o
    public boolean a() {
        Window window = this.f61a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
