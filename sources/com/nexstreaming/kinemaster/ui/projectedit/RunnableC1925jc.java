package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionColorTintFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.jc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1925jc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorEffect f22402a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1934kc f22403b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1925jc(C1934kc c1934kc, ColorEffect colorEffect) {
        this.f22403b = c1934kc;
        this.f22402a = colorEffect;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexTimelineItem.g gVar;
        gVar = this.f22403b.f22413a.m;
        if (gVar != null) {
            this.f22402a.getPresetName();
            this.f22403b.f22413a.G();
        }
    }
}
