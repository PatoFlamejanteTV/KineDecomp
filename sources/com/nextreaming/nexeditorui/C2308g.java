package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.g */
/* loaded from: classes.dex */
public class C2308g implements Slider.a {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24283a;

    public C2308g(ColorPickerPopup colorPickerPopup) {
        this.f24283a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        int i;
        ColorPickerPopup colorPickerPopup = this.f24283a;
        i = colorPickerPopup.f23998h;
        colorPickerPopup.f23998h = ((((int) f2) & 255) << 8) | (i & (-65281));
        this.f24283a.a(false);
        this.f24283a.g();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
