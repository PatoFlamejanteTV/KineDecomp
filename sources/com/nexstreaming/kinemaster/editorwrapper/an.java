package com.nexstreaming.kinemaster.editorwrapper;

import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* loaded from: classes.dex */
public class an extends am {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f3315a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NexLayerItem nexLayerItem) {
        this.f3315a = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.am
    protected void a(LayerRenderer layerRenderer) {
        am amVar;
        int i;
        int i2;
        float a2;
        amVar = this.f3315a.renderOut;
        i = this.f3315a.layerOutExpression;
        int j = layerRenderer.j() - this.f3315a.getAbsStartTime();
        int duration = this.f3315a.getDuration();
        i2 = this.f3315a.layerOutExpressionDuration;
        a2 = this.f3315a.a();
        amVar.a(layerRenderer, i, 0.0f, 0.0f, j, duration, i2, a2, 0.0f);
    }
}
