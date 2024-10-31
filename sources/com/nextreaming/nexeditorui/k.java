package com.nextreaming.nexeditorui;

import android.widget.PopupWindow;
import android.widget.TextView;

/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
class k implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f4653a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, TextView textView) {
        this.b = iVar;
        this.f4653a = textView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f4653a.setBackgroundColor(0);
    }
}
