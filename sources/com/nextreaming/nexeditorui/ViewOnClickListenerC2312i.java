package com.nextreaming.nexeditorui;

import android.view.View;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.i */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2312i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f24293a;

    /* renamed from: b */
    final /* synthetic */ ColorPickerPopup f24294b;

    public ViewOnClickListenerC2312i(ColorPickerPopup colorPickerPopup, int i) {
        this.f24294b = colorPickerPopup;
        this.f24293a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int d2;
        z = this.f24294b.f23995e;
        if (z) {
            ColorPickerPopup colorPickerPopup = this.f24294b;
            d2 = colorPickerPopup.d(this.f24293a);
            colorPickerPopup.f23998h = d2;
            this.f24294b.a(true);
            this.f24294b.g();
        }
    }
}
