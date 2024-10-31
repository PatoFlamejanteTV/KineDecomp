package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.List;

/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
class bd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar) {
        this.f3784a = azVar;
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
        nexLayerItem = this.f3784a.f3779a;
        if (nexLayerItem != null) {
            nexLayerItem2 = this.f3784a.f3779a;
            if (nexLayerItem2 != null) {
                nexLayerItem3 = this.f3784a.f3779a;
                if (nexLayerItem3.getKeyFrames() != null) {
                    KMUsage.EditScreen_Animation_Action.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "PrevKeyframe");
                    nexLayerItem4 = this.f3784a.f3779a;
                    float scaledTime = nexLayerItem4.getScaledTime(this.f3784a.o().u());
                    nexLayerItem5 = this.f3784a.f3779a;
                    List<NexLayerItem.b> keyFrames = nexLayerItem5.getKeyFrames();
                    i = this.f3784a.g;
                    nexLayerItem6 = this.f3784a.f3779a;
                    float clipWidth = i / nexLayerItem6.getClipWidth();
                    int size = keyFrames.size() - 1;
                    while (true) {
                        int i2 = size;
                        if (i2 > -1) {
                            float f = keyFrames.get(i2).f3299a;
                            if (scaledTime - f < clipWidth || scaledTime <= f) {
                                size = i2 - 1;
                            } else {
                                az azVar = this.f3784a;
                                nexLayerItem7 = this.f3784a.f3779a;
                                int duration = (int) (f * nexLayerItem7.getDuration());
                                nexLayerItem8 = this.f3784a.f3779a;
                                azVar.e(duration + nexLayerItem8.getAbsStartTime(), true);
                                this.f3784a.b(this.f3784a.o().u());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
