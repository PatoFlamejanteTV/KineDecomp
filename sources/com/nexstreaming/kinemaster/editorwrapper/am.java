package com.nexstreaming.kinemaster.editorwrapper;

import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: LayerRenderRunnable.java */
/* loaded from: classes.dex */
public abstract class am implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private LayerRenderer f3314a;

    protected abstract void a(LayerRenderer layerRenderer);

    public void a(LayerRenderer layerRenderer, int i, float f, float f2, int i2, int i3, int i4, float f3, float f4) {
        LayerExpression fromId = LayerExpression.fromId(i);
        this.f3314a = layerRenderer;
        fromId.render(layerRenderer, f, f2, i2, i3, i4, this, f3, f4);
        this.f3314a = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3314a != null) {
            a(this.f3314a);
        }
    }
}
