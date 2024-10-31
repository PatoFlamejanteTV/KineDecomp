package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import java.util.List;

/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.lb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1942lb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1978pb f22433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1942lb(C1978pb c1978pb) {
        this.f22433a = c1978pb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        NexLayerItem nexLayerItem2;
        NexLayerItem nexLayerItem3;
        NexLayerItem nexLayerItem4;
        int i;
        NexLayerItem nexLayerItem5;
        NexLayerItem nexLayerItem6;
        NexLayerItem nexLayerItem7;
        nexLayerItem = this.f22433a.l;
        if (nexLayerItem != null) {
            nexLayerItem2 = this.f22433a.l;
            if (nexLayerItem2.getKeyFrames() != null) {
                nexLayerItem3 = this.f22433a.l;
                float scaledTime = nexLayerItem3.getScaledTime(this.f22433a.da().v());
                nexLayerItem4 = this.f22433a.l;
                List<NexLayerItem.b> keyFrames = nexLayerItem4.getKeyFrames();
                i = this.f22433a.r;
                C1978pb c1978pb = this.f22433a;
                nexLayerItem5 = c1978pb.l;
                float c2 = i / c1978pb.c(nexLayerItem5);
                for (int i2 = 0; i2 < keyFrames.size(); i2++) {
                    float f2 = keyFrames.get(i2).f20230a;
                    if (f2 - scaledTime >= c2 && scaledTime < f2) {
                        C1978pb c1978pb2 = this.f22433a;
                        nexLayerItem6 = c1978pb2.l;
                        nexLayerItem7 = this.f22433a.l;
                        c1978pb2.b(((int) (f2 * nexLayerItem6.getDuration())) + nexLayerItem7.getAbsStartTime(), false);
                        C1978pb c1978pb3 = this.f22433a;
                        c1978pb3.q(c1978pb3.da().v());
                        return;
                    }
                }
            }
        }
    }
}
