package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: GroupEditFragment.java */
/* loaded from: classes2.dex */
class Na implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Pa f21968a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(Pa pa) {
        this.f21968a = pa;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        Object obj2;
        if (this.f21968a.getActivity() == null || this.f21968a.getResources() == null || this.f21968a.getResources().getConfiguration().screenWidthDp < this.f21968a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        if (!this.f21968a.isAdded()) {
            this.f21968a.Q().removeOnLayoutChangeListener(this);
            this.f21968a.D = null;
            VideoEditor da = this.f21968a.da();
            obj2 = this.f21968a.F;
            da.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
            return;
        }
        this.f21968a.Q().removeOnLayoutChangeListener(this);
        marchingAnts = this.f21968a.D;
        if (marchingAnts == null) {
            this.f21968a.D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        marchingAnts2 = this.f21968a.D;
        marchingAnts2.a(this.f21968a.Q().getMeasuredWidth(), this.f21968a.Q().getMeasuredHeight());
        VideoEditor da2 = this.f21968a.da();
        obj = this.f21968a.F;
        NexLayerItem nexLayerItem = (NexLayerItem) this.f21968a.Y();
        bVar = this.f21968a.G;
        marchingAnts3 = this.f21968a.D;
        da2.a(obj, nexLayerItem, bVar, marchingAnts3);
        this.f21968a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
