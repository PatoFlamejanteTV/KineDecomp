package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Dialog;
import android.content.Context;

/* compiled from: LayerSubMenuPopup.kt */
/* loaded from: classes2.dex */
public abstract class LayerSubMenuPopup extends Dialog {

    /* compiled from: LayerSubMenuPopup.kt */
    /* loaded from: classes2.dex */
    public enum LayerType {
        IMAGE,
        STICKERS,
        TEXT,
        HANDWRITING,
        VIDEO,
        MEDIA,
        EFFECT
    }

    /* compiled from: LayerSubMenuPopup.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a(LayerSubMenuPopup layerSubMenuPopup, LayerType layerType);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerSubMenuPopup(Context context) {
        super(context);
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
    }

    public abstract void a();
}
