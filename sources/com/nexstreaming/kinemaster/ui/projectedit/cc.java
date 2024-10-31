package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
public class Cc extends com.nexstreaming.kinemaster.ui.layereditrender.f {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Jc f21799d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cc(Jc jc) {
        this.f21799d = jc;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        long j;
        LayerExpression.Type sa = this.f21799d.sa();
        int min = Math.min(sa.hasDuration() ? nexLayerItem.getLayerExpressionDuration(sa) : nexLayerItem.getAbsEndTime() - nexLayerItem.getAbsStartTime(), nexLayerItem.getDuration() / 2);
        int i = sa == LayerExpression.Type.Overall ? min : min + 1000;
        long nanoTime = System.nanoTime();
        j = this.f21799d.q;
        int i2 = ((int) ((nanoTime - j) / 1000000)) % i;
        layerRenderer.x();
        int i3 = Ic.f21900a[sa.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                layerRenderer.b(nexLayerItem.getAbsStartTime() + i2);
            } else if (i2 < min) {
                layerRenderer.b((nexLayerItem.getAbsEndTime() - min) + i2);
            } else if (i2 < min + 500) {
                layerRenderer.b(nexLayerItem.getAbsEndTime());
            } else {
                layerRenderer.b(nexLayerItem.getAbsEndTime() - min);
            }
        } else if (i2 < min) {
            layerRenderer.b(nexLayerItem.getAbsStartTime() + i2);
        } else if (i2 < min + 500) {
            layerRenderer.b(nexLayerItem.getAbsStartTime() + min);
        } else {
            layerRenderer.b(nexLayerItem.getAbsStartTime());
        }
        nexLayerItem.renderLayer(layerRenderer, true);
        layerRenderer.w();
    }
}
