package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
public class Qa implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(HandwritingEditFragment handwritingEditFragment) {
        this.f22029a = handwritingEditFragment;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f22029a.ea = null;
        this.f22029a.Ba();
    }
}
