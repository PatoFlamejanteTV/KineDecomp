package android.support.v7.internal.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f190a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, View view) {
        this.b = sVar;
        this.f190a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.smoothScrollTo(this.f190a.getLeft() - ((this.b.getWidth() - this.f190a.getWidth()) / 2), 0);
        this.b.f186a = null;
    }
}
