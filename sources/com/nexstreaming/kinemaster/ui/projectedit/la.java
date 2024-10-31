package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.GroupLayer;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* compiled from: GroupEditFragment.java */
/* loaded from: classes2.dex */
class La extends com.nexstreaming.kinemaster.ui.layereditrender.f {

    /* renamed from: d, reason: collision with root package name */
    private NexLayerItem.b f21932d = new NexLayerItem.b();

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Pa f21933e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(Pa pa) {
        this.f21933e = pa;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        GroupLayer Ba;
        nexLayerItem.getWidth();
        nexLayerItem.getHeight();
        Ba = this.f21933e.Ba();
        layerRenderer.b(layerRenderer.f() - Ba.getStartTime());
        int f2 = layerRenderer.f();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : Ba.getChildList()) {
            if ((nexLayerItem instanceof NexLayerItem) && f2 >= nexLayerItem.getStartTime() && f2 < nexLayerItem.getEndTime()) {
                nexLayerItem.renderLayer(layerRenderer, false);
            }
        }
        layerRenderer.b(f2);
    }
}
