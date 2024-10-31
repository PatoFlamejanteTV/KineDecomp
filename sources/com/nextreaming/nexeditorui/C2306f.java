package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.f */
/* loaded from: classes.dex */
public class C2306f implements Slider.a {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24247a;

    public C2306f(ColorPickerPopup colorPickerPopup) {
        this.f24247a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        int i;
        ColorPickerPopup colorPickerPopup = this.f24247a;
        i = colorPickerPopup.f23998h;
        colorPickerPopup.f23998h = ((((int) f2) & 255) << 16) | (i & (-16711681));
        this.f24247a.a(false);
        this.f24247a.g();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
