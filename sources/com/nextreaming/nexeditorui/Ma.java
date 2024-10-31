package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.util.u;
import com.nextreaming.nexeditorui.NexTimeline;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
public class Ma implements u.a<NexTimeline.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f24067a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexTimeline f24068b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(NexTimeline nexTimeline, Map map) {
        this.f24068b = nexTimeline;
        this.f24067a = map;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(NexTimeline.b bVar) {
        int cTSBeforeTimeChange = bVar.getCTSBeforeTimeChange();
        NexTimeline.a aVar = new NexTimeline.a(null);
        aVar.f24131d = this.f24068b.getFirstVideoClipAtTime(cTSBeforeTimeChange);
        NexVideoClipItem nexVideoClipItem = aVar.f24131d;
        if (nexVideoClipItem != null) {
            aVar.f24128a = cTSBeforeTimeChange - nexVideoClipItem.getAbsStartTime();
            this.f24067a.put(bVar, aVar);
        }
    }
}
