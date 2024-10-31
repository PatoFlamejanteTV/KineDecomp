package com.nextreaming.nexeditorui;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4650a;
    final /* synthetic */ ColorPickerPopup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ColorPickerPopup colorPickerPopup, int i) {
        this.b = colorPickerPopup;
        this.f4650a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int e;
        z = this.b.c;
        if (z) {
            ColorPickerPopup colorPickerPopup = this.b;
            e = this.b.e(this.f4650a);
            colorPickerPopup.f = e;
            this.b.a(true);
            this.b.i();
        }
    }
}
