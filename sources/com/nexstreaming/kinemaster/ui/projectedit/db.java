package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
class Db extends com.nexstreaming.kinemaster.ui.layereditrender.f {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Mb f21813d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Db(Mb mb) {
        this.f21813d = mb;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        nexLayerItem.renderLayer(layerRenderer, false);
    }
}
