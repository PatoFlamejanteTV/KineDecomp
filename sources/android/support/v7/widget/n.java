package android.support.v7.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Toolbar toolbar) {
        this.f231a = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f231a.c();
    }
}
