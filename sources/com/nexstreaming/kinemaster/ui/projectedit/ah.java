package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
public class ah implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3761a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(HandwritingEditFragment handwritingEditFragment) {
        this.f3761a = handwritingEditFragment;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f3761a.A = null;
        this.f3761a.Q();
    }
}
