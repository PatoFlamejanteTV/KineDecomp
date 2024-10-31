package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/* compiled from: IgnoreStateSelectedCheckBox.kt */
/* loaded from: classes.dex */
public final class IgnoreStateSelectedCheckBox extends AppCompatCheckBox {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnoreStateSelectedCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(attributeSet, "attrs");
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
    }
}
