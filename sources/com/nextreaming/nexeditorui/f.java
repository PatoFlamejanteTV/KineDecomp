package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class f implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ColorPickerPopup colorPickerPopup) {
        this.f4623a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        int i;
        ColorPickerPopup colorPickerPopup = this.f4623a;
        i = this.f4623a.f;
        colorPickerPopup.f = (i & (-65281)) | ((((int) f) & 255) << 8);
        this.f4623a.a(false);
        this.f4623a.i();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
