package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.ColorWheelView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class s implements ColorWheelView.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ColorPickerPopup colorPickerPopup) {
        this.f4755a = colorPickerPopup;
    }

    @Override // com.nextreaming.nexeditorui.ColorWheelView.a
    public void a(int i) {
        int e;
        ColorPickerPopup colorPickerPopup = this.f4755a;
        e = this.f4755a.e(i);
        colorPickerPopup.f = e;
        this.f4755a.a(false);
        this.f4755a.i();
    }
}
