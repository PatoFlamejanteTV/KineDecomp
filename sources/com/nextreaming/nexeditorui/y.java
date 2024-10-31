package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.ColorPickerView;
import java.util.Comparator;

/* compiled from: ColorPickerView.java */
/* loaded from: classes.dex */
class y implements Comparator<ColorPickerView.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerView f4761a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ColorPickerView colorPickerView) {
        this.f4761a = colorPickerView;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ColorPickerView.b bVar, ColorPickerView.b bVar2) {
        if (bVar.f4469a == bVar2.f4469a) {
            return 0;
        }
        if (bVar.i == 0.0f && bVar2.i > 0.0f) {
            return -1;
        }
        if (bVar2.i == 0.0f && bVar.i > 0.0f) {
            return 1;
        }
        if (bVar2.i == 0.0f && bVar2.i == 0.0f) {
            if (bVar.d < bVar2.d) {
                return -1;
            }
            return bVar.d > bVar2.d ? 1 : 0;
        }
        if (bVar.h < bVar2.h) {
            return -1;
        }
        return bVar.h > bVar2.h ? 1 : 0;
    }
}