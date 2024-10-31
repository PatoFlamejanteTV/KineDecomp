package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.nb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnLayoutChangeListenerC1960nb implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1978pb f22455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLayoutChangeListenerC1960nb(C1978pb c1978pb) {
        this.f22455a = c1978pb;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MarchingAnts marchingAnts;
        MarchingAnts marchingAnts2;
        Object obj;
        MarchingAnts marchingAnts3;
        Object obj2;
        if (this.f22455a.getResources().getConfiguration().screenWidthDp >= this.f22455a.getResources().getConfiguration().screenHeightDp && this.f22455a.Q().getMeasuredWidth() > 0 && this.f22455a.Q().getMeasuredHeight() > 0) {
            if (!this.f22455a.isAdded()) {
                this.f22455a.Q().removeOnLayoutChangeListener(this);
                this.f22455a.u = null;
                VideoEditor da = this.f22455a.da();
                obj2 = this.f22455a.s;
                da.a(obj2, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
                return;
            }
            this.f22455a.Q().removeOnLayoutChangeListener(this);
            marchingAnts = this.f22455a.u;
            if (marchingAnts == null) {
                this.f22455a.u = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            marchingAnts2 = this.f22455a.u;
            marchingAnts2.a(this.f22455a.Q().getMeasuredWidth(), this.f22455a.Q().getMeasuredHeight());
            VideoEditor da2 = this.f22455a.da();
            obj = this.f22455a.s;
            NexLayerItem nexLayerItem = (NexLayerItem) this.f22455a.Y();
            marchingAnts3 = this.f22455a.u;
            da2.a(obj, nexLayerItem, (VideoEditor.b) null, marchingAnts3);
        }
    }
}
