package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class by implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bo f3806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bo boVar) {
        this.f3806a = boVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        if (this.f3806a.getActivity() != null && this.f3806a.getResources() != null && this.f3806a.getResources().getConfiguration().screenWidthDp >= this.f3806a.getResources().getConfiguration().screenHeightDp) {
            if (!this.f3806a.isAdded()) {
                this.f3806a.w().removeOnLayoutChangeListener(this);
                this.f3806a.b = null;
                this.f3806a.o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
                return;
            }
            this.f3806a.w().removeOnLayoutChangeListener(this);
            marchingAnts = this.f3806a.b;
            if (marchingAnts == null) {
                this.f3806a.b = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            marchingAnts2 = this.f3806a.b;
            marchingAnts2.a(this.f3806a.w().getMeasuredWidth(), this.f3806a.w().getMeasuredHeight());
            VideoEditor o = this.f3806a.o();
            NexLayerItem nexLayerItem = (NexLayerItem) this.f3806a.m();
            bVar = this.f3806a.c;
            marchingAnts3 = this.f3806a.b;
            o.a(nexLayerItem, bVar, marchingAnts3);
            this.f3806a.o().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
