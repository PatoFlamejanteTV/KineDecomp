package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.ColorPickerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerView.java */
/* loaded from: classes.dex */
public class v implements ColorPickerPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerView f4758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ColorPickerView colorPickerView) {
        this.f4758a = colorPickerView;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.a
    public void a(int i) {
        ColorPickerView.b bVar;
        ColorPickerView.c cVar;
        ColorPickerView.c cVar2;
        ColorPickerView.b bVar2;
        bVar = this.f4758a.g;
        if (bVar.f4469a != i) {
            this.f4758a.g = new ColorPickerView.b(i);
            cVar = this.f4758a.h;
            if (cVar != null) {
                cVar2 = this.f4758a.h;
                ColorPickerView colorPickerView = this.f4758a;
                bVar2 = this.f4758a.g;
                cVar2.a(colorPickerView, bVar2.f4469a);
            }
            this.f4758a.invalidate();
        }
    }
}
