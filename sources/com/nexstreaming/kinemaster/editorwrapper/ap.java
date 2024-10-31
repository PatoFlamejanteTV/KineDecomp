package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* loaded from: classes.dex */
public class ap extends am {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f3317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NexLayerItem nexLayerItem) {
        this.f3317a = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.am
    protected void a(LayerRenderer layerRenderer) {
        NexLayerItem.b bVar;
        NexLayerItem.b bVar2;
        NexLayerItem.b bVar3;
        NexLayerItem.b bVar4;
        layerRenderer.d(layerRenderer.r() * (this.f3317a.getAlpha() / 255.0f));
        bVar = NexLayerItem.f;
        layerRenderer.b(bVar.e, 0.0f, 0.0f);
        bVar2 = NexLayerItem.f;
        float f = bVar2.b;
        bVar3 = NexLayerItem.f;
        layerRenderer.a(f, bVar3.b, 0.0f, 0.0f);
        layerRenderer.b(this.f3317a.getFlipV() ? -1.0f : 1.0f, this.f3317a.getFlipH() ? -1.0f : 1.0f);
        layerRenderer.p();
        NexLayerItem nexLayerItem = this.f3317a;
        bVar4 = NexLayerItem.f;
        nexLayerItem.onRender(layerRenderer, bVar4);
        layerRenderer.q();
    }
}
