package com.nextreaming.nexeditorui;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class l extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ColorPickerPopup colorPickerPopup, Context context, int i) {
        super(context, i);
        this.f4654a = colorPickerPopup;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.f4654a.b;
        if (viewGroup != null) {
            viewGroup2 = this.f4654a.b;
            viewGroup2.invalidate();
        }
    }
}
