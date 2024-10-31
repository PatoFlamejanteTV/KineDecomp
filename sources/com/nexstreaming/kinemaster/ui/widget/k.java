package com.nexstreaming.kinemaster.ui.widget;

import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopoutMenu.java */
/* loaded from: classes.dex */
public class k implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f4396a = jVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f4396a.b();
    }
}
