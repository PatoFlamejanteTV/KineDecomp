package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;

/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1933kb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1978pb f22412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1933kb(C1978pb c1978pb) {
        this.f22412a = c1978pb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        float f2;
        NexLayerItem nexLayerItem2;
        nexLayerItem = this.f22412a.l;
        f2 = this.f22412a.q;
        NexLayerItem.b closestKeyframe = nexLayerItem.getClosestKeyframe(f2);
        nexLayerItem2 = this.f22412a.l;
        nexLayerItem2.removeKeyframe(closestKeyframe);
        C1978pb c1978pb = this.f22412a;
        c1978pb.q(c1978pb.da().v());
        this.f22412a.G();
    }
}
