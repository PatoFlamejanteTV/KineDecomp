package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1977pa implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC2003sa f22477a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1977pa(ViewOnClickListenerC2003sa viewOnClickListenerC2003sa) {
        this.f22477a = viewOnClickListenerC2003sa;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f22477a.f22518a.I = null;
        this.f22477a.f22518a.wa();
    }
}
