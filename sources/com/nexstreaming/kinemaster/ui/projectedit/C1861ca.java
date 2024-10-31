package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ColorAdjustmentFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ca, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1861ca implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1888fa f22296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1861ca(C1888fa c1888fa) {
        this.f22296a = c1888fa;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        boolean va;
        NexTimelineItem.f fVar;
        boolean wa;
        NexTimelineItem.g gVar;
        NexTimelineItem.g gVar2;
        va = this.f22296a.va();
        if (va) {
            fVar = this.f22296a.l;
            fVar.setBrightness((int) f2);
            wa = this.f22296a.wa();
            if (!wa) {
                VideoEditor da = this.f22296a.da();
                NexEditor.FastPreviewOption fastPreviewOption = NexEditor.FastPreviewOption.brightness;
                gVar2 = this.f22296a.m;
                da.a(fastPreviewOption, gVar2.getCombinedBrightness(), true);
                return;
            }
            VideoEditor da2 = this.f22296a.da();
            NexEditor.FastPreviewOption fastPreviewOption2 = NexEditor.FastPreviewOption.normal;
            gVar = this.f22296a.m;
            da2.a(fastPreviewOption2, gVar.getCombinedBrightness(), true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f22296a.L();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        boolean va;
        va = this.f22296a.va();
        if (va) {
            this.f22296a.G();
        }
    }
}
