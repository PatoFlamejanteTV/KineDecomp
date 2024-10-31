package com.nexstreaming.kinemaster.ui.projectedit;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionColorTintFragment.java */
/* loaded from: classes.dex */
class df implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorEffect f3840a;
    final /* synthetic */ de b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar, ColorEffect colorEffect) {
        this.b = deVar;
        this.f3840a = colorEffect;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexTimelineItem.f fVar;
        fVar = this.b.f3839a.b;
        if (fVar != null) {
            String presetName = this.f3840a.getPresetName();
            if (presetName == null) {
                presetName = FacebookRequestErrorClassification.KEY_OTHER;
            }
            this.b.f3839a.d();
            KMUsage.EditScreen_ColorTint.logEvent("effect", presetName);
        }
    }
}
