package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
public class be implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.f3785a = azVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        MarchingAnts marchingAnts3;
        if (this.f3785a.getResources().getConfiguration().screenWidthDp >= this.f3785a.getResources().getConfiguration().screenHeightDp && this.f3785a.w().getMeasuredWidth() > 0 && this.f3785a.w().getMeasuredHeight() > 0) {
            if (!this.f3785a.isAdded()) {
                this.f3785a.w().removeOnLayoutChangeListener(this);
                this.f3785a.i = null;
                this.f3785a.o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
                return;
            }
            this.f3785a.w().removeOnLayoutChangeListener(this);
            marchingAnts = this.f3785a.i;
            if (marchingAnts == null) {
                this.f3785a.i = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            marchingAnts2 = this.f3785a.i;
            marchingAnts2.a(this.f3785a.w().getMeasuredWidth(), this.f3785a.w().getMeasuredHeight());
            VideoEditor o = this.f3785a.o();
            NexLayerItem nexLayerItem = (NexLayerItem) this.f3785a.m();
            marchingAnts3 = this.f3785a.i;
            o.a(nexLayerItem, (VideoEditor.b) null, marchingAnts3);
        }
    }
}
