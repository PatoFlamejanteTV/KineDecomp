package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class e implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4616a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ColorPickerPopup colorPickerPopup) {
        this.f4616a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        int i;
        ColorPickerPopup colorPickerPopup = this.f4616a;
        i = this.f4616a.f;
        colorPickerPopup.f = (i & (-16711681)) | ((((int) f) & 255) << 16);
        this.f4616a.a(false);
        this.f4616a.i();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
