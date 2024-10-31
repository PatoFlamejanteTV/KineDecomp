package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: EffectLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.va, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2053va extends com.nexstreaming.kinemaster.ui.layereditrender.f {

    /* renamed from: d, reason: collision with root package name */
    private NexLayerItem.b f22736d = new NexLayerItem.b();

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Aa f22737e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2053va(Aa aa) {
        this.f22737e = aa;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        nexLayerItem.renderLayer(layerRenderer, false);
    }
}
