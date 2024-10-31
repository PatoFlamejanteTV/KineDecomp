package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class t implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ColorPickerPopup colorPickerPopup) {
        this.f4756a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        int i;
        int e;
        ColorPickerPopup colorPickerPopup = this.f4756a;
        ColorPickerPopup colorPickerPopup2 = this.f4756a;
        i = this.f4756a.f;
        e = colorPickerPopup2.e(i);
        colorPickerPopup.f = e;
        this.f4756a.a(false);
        this.f4756a.i();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
