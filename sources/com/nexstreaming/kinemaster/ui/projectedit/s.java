package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: EffectLayerEditFragment.java */
/* loaded from: classes.dex */
public class s extends com.nexstreaming.kinemaster.ui.layereditrender.e {

    /* renamed from: a */
    final /* synthetic */ r f4114a;
    private NexLayerItem.b b = new NexLayerItem.b();

    public s(r rVar) {
        this.f4114a = rVar;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        nexLayerItem.renderLayer(layerRenderer, false);
    }
}
