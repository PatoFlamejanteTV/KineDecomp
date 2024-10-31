package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
class Ug implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xg f22148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ug(Xg xg) {
        this.f22148a = xg;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        Object obj2;
        if (this.f22148a.getActivity() == null || this.f22148a.getResources() == null || this.f22148a.getResources().getConfiguration().screenWidthDp < this.f22148a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        if (!this.f22148a.isAdded()) {
            this.f22148a.Q().removeOnLayoutChangeListener(this);
            this.f22148a.G = null;
            VideoEditor da = this.f22148a.da();
            obj2 = this.f22148a.M;
            da.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
            return;
        }
        this.f22148a.Q().removeOnLayoutChangeListener(this);
        marchingAnts = this.f22148a.G;
        if (marchingAnts == null) {
            this.f22148a.G = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        marchingAnts2 = this.f22148a.G;
        marchingAnts2.a(this.f22148a.Q().getMeasuredWidth(), this.f22148a.Q().getMeasuredHeight());
        VideoEditor da2 = this.f22148a.da();
        obj = this.f22148a.M;
        NexLayerItem nexLayerItem = (NexLayerItem) this.f22148a.Y();
        bVar = this.f22148a.N;
        marchingAnts3 = this.f22148a.G;
        da2.a(obj, nexLayerItem, bVar, marchingAnts3);
        this.f22148a.E = null;
        this.f22148a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
