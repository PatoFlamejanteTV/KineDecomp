package com.nextreaming.nexeditorui;

import android.view.View;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.u */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2335u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24400a;

    public ViewOnClickListenerC2335u(ColorPickerPopup colorPickerPopup) {
        this.f24400a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        int i3;
        i = this.f24400a.f23998h;
        i2 = this.f24400a.i;
        if (i != i2) {
            ColorPickerPopup colorPickerPopup = this.f24400a;
            i3 = colorPickerPopup.i;
            colorPickerPopup.f23998h = i3;
            this.f24400a.a(true);
            this.f24400a.g();
        }
    }
}
