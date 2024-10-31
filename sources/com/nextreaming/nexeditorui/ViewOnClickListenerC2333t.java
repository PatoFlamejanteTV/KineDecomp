package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.t */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2333t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24398a;

    public ViewOnClickListenerC2333t(ColorPickerPopup colorPickerPopup) {
        this.f24398a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ColorPickerPopup.ColorDetailsMode colorDetailsMode;
        ColorPickerPopup.ColorDetailsMode colorDetailsMode2;
        ColorPickerPopup.ColorDetailsMode colorDetailsMode3;
        colorDetailsMode = this.f24398a.p;
        if (colorDetailsMode != ColorPickerPopup.ColorDetailsMode.HSV) {
            colorDetailsMode2 = this.f24398a.p;
            ColorPickerPopup.ColorDetailsMode colorDetailsMode4 = ColorPickerPopup.ColorDetailsMode.RGB;
            if (colorDetailsMode2 == colorDetailsMode4) {
                this.f24398a.p = ColorPickerPopup.ColorDetailsMode.HSV;
            } else {
                this.f24398a.p = colorDetailsMode4;
            }
        } else {
            this.f24398a.p = ColorPickerPopup.ColorDetailsMode.RGB;
        }
        ColorPickerPopup colorPickerPopup = this.f24398a;
        colorDetailsMode3 = colorPickerPopup.p;
        colorPickerPopup.a(colorDetailsMode3);
        this.f24398a.a(false);
    }
}
