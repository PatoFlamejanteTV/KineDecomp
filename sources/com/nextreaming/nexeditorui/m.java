package com.nextreaming.nexeditorui;

import android.graphics.Color;
import android.view.View;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ColorPickerPopup colorPickerPopup) {
        this.f4655a = colorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ColorPickerPopup.b bVar;
        ColorPickerPopup.b bVar2;
        int i3;
        KMUsage kMUsage = KMUsage.ColorPicker_ApplyColor;
        i = this.f4655a.f;
        kMUsage.logEvent("alpha", KMUsage.bucketParam0to100((Color.alpha(i) * 100) / 255));
        ColorPickerPopup colorPickerPopup = this.f4655a;
        i2 = this.f4655a.f;
        colorPickerPopup.c(i2);
        bVar = this.f4655a.i;
        if (bVar != null) {
            bVar2 = this.f4655a.i;
            i3 = this.f4655a.f;
            bVar2.a(i3, false);
        }
        this.f4655a.a();
    }
}
