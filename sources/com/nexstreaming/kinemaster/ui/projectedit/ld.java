package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
public class ld implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kx f4057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ld(kx kxVar) {
        this.f4057a = kxVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        if (this.f4057a.getActivity() != null && this.f4057a.getResources() != null && this.f4057a.getResources().getConfiguration().screenWidthDp >= this.f4057a.getResources().getConfiguration().screenHeightDp) {
            if (!this.f4057a.isAdded()) {
                this.f4057a.w().removeOnLayoutChangeListener(this);
                this.f4057a.c = null;
                this.f4057a.o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
                return;
            }
            this.f4057a.w().removeOnLayoutChangeListener(this);
            marchingAnts = this.f4057a.c;
            if (marchingAnts == null) {
                this.f4057a.c = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            marchingAnts2 = this.f4057a.c;
            marchingAnts2.a(this.f4057a.w().getMeasuredWidth(), this.f4057a.w().getMeasuredHeight());
            VideoEditor o = this.f4057a.o();
            NexLayerItem nexLayerItem = (NexLayerItem) this.f4057a.m();
            bVar = this.f4057a.i;
            marchingAnts3 = this.f4057a.c;
            o.a(nexLayerItem, bVar, marchingAnts3);
            this.f4057a.f4048a = null;
            this.f4057a.o().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
