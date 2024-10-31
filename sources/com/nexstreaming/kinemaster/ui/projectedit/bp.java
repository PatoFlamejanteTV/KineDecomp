package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
class bp extends com.nexstreaming.kinemaster.ui.layereditrender.e {

    /* renamed from: a */
    final /* synthetic */ bo f3797a;

    public bp(bo boVar) {
        this.f3797a = boVar;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        nexLayerItem.renderLayer(layerRenderer, false);
    }
}
