package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ColorAdjustmentFragment.java */
/* loaded from: classes.dex */
class n implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f4108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f4108a = mVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        boolean c;
        NexTimelineItem.e eVar;
        boolean e;
        NexTimelineItem.f fVar;
        NexTimelineItem.f fVar2;
        c = this.f4108a.c();
        if (c) {
            eVar = this.f4108a.f4081a;
            eVar.setBrightness((int) f);
            e = this.f4108a.e();
            if (!e) {
                VideoEditor o = this.f4108a.o();
                NexEditor.FastPreviewOption fastPreviewOption = NexEditor.FastPreviewOption.brightness;
                fVar2 = this.f4108a.b;
                o.a(fastPreviewOption, fVar2.getCombinedBrightness(), true);
                return;
            }
            VideoEditor o2 = this.f4108a.o();
            NexEditor.FastPreviewOption fastPreviewOption2 = NexEditor.FastPreviewOption.normal;
            fVar = this.f4108a.b;
            o2.a(fastPreviewOption2, fVar.getCombinedBrightness(), true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f4108a.q();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        boolean c;
        NexTimelineItem.e eVar;
        c = this.f4108a.c();
        if (c) {
            this.f4108a.d();
            KMUsage kMUsage = KMUsage.EditScreen_ColorAdj_Brightness;
            eVar = this.f4108a.f4081a;
            kMUsage.logEvent("value", KMUsage.bucketParamPlusMinus100(eVar.getBrightness()));
        }
    }
}
