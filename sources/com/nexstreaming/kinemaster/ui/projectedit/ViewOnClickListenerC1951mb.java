package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import java.util.List;

/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.mb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1951mb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1978pb f22444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1951mb(C1978pb c1978pb) {
        this.f22444a = c1978pb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        NexLayerItem nexLayerItem2;
        NexLayerItem nexLayerItem3;
        NexLayerItem nexLayerItem4;
        NexLayerItem nexLayerItem5;
        int i;
        NexLayerItem nexLayerItem6;
        NexLayerItem nexLayerItem7;
        NexLayerItem nexLayerItem8;
        nexLayerItem = this.f22444a.l;
        if (nexLayerItem == null) {
            return;
        }
        nexLayerItem2 = this.f22444a.l;
        if (nexLayerItem2 == null) {
            return;
        }
        nexLayerItem3 = this.f22444a.l;
        if (nexLayerItem3.getKeyFrames() == null) {
            return;
        }
        nexLayerItem4 = this.f22444a.l;
        float scaledTime = nexLayerItem4.getScaledTime(this.f22444a.da().v());
        nexLayerItem5 = this.f22444a.l;
        List<NexLayerItem.b> keyFrames = nexLayerItem5.getKeyFrames();
        i = this.f22444a.r;
        C1978pb c1978pb = this.f22444a;
        nexLayerItem6 = c1978pb.l;
        float c2 = i / c1978pb.c(nexLayerItem6);
        int size = keyFrames.size();
        while (true) {
            size--;
            if (size <= -1) {
                return;
            }
            float f2 = keyFrames.get(size).f20230a;
            if (scaledTime - f2 >= c2 && scaledTime > f2) {
                C1978pb c1978pb2 = this.f22444a;
                nexLayerItem7 = c1978pb2.l;
                nexLayerItem8 = this.f22444a.l;
                c1978pb2.b(((int) (f2 * nexLayerItem7.getDuration())) + nexLayerItem8.getAbsStartTime(), false);
                C1978pb c1978pb3 = this.f22444a;
                c1978pb3.q(c1978pb3.da().v());
                return;
            }
        }
    }
}
