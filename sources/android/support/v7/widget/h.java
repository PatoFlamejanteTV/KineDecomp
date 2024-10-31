package android.support.v7.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f225a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View d = this.f225a.d();
        if (d != null && d.getWindowToken() != null) {
            this.f225a.c();
        }
    }
}
