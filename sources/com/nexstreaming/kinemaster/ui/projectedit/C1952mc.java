package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: OptionCropLayerFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.mc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1952mc implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1970oc f22445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1952mc(ViewOnClickListenerC1970oc viewOnClickListenerC1970oc) {
        this.f22445a = viewOnClickListenerC1970oc;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f22445a.l != null) {
            this.f22445a.l.setUseCropMask(z);
            VideoEditor da = this.f22445a.da();
            if (da != null) {
                da.c(this.f22445a.l);
                da.a(NexEditor.FastPreviewOption.normal, 0, true);
                da.J();
            }
        }
        this.f22445a.ya();
    }
}
