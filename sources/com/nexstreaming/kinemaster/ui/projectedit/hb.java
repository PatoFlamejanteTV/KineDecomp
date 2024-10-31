package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Hb implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Mb f21889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hb(Mb mb) {
        this.f21889a = mb;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        MarchingAnts marchingAnts4;
        Object obj2;
        if (this.f21889a.getActivity() == null || this.f21889a.getResources() == null || this.f21889a.getResources().getConfiguration().screenWidthDp < this.f21889a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        if (!this.f21889a.isAdded()) {
            this.f21889a.Q().removeOnLayoutChangeListener(this);
            VideoEditor.b q = this.f21889a.da().q();
            marchingAnts4 = this.f21889a.D;
            if (q == marchingAnts4) {
                VideoEditor da = this.f21889a.da();
                obj2 = this.f21889a.H;
                da.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
            }
            this.f21889a.D = null;
            return;
        }
        this.f21889a.Q().removeOnLayoutChangeListener(this);
        marchingAnts = this.f21889a.D;
        if (marchingAnts == null) {
            this.f21889a.D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        marchingAnts2 = this.f21889a.D;
        marchingAnts2.a(this.f21889a.Q().getMeasuredWidth(), this.f21889a.Q().getMeasuredHeight());
        VideoEditor da2 = this.f21889a.da();
        obj = this.f21889a.H;
        NexLayerItem nexLayerItem = (NexLayerItem) this.f21889a.Y();
        bVar = this.f21889a.E;
        marchingAnts3 = this.f21889a.D;
        da2.a(obj, nexLayerItem, bVar, marchingAnts3);
        this.f21889a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
