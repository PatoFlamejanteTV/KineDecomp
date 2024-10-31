package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: OptionCropLayerFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.nc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1961nc implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1970oc f22456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1961nc(ViewOnClickListenerC1970oc viewOnClickListenerC1970oc) {
        this.f22456a = viewOnClickListenerC1970oc;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        if (this.f22456a.l != null) {
            this.f22456a.l.setCropMaskFeather(f2);
            VideoEditor da = this.f22456a.da();
            if (da != null) {
                da.c(this.f22456a.l);
                da.a(NexEditor.FastPreviewOption.normal, 0, true);
                da.J();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
