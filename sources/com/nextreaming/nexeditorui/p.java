package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4752a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ColorPickerPopup colorPickerPopup) {
        this.f4752a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4752a.b(ColorPickerPopup.ColorTab.Sliders);
        this.f4752a.a(ColorPickerPopup.ColorTab.Sliders);
    }
}
