package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ColorPickerPopup colorPickerPopup) {
        this.f4656a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4656a.b(ColorPickerPopup.ColorTab.Wheel);
        this.f4656a.a(ColorPickerPopup.ColorTab.Wheel);
    }
}
