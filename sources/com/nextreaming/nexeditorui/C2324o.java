package com.nextreaming.nexeditorui;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.o */
/* loaded from: classes.dex */
public class C2324o extends FrameLayout {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24382a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2324o(ColorPickerPopup colorPickerPopup, Context context) {
        super(context);
        this.f24382a = colorPickerPopup;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean h2;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            h2 = this.f24382a.h();
            return h2;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f24382a.f23994d = null;
        this.f24382a.a();
    }
}
