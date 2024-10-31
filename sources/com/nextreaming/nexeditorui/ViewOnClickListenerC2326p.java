package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.p */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2326p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24387a;

    public ViewOnClickListenerC2326p(ColorPickerPopup colorPickerPopup) {
        this.f24387a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ColorPickerPopup.b bVar;
        ColorPickerPopup.b bVar2;
        int i2;
        ColorPickerPopup colorPickerPopup = this.f24387a;
        i = colorPickerPopup.f23998h;
        colorPickerPopup.a(i);
        bVar = this.f24387a.k;
        if (bVar != null) {
            bVar2 = this.f24387a.k;
            i2 = this.f24387a.f23998h;
            bVar2.a(i2, false);
        }
        this.f24387a.a();
    }
}
