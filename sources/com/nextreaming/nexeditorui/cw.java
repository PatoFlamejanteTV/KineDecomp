package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.util.m;
import com.nextreaming.nexeditorui.NexTimeline;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
public class cw implements m.a<NexTimeline.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f4585a;
    final /* synthetic */ NexTimeline b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(NexTimeline nexTimeline, Map map) {
        this.b = nexTimeline;
        this.f4585a = map;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(NexTimeline.b bVar) {
        int cTSBeforeTimeChange = bVar.getCTSBeforeTimeChange();
        NexTimeline.a aVar = new NexTimeline.a(null);
        aVar.d = this.b.getFirstVideoClipAtTime(cTSBeforeTimeChange);
        if (aVar.d != null) {
            aVar.f4493a = cTSBeforeTimeChange - aVar.d.getAbsStartTime();
            this.f4585a.put(bVar, aVar);
        }
    }
}
