package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: LayerEditManager.java */
/* loaded from: classes.dex */
class bh extends com.nexstreaming.kinemaster.ui.layereditrender.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bg f3788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.f3788a = bgVar;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        nexLayerItem.renderLayer(layerRenderer, false);
    }
}
