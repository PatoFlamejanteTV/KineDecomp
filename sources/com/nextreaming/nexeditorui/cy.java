package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.util.m;
import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
class cy implements m.a<NexTimeline.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cx f4587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar) {
        this.f4587a = cxVar;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(NexTimeline.b bVar) {
        NexTimeline.a aVar = (NexTimeline.a) this.f4587a.b.get(bVar);
        if (aVar != null) {
            bVar.d(aVar.f4493a + aVar.d.getAbsStartTime());
        }
    }
}
