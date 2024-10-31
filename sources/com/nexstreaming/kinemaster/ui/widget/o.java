package com.nexstreaming.kinemaster.ui.widget;

import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopoutMenu.java */
/* loaded from: classes2.dex */
public class o implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ p f23876a;

    public o(p pVar) {
        this.f23876a = pVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f23876a.b();
    }
}
