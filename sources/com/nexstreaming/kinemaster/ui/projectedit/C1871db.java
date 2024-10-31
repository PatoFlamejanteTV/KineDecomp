package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.db, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1871db implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1898gb f22308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1871db(ViewOnClickListenerC1898gb viewOnClickListenerC1898gb) {
        this.f22308a = viewOnClickListenerC1898gb;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f22308a.f22348a.ea = null;
        this.f22308a.f22348a.Ba();
    }
}
