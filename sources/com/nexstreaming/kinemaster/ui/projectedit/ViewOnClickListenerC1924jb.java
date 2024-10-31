package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;

/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.jb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1924jb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1978pb f22401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1924jb(C1978pb c1978pb) {
        this.f22401a = c1978pb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        nexLayerItem = this.f22401a.l;
        if (nexLayerItem != null) {
            this.f22401a.wa();
            C1978pb c1978pb = this.f22401a;
            c1978pb.q(c1978pb.da().v());
            this.f22401a.G();
        }
    }
}
