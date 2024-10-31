package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.RectF;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: LayerRenderRunnable.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.qa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1763qa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private LayerRenderer f20348a;

    protected abstract void a(LayerRenderer layerRenderer);

    public void a(LayerRenderer layerRenderer, int i, float f2, float f3, int i2, int i3, int i4, RectF rectF, int i5) {
        LayerExpression fromId = LayerExpression.fromId(i);
        this.f20348a = layerRenderer;
        fromId.render(layerRenderer, f2, f3, i2, i3, i4, this, rectF, i5, false);
        this.f20348a = null;
    }

    public void b(LayerRenderer layerRenderer, int i, float f2, float f3, int i2, int i3, int i4, RectF rectF, int i5) {
        LayerExpression fromId = LayerExpression.fromId(i);
        this.f20348a = layerRenderer;
        fromId.render(layerRenderer, f2, f3, i2, i3, i4, this, rectF, i5, true);
        this.f20348a = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LayerRenderer layerRenderer = this.f20348a;
        if (layerRenderer == null) {
            return;
        }
        a(layerRenderer);
    }
}
