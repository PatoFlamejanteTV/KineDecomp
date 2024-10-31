package com.nexstreaming.kinemaster.ui.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;

/* compiled from: ShutterView.kt */
/* loaded from: classes2.dex */
public final class ShutterView extends View {

    /* renamed from: a */
    public static final a f23809a = new a(null);

    /* compiled from: ShutterView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(attributeSet, "attrs");
        setAlpha(0.0f);
        setVisibility(4);
    }

    public final void a(long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<ShutterView, Float>) View.ALPHA, 0.0f, 1.0f, 0.0f);
        kotlin.jvm.internal.h.a((Object) ofFloat, "this");
        ofFloat.setDuration(j);
        ofFloat.addListener(new q(this));
        ofFloat.start();
    }
}
