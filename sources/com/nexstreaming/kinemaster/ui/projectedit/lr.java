package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: TextEditFragment.java */
/* loaded from: classes.dex */
class lr implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ lo f4072a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lr(lo loVar) {
        this.f4072a = loVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        if (this.f4072a.getActivity() != null && this.f4072a.getResources() != null && this.f4072a.getResources().getConfiguration().screenWidthDp >= this.f4072a.getResources().getConfiguration().screenHeightDp && this.f4072a.w().getMeasuredWidth() > 0 && this.f4072a.w().getMeasuredHeight() > 0) {
            if (this.f4072a.isAdded()) {
                z = this.f4072a.o;
                if (z) {
                    this.f4072a.w().removeOnLayoutChangeListener(this);
                    marchingAnts = this.f4072a.m;
                    if (marchingAnts == null) {
                        this.f4072a.m = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
                    }
                    marchingAnts2 = this.f4072a.m;
                    marchingAnts2.a(this.f4072a.w().getMeasuredWidth(), this.f4072a.w().getMeasuredHeight());
                    VideoEditor o = this.f4072a.o();
                    NexLayerItem nexLayerItem = (NexLayerItem) this.f4072a.m();
                    bVar = this.f4072a.n;
                    marchingAnts3 = this.f4072a.m;
                    o.a(nexLayerItem, bVar, marchingAnts3);
                    this.f4072a.o().a(NexEditor.FastPreviewOption.normal, 0, true);
                    return;
                }
                return;
            }
            this.f4072a.w().removeOnLayoutChangeListener(this);
            this.f4072a.m = null;
            this.f4072a.o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        }
    }
}
