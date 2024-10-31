package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: AssetLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2002s extends com.nexstreaming.kinemaster.ui.layereditrender.f {

    /* renamed from: d, reason: collision with root package name */
    private NexLayerItem.b f22516d = new NexLayerItem.b();

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C2052v f22517e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2002s(C2052v c2052v) {
        this.f22517e = c2052v;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        nexLayerItem.renderLayer(layerRenderer, false);
    }
}
