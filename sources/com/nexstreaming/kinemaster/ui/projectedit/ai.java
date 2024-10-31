package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
public class ai implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(HandwritingEditFragment handwritingEditFragment) {
        this.f3762a = handwritingEditFragment;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        if (this.f3762a.getActivity() != null && this.f3762a.getResources() != null && this.f3762a.getResources().getConfiguration().screenWidthDp >= this.f3762a.getResources().getConfiguration().screenHeightDp) {
            if (!this.f3762a.isAdded()) {
                this.f3762a.w().removeOnLayoutChangeListener(this);
                this.f3762a.D = null;
                this.f3762a.o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
                return;
            }
            this.f3762a.w().removeOnLayoutChangeListener(this);
            marchingAnts = this.f3762a.D;
            if (marchingAnts == null) {
                this.f3762a.D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            marchingAnts2 = this.f3762a.D;
            marchingAnts2.a(this.f3762a.w().getMeasuredWidth(), this.f3762a.w().getMeasuredHeight());
            VideoEditor o = this.f3762a.o();
            NexLayerItem nexLayerItem = (NexLayerItem) this.f3762a.m();
            bVar = this.f3762a.E;
            marchingAnts3 = this.f3762a.D;
            o.a(nexLayerItem, bVar, marchingAnts3);
            this.f3762a.o().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
