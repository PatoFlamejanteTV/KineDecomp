package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class BackButtonHandler {

    /* renamed from: a */
    private ViewGroup f17692a;

    /* renamed from: b */
    private View.OnClickListener f17693b;

    public BackButtonHandler(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f17692a = viewGroup;
        this.f17693b = onClickListener;
    }

    public Boolean a(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        View.OnClickListener onClickListener = this.f17693b;
        if (onClickListener != null) {
            onClickListener.onClick(this.f17692a);
            return true;
        }
        return false;
    }
}
