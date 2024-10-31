package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;

/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
class ba implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.f3781a = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        nexLayerItem = this.f3781a.f3779a;
        if (nexLayerItem != null) {
            this.f3781a.e();
            this.f3781a.b(this.f3781a.o().u());
            this.f3781a.d();
        }
    }
}
