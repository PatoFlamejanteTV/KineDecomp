package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.List;

/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
class bc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar) {
        this.f3783a = azVar;
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
        int i2 = 0;
        nexLayerItem = this.f3783a.f3779a;
        if (nexLayerItem != null) {
            nexLayerItem2 = this.f3783a.f3779a;
            if (nexLayerItem2.getKeyFrames() != null) {
                KMUsage.EditScreen_Animation_Action.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "NextKeyframe");
                nexLayerItem3 = this.f3783a.f3779a;
                float scaledTime = nexLayerItem3.getScaledTime(this.f3783a.o().u());
                nexLayerItem4 = this.f3783a.f3779a;
                List<NexLayerItem.b> keyFrames = nexLayerItem4.getKeyFrames();
                i = this.f3783a.g;
                nexLayerItem5 = this.f3783a.f3779a;
                float clipWidth = i / nexLayerItem5.getClipWidth();
                while (true) {
                    int i3 = i2;
                    if (i3 < keyFrames.size()) {
                        float f = keyFrames.get(i3).f3299a;
                        if (f - scaledTime < clipWidth || scaledTime >= f) {
                            i2 = i3 + 1;
                        } else {
                            az azVar = this.f3783a;
                            nexLayerItem6 = this.f3783a.f3779a;
                            int duration = (int) (f * nexLayerItem6.getDuration());
                            nexLayerItem7 = this.f3783a.f3779a;
                            azVar.e(duration + nexLayerItem7.getAbsStartTime(), true);
                            this.f3783a.b(this.f3783a.o().u());
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
