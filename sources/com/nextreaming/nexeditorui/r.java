package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24392a;

    public r(ColorPickerPopup colorPickerPopup) {
        this.f24392a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f24392a.b(ColorPickerPopup.ColorTab.Grid);
        this.f24392a.a(ColorPickerPopup.ColorTab.Grid);
    }
}
