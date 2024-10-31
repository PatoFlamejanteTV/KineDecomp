package com.nexstreaming.kinemaster.editorwrapper;

import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* loaded from: classes.dex */
public class ao extends am {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f3316a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NexLayerItem nexLayerItem) {
        this.f3316a = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.am
    protected void a(LayerRenderer layerRenderer) {
        am amVar;
        int i;
        float f;
        float a2;
        amVar = this.f3316a.renderOverall;
        i = this.f3316a.layerOverallExpression;
        int j = layerRenderer.j() - this.f3316a.getAbsStartTime();
        int duration = this.f3316a.getDuration();
        f = this.f3316a.layerOverallExpressionSpeed;
        a2 = this.f3316a.a();
        amVar.a(layerRenderer, i, 0.0f, 0.0f, j, duration, (int) (f * 100.0f), a2, 0.0f);
    }
}
