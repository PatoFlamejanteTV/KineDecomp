package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public abstract class BindingWrapper {

    /* renamed from: a */
    protected final InAppMessage f17583a;

    /* renamed from: b */
    final InAppMessageLayoutConfig f17584b;

    /* renamed from: c */
    final LayoutInflater f17585c;

    public BindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        this.f17584b = inAppMessageLayoutConfig;
        this.f17585c = layoutInflater;
        this.f17583a = inAppMessage;
    }

    public abstract ViewTreeObserver.OnGlobalLayoutListener a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2);

    public void a(View view, String str) {
        if (view == null || str == null) {
            return;
        }
        try {
            ((GradientDrawable) view.getBackground()).setColor(Color.parseColor(str));
        } catch (IllegalArgumentException e2) {
            Logging.c("Error parsing background color: " + e2.toString());
        }
    }

    public boolean a() {
        return false;
    }

    public InAppMessageLayoutConfig b() {
        return this.f17584b;
    }

    public abstract View c();

    public View.OnClickListener d() {
        return null;
    }

    public abstract ImageView e();

    public abstract ViewGroup f();
}
