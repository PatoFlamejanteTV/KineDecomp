package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.RectF;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.sa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1766sa extends AbstractRunnableC1763qa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20355b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1766sa(NexLayerItem nexLayerItem) {
        this.f20355b = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.AbstractRunnableC1763qa
    protected void a(LayerRenderer layerRenderer) {
        AbstractRunnableC1763qa abstractRunnableC1763qa;
        int i;
        float f2;
        RectF d2;
        int i2;
        abstractRunnableC1763qa = this.f20355b.renderOverall;
        i = this.f20355b.layerOverallExpression;
        int f3 = layerRenderer.f() - this.f20355b.getAbsStartTime();
        int duration = this.f20355b.getDuration();
        f2 = this.f20355b.layerOverallExpressionSpeed;
        d2 = this.f20355b.d();
        i2 = this.f20355b.mNaturalOrientation;
        abstractRunnableC1763qa.a(layerRenderer, i, 0.0f, 0.0f, f3, duration, (int) (f2 * 100.0f), d2, i2);
    }
}
