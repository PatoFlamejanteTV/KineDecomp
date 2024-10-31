package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class aw implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ as f3776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(as asVar) {
        this.f3776a = asVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f3776a.f3772a.A = null;
        this.f3776a.f3772a.Q();
    }
}
