package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class g implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ColorPickerPopup colorPickerPopup) {
        this.f4649a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        int i;
        ColorPickerPopup colorPickerPopup = this.f4649a;
        i = this.f4649a.f;
        colorPickerPopup.f = (i & (-256)) | (((int) f) & 255);
        this.f4649a.a(false);
        this.f4649a.i();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
