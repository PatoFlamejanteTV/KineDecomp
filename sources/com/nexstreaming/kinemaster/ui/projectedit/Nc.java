package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: OptionLayerShapeFragment.java */
/* loaded from: classes2.dex */
class Nc implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Oc f21971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nc(Oc oc) {
        this.f21971a = oc;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        if (this.f21971a.l != null) {
            this.f21971a.l.setCropMaskFeather(f2);
            VideoEditor da = this.f21971a.da();
            if (da != null) {
                da.c(this.f21971a.l);
                da.a(NexEditor.FastPreviewOption.normal, 0, true);
                da.J();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
