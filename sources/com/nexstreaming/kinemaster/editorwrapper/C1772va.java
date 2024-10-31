package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.Rect;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.va, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1772va extends AbstractRunnableC1763qa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20368b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1772va(NexLayerItem nexLayerItem) {
        this.f20368b = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.AbstractRunnableC1763qa
    protected void a(LayerRenderer layerRenderer) {
        NexLayerItem.b bVar;
        int i;
        NexLayerItem.b bVar2;
        NexLayerItem.b bVar3;
        NexLayerItem.b bVar4;
        NexLayerItem.b bVar5;
        NexLayerItem.b bVar6;
        Rect rect;
        RectF rectF;
        Rect rect2;
        RectF rectF2;
        Rect rect3;
        AbstractRunnableC1763qa abstractRunnableC1763qa;
        int i2;
        int i3;
        RectF rectF3;
        int i4;
        layerRenderer.a(layerRenderer.d() * (this.f20368b.getAlpha() / 255.0f));
        layerRenderer.x();
        bVar = NexLayerItem.f20222g;
        float f2 = bVar.f20234e;
        i = this.f20368b.mNaturalOrientation;
        layerRenderer.a(f2 + i, 0.0f, 0.0f);
        bVar2 = NexLayerItem.f20222g;
        float f3 = bVar2.f20236g;
        bVar3 = NexLayerItem.f20222g;
        layerRenderer.b(f3, bVar3.f20237h, 0.0f, 0.0f);
        layerRenderer.a(this.f20368b.getFlipH() ? -1.0f : 1.0f, this.f20368b.getFlipV() ? -1.0f : 1.0f);
        layerRenderer.y();
        this.f20368b.a(layerRenderer);
        boolean i5 = layerRenderer.i();
        layerRenderer.w();
        layerRenderer.d(i5);
        bVar4 = NexLayerItem.f20222g;
        layerRenderer.a(bVar4.f20234e, 0.0f, 0.0f);
        bVar5 = NexLayerItem.f20222g;
        float f4 = bVar5.f20236g;
        bVar6 = NexLayerItem.f20222g;
        layerRenderer.b(f4, bVar6.f20237h, 0.0f, 0.0f);
        layerRenderer.a(this.f20368b.getFlipH() ? -1.0f : 1.0f, this.f20368b.getFlipV() ? -1.0f : 1.0f);
        layerRenderer.y();
        rect = this.f20368b.k;
        if (rect == null) {
            this.f20368b.k = new Rect();
        }
        rectF = this.f20368b.l;
        if (rectF == null) {
            this.f20368b.l = new RectF();
        }
        NexLayerItem nexLayerItem = this.f20368b;
        rect2 = nexLayerItem.k;
        nexLayerItem.getExtendedBounds(rect2);
        rectF2 = this.f20368b.l;
        rect3 = this.f20368b.k;
        rectF2.set(rect3);
        abstractRunnableC1763qa = this.f20368b.renderInPostCrop;
        i2 = this.f20368b.layerInExpression;
        int f5 = layerRenderer.f() - this.f20368b.getAbsStartTime();
        int duration = this.f20368b.getDuration();
        i3 = this.f20368b.layerInExpressionDuration;
        rectF3 = this.f20368b.l;
        i4 = this.f20368b.mNaturalOrientation;
        abstractRunnableC1763qa.b(layerRenderer, i2, 0.0f, 0.0f, f5, duration, i3, rectF3, i4);
        layerRenderer.s();
    }
}
