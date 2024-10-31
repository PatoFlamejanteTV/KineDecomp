package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
class bb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3782a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.f3782a = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        float f;
        NexLayerItem nexLayerItem2;
        KMUsage.EditScreen_Animation_Action.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "RemoveKeyframe");
        nexLayerItem = this.f3782a.f3779a;
        f = this.f3782a.f;
        NexLayerItem.b closestKeyframe = nexLayerItem.getClosestKeyframe(f);
        nexLayerItem2 = this.f3782a.f3779a;
        nexLayerItem2.removeKeyframe(closestKeyframe);
        this.f3782a.b(this.f3782a.o().u());
        this.f3782a.d();
    }
}
