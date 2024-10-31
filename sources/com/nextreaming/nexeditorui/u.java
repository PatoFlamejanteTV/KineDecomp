package com.nextreaming.nexeditorui;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerView.java */
/* loaded from: classes.dex */
public class u extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerView f4757a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ColorPickerView colorPickerView) {
        this.f4757a = colorPickerView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 1:
                z = this.f4757a.n;
                if (!z) {
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
