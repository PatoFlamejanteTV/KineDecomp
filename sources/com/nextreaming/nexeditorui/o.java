package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ColorPickerPopup colorPickerPopup) {
        this.f4751a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4751a.b(ColorPickerPopup.ColorTab.Grid);
        this.f4751a.a(ColorPickerPopup.ColorTab.Grid);
    }
}
