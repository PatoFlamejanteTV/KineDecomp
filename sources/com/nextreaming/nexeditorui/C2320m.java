package com.nextreaming.nexeditorui;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.ViewGroup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.m */
/* loaded from: classes.dex */
public class C2320m extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24314a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2320m(ColorPickerPopup colorPickerPopup, Context context, int i) {
        super(context, i);
        this.f24314a = colorPickerPopup;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.f24314a.f23994d;
        if (viewGroup != null) {
            viewGroup2 = this.f24314a.f23994d;
            viewGroup2.invalidate();
        }
    }
}
