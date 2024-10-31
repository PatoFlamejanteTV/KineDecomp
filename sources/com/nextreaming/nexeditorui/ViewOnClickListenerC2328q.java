package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.q */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2328q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24390a;

    public ViewOnClickListenerC2328q(ColorPickerPopup colorPickerPopup) {
        this.f24390a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f24390a.b(ColorPickerPopup.ColorTab.Wheel);
        this.f24390a.a(ColorPickerPopup.ColorTab.Wheel);
    }
}
