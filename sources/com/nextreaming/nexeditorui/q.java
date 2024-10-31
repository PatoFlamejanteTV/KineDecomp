package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ColorPickerPopup colorPickerPopup) {
        this.f4753a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ColorPickerPopup.ColorDetailsMode colorDetailsMode;
        ColorPickerPopup.ColorDetailsMode colorDetailsMode2;
        ColorPickerPopup.ColorDetailsMode colorDetailsMode3;
        colorDetailsMode = this.f4753a.o;
        if (colorDetailsMode != ColorPickerPopup.ColorDetailsMode.HSV) {
            colorDetailsMode2 = this.f4753a.o;
            if (colorDetailsMode2 == ColorPickerPopup.ColorDetailsMode.RGB) {
                this.f4753a.o = ColorPickerPopup.ColorDetailsMode.HSV;
            } else {
                this.f4753a.o = ColorPickerPopup.ColorDetailsMode.RGB;
            }
        } else {
            this.f4753a.o = ColorPickerPopup.ColorDetailsMode.RGB;
        }
        ColorPickerPopup colorPickerPopup = this.f4753a;
        colorDetailsMode3 = this.f4753a.o;
        colorPickerPopup.a(colorDetailsMode3);
        this.f4753a.a(false);
    }
}
