package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ColorAdjustmentFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.da, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1870da implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1888fa f22307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1870da(C1888fa c1888fa) {
        this.f22307a = c1888fa;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        boolean va;
        NexTimelineItem.f fVar;
        boolean wa;
        NexTimelineItem.g gVar;
        NexTimelineItem.g gVar2;
        va = this.f22307a.va();
        if (va) {
            fVar = this.f22307a.l;
            fVar.setContrast((int) f2);
            wa = this.f22307a.wa();
            if (!wa) {
                VideoEditor da = this.f22307a.da();
                NexEditor.FastPreviewOption fastPreviewOption = NexEditor.FastPreviewOption.contrast;
                gVar2 = this.f22307a.m;
                da.a(fastPreviewOption, gVar2.getCombinedContrast(), true);
                return;
            }
            VideoEditor da2 = this.f22307a.da();
            NexEditor.FastPreviewOption fastPreviewOption2 = NexEditor.FastPreviewOption.normal;
            gVar = this.f22307a.m;
            da2.a(fastPreviewOption2, gVar.getCombinedContrast(), true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f22307a.L();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        boolean va;
        va = this.f22307a.va();
        if (va) {
            this.f22307a.G();
            if (this.f22307a.Y() == null || !(this.f22307a.Y() instanceof NexLayerItem)) {
                return;
            }
        }
    }
}
