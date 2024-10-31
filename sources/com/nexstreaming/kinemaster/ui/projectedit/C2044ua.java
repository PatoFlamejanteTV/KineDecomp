package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ua */
/* loaded from: classes2.dex */
public class C2044ua implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ CustomMaskEditFragment f22713a;

    public C2044ua(CustomMaskEditFragment customMaskEditFragment) {
        this.f22713a = customMaskEditFragment;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f22713a.I = null;
        this.f22713a.wa();
    }
}
