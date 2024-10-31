package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.ColorWheelView;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.v */
/* loaded from: classes.dex */
public class C2337v implements ColorWheelView.a {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24402a;

    public C2337v(ColorPickerPopup colorPickerPopup) {
        this.f24402a = colorPickerPopup;
    }

    @Override // com.nextreaming.nexeditorui.ColorWheelView.a
    public void a(int i) {
        int d2;
        ColorPickerPopup colorPickerPopup = this.f24402a;
        d2 = colorPickerPopup.d(i);
        colorPickerPopup.f23998h = d2;
        this.f24402a.a(false);
        this.f24402a.g();
    }
}
