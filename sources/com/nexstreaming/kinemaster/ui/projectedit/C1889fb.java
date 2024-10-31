package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1889fb implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1898gb f22332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1889fb(ViewOnClickListenerC1898gb viewOnClickListenerC1898gb) {
        this.f22332a = viewOnClickListenerC1898gb;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f22332a.f22348a.ea = null;
        this.f22332a.f22348a.Ba();
    }
}
