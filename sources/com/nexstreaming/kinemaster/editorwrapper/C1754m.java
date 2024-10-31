package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.RectF;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerExpression.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1754m extends LayerExpression.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1754m() {
        super(null);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
    void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
        runnable.run();
    }
}
