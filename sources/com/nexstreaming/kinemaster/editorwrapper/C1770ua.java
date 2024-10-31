package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.ua, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1770ua extends AbstractRunnableC1763qa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20366b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1770ua(NexLayerItem nexLayerItem) {
        this.f20366b = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.AbstractRunnableC1763qa
    protected void a(LayerRenderer layerRenderer) {
        NexLayerItem.b bVar;
        NexLayerItem nexLayerItem = this.f20366b;
        bVar = NexLayerItem.f20222g;
        nexLayerItem.onRender(layerRenderer, bVar, true);
    }
}
