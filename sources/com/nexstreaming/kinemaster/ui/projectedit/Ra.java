package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
public class Ra implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(HandwritingEditFragment handwritingEditFragment) {
        this.f22045a = handwritingEditFragment;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        Object obj2;
        if (this.f22045a.getActivity() == null || this.f22045a.getResources() == null || this.f22045a.getResources().getConfiguration().screenWidthDp < this.f22045a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        if (!this.f22045a.isAdded()) {
            this.f22045a.Q().removeOnLayoutChangeListener(this);
            this.f22045a.ha = null;
            VideoEditor da = this.f22045a.da();
            obj2 = this.f22045a.ja;
            da.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
            return;
        }
        this.f22045a.Q().removeOnLayoutChangeListener(this);
        marchingAnts = this.f22045a.ha;
        if (marchingAnts == null) {
            this.f22045a.ha = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        marchingAnts2 = this.f22045a.ha;
        marchingAnts2.a(this.f22045a.Q().getMeasuredWidth(), this.f22045a.Q().getMeasuredHeight());
        VideoEditor da2 = this.f22045a.da();
        obj = this.f22045a.ja;
        NexLayerItem nexLayerItem = (NexLayerItem) this.f22045a.Y();
        bVar = this.f22045a.ia;
        marchingAnts3 = this.f22045a.ha;
        da2.a(obj, nexLayerItem, bVar, marchingAnts3);
        this.f22045a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
