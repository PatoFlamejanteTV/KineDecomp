package com.nextreaming.nexeditorui;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ColorPickerPopup colorPickerPopup) {
        this.f4754a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        int i3;
        i = this.f4754a.f;
        i2 = this.f4754a.g;
        if (i != i2) {
            ColorPickerPopup colorPickerPopup = this.f4754a;
            i3 = this.f4754a.g;
            colorPickerPopup.f = i3;
            this.f4754a.a(true);
            this.f4754a.i();
        }
    }
}
