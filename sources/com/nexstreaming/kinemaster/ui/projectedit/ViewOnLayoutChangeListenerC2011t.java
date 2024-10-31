package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: AssetLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnLayoutChangeListenerC2011t implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2052v f22533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLayoutChangeListenerC2011t(C2052v c2052v) {
        this.f22533a = c2052v;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        Object obj2;
        if (this.f22533a.getActivity() == null || this.f22533a.getResources() == null || this.f22533a.getResources().getConfiguration().screenWidthDp < this.f22533a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        if (!this.f22533a.isAdded()) {
            this.f22533a.Q().removeOnLayoutChangeListener(this);
            this.f22533a.F = null;
            VideoEditor da = this.f22533a.da();
            obj2 = this.f22533a.H;
            da.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
            return;
        }
        this.f22533a.Q().removeOnLayoutChangeListener(this);
        marchingAnts = this.f22533a.F;
        if (marchingAnts == null) {
            this.f22533a.F = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        marchingAnts2 = this.f22533a.F;
        marchingAnts2.a(this.f22533a.Q().getMeasuredWidth(), this.f22533a.Q().getMeasuredHeight());
        VideoEditor da2 = this.f22533a.da();
        obj = this.f22533a.H;
        NexLayerItem nexLayerItem = (NexLayerItem) this.f22533a.Y();
        bVar = this.f22533a.I;
        marchingAnts3 = this.f22533a.F;
        da2.a(obj, nexLayerItem, bVar, marchingAnts3);
        this.f22533a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
