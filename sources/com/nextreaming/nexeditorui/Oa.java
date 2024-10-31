package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.util.u;
import com.nextreaming.nexeditorui.NexTimeline;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
public class Oa implements NexTimeline.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f24157a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f24158b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexTimeline f24159c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(NexTimeline nexTimeline, List list, Map map) {
        this.f24159c = nexTimeline;
        this.f24157a = list;
        this.f24158b = map;
    }

    @Override // com.nextreaming.nexeditorui.NexTimeline.c
    public void apply() {
        com.nexstreaming.app.general.util.u e2;
        this.f24159c.a((List<NexTimeline.a>) this.f24157a);
        e2 = this.f24159c.e();
        e2.a((u.a) new Na(this));
    }
}
