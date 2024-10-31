package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.util.u;
import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
class Na implements u.a<NexTimeline.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Oa f24072a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(Oa oa) {
        this.f24072a = oa;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(NexTimeline.b bVar) {
        NexTimeline.a aVar = (NexTimeline.a) this.f24072a.f24158b.get(bVar);
        if (aVar != null) {
            bVar.b(aVar.f24131d.getAbsStartTime() + aVar.f24128a);
        }
    }
}
