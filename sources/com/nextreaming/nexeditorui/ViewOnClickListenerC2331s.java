package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.s */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2331s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24394a;

    public ViewOnClickListenerC2331s(ColorPickerPopup colorPickerPopup) {
        this.f24394a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f24394a.b(ColorPickerPopup.ColorTab.Sliders);
        this.f24394a.a(ColorPickerPopup.ColorTab.Sliders);
    }
}
