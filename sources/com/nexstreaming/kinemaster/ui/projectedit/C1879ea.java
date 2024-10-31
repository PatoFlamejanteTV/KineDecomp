package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ColorAdjustmentFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1879ea implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1888fa f22322a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1879ea(C1888fa c1888fa) {
        this.f22322a = c1888fa;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        boolean va;
        NexTimelineItem.f fVar;
        boolean wa;
        NexTimelineItem.g gVar;
        NexTimelineItem.g gVar2;
        va = this.f22322a.va();
        if (va) {
            fVar = this.f22322a.l;
            fVar.setSaturation((int) f2);
            wa = this.f22322a.wa();
            if (!wa) {
                VideoEditor da = this.f22322a.da();
                NexEditor.FastPreviewOption fastPreviewOption = NexEditor.FastPreviewOption.saturation;
                gVar2 = this.f22322a.m;
                da.a(fastPreviewOption, gVar2.getCombinedSaturation(), true);
                return;
            }
            VideoEditor da2 = this.f22322a.da();
            NexEditor.FastPreviewOption fastPreviewOption2 = NexEditor.FastPreviewOption.normal;
            gVar = this.f22322a.m;
            da2.a(fastPreviewOption2, gVar.getCombinedSaturation(), true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f22322a.L();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        boolean va;
        va = this.f22322a.va();
        if (va) {
            this.f22322a.G();
        }
    }
}
