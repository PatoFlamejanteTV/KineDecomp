package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.RectF;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.ta, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1768ta extends AbstractRunnableC1763qa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20364b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1768ta(NexLayerItem nexLayerItem) {
        this.f20364b = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.AbstractRunnableC1763qa
    protected void a(LayerRenderer layerRenderer) {
        AbstractRunnableC1763qa abstractRunnableC1763qa;
        int i;
        int i2;
        RectF rectF;
        int i3;
        abstractRunnableC1763qa = this.f20364b.renderOutPostCrop;
        i = this.f20364b.layerOutExpression;
        int f2 = layerRenderer.f() - this.f20364b.getAbsStartTime();
        int duration = this.f20364b.getDuration();
        i2 = this.f20364b.layerOutExpressionDuration;
        rectF = this.f20364b.l;
        i3 = this.f20364b.mNaturalOrientation;
        abstractRunnableC1763qa.b(layerRenderer, i, 0.0f, 0.0f, f2, duration, i2, rectF, i3);
    }
}
