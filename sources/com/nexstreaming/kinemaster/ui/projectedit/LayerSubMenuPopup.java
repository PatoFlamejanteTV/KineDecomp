package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Dialog;
import android.content.Context;

/* loaded from: classes.dex */
public abstract class LayerSubMenuPopup extends Dialog {

    /* loaded from: classes.dex */
    public enum LayerType {
        IMAGE,
        STICKERS,
        TEXT,
        HANDWRITING,
        VIDEO,
        MEDIA,
        EFFECT
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(LayerSubMenuPopup layerSubMenuPopup, LayerType layerType);
    }

    public abstract void a();

    public abstract void a(a aVar);

    public LayerSubMenuPopup(Context context) {
        super(context);
    }
}
