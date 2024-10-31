package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.w */
/* loaded from: classes.dex */
public class C2339w implements Slider.a {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24404a;

    public C2339w(ColorPickerPopup colorPickerPopup) {
        this.f24404a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        int i;
        int d2;
        ColorPickerPopup colorPickerPopup = this.f24404a;
        i = colorPickerPopup.f23998h;
        d2 = colorPickerPopup.d(i);
        colorPickerPopup.f23998h = d2;
        this.f24404a.a(false);
        this.f24404a.g();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
