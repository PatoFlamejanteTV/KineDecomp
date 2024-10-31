package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ColorAdjustmentFragment.java */
/* loaded from: classes.dex */
class o implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f4110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.f4110a = mVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        boolean c;
        NexTimelineItem.e eVar;
        boolean e;
        NexTimelineItem.f fVar;
        NexTimelineItem.f fVar2;
        c = this.f4110a.c();
        if (c) {
            eVar = this.f4110a.f4081a;
            eVar.setContrast((int) f);
            e = this.f4110a.e();
            if (!e) {
                VideoEditor o = this.f4110a.o();
                NexEditor.FastPreviewOption fastPreviewOption = NexEditor.FastPreviewOption.contrast;
                fVar2 = this.f4110a.b;
                o.a(fastPreviewOption, fVar2.getCombinedContrast(), true);
                return;
            }
            VideoEditor o2 = this.f4110a.o();
            NexEditor.FastPreviewOption fastPreviewOption2 = NexEditor.FastPreviewOption.normal;
            fVar = this.f4110a.b;
            o2.a(fastPreviewOption2, fVar.getCombinedContrast(), true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f4110a.q();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        boolean c;
        NexTimelineItem.e eVar;
        c = this.f4110a.c();
        if (c) {
            this.f4110a.d();
            if (this.f4110a.m() != null && (this.f4110a.m() instanceof NexLayerItem)) {
            }
            KMUsage kMUsage = KMUsage.EditScreen_ColorAdj_Contrast;
            eVar = this.f4110a.f4081a;
            kMUsage.logEvent("value", KMUsage.bucketParamPlusMinus100(eVar.getContrast()));
        }
    }
}
