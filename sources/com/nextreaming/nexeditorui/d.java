package com.nextreaming.nexeditorui;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ColorPickerPopup colorPickerPopup, Context context) {
        super(context);
        this.f4589a = colorPickerPopup;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean g;
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        g = this.f4589a.g();
        return g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4589a.b = null;
        this.f4589a.a();
    }
}
