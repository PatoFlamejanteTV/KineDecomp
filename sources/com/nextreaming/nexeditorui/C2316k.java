package com.nextreaming.nexeditorui;

import android.widget.PopupWindow;
import android.widget.TextView;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.k */
/* loaded from: classes.dex */
class C2316k implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ TextView f24305a;

    /* renamed from: b */
    final /* synthetic */ ViewOnLongClickListenerC2318l f24306b;

    public C2316k(ViewOnLongClickListenerC2318l viewOnLongClickListenerC2318l, TextView textView) {
        this.f24306b = viewOnLongClickListenerC2318l;
        this.f24305a = textView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f24305a.setBackgroundColor(0);
    }
}
