package com.nextreaming.nexeditorui;

import android.support.v4.view.InputDeviceCompat;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.h */
/* loaded from: classes.dex */
public class C2310h implements Slider.a {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24289a;

    public C2310h(ColorPickerPopup colorPickerPopup) {
        this.f24289a = colorPickerPopup;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        int i;
        ColorPickerPopup colorPickerPopup = this.f24289a;
        i = colorPickerPopup.f23998h;
        colorPickerPopup.f23998h = (((int) f2) & 255) | (i & InputDeviceCompat.SOURCE_ANY);
        this.f24289a.a(false);
        this.f24289a.g();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
