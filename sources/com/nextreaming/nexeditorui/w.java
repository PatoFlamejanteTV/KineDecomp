package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.ColorPickerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerView.java */
/* loaded from: classes.dex */
public class w implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerView f4759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ColorPickerView colorPickerView) {
        this.f4759a = colorPickerView;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        ColorPickerView.c cVar;
        ColorPickerView.c cVar2;
        if (!z) {
            cVar = this.f4759a.h;
            if (cVar != null) {
                cVar2 = this.f4759a.h;
                cVar2.a(this.f4759a);
            }
        }
    }
}
