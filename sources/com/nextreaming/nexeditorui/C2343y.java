package com.nextreaming.nexeditorui;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: EditorGlobalExtension.kt */
/* renamed from: com.nextreaming.nexeditorui.y */
/* loaded from: classes.dex */
public final class C2343y {
    public static final String a() {
        float l = EditorGlobal.l();
        return l == 0.5625f ? "9:16" : l == 1.0f ? "1:1" : "16:9";
    }

    public static final void a(ViewGroup viewGroup, boolean z) {
        kotlin.jvm.internal.h.b(viewGroup, "parentView");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            kotlin.jvm.internal.h.a((Object) childAt, "parentView.getChildAt(i)");
            childAt.setEnabled(z);
        }
    }
}
