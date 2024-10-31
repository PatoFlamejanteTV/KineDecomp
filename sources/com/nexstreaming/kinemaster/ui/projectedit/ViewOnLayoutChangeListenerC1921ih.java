package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: TextEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ih, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnLayoutChangeListenerC1921ih implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1939kh f22397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLayoutChangeListenerC1921ih(C1939kh c1939kh) {
        this.f22397a = c1939kh;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        VideoEditor.b bVar;
        MarchingAnts marchingAnts3;
        Object obj2;
        if (this.f22397a.getActivity() == null || this.f22397a.getResources() == null || this.f22397a.getResources().getConfiguration().screenWidthDp < this.f22397a.getResources().getConfiguration().screenHeightDp || this.f22397a.Q().getMeasuredWidth() <= 0 || this.f22397a.Q().getMeasuredHeight() <= 0) {
            return;
        }
        if (this.f22397a.isAdded()) {
            z = this.f22397a.T;
            if (z) {
                this.f22397a.Q().removeOnLayoutChangeListener(this);
                marchingAnts = this.f22397a.R;
                if (marchingAnts == null) {
                    this.f22397a.R = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
                }
                marchingAnts2 = this.f22397a.R;
                marchingAnts2.a(this.f22397a.Q().getMeasuredWidth(), this.f22397a.Q().getMeasuredHeight());
                VideoEditor da = this.f22397a.da();
                obj = this.f22397a.P;
                NexLayerItem nexLayerItem = (NexLayerItem) this.f22397a.Y();
                bVar = this.f22397a.S;
                marchingAnts3 = this.f22397a.R;
                da.a(obj, nexLayerItem, bVar, marchingAnts3);
                this.f22397a.da().a(NexEditor.FastPreviewOption.normal, 0, true);
                return;
            }
            return;
        }
        this.f22397a.Q().removeOnLayoutChangeListener(this);
        this.f22397a.R = null;
        VideoEditor da2 = this.f22397a.da();
        obj2 = this.f22397a.P;
        da2.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
    }
}
