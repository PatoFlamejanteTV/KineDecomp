package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.util.m;
import com.nextreaming.nexeditorui.NexTimeline;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
public class cx implements NexTimeline.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f4586a;
    final /* synthetic */ Map b;
    final /* synthetic */ NexTimeline c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(NexTimeline nexTimeline, List list, Map map) {
        this.c = nexTimeline;
        this.f4586a = list;
        this.b = map;
    }

    @Override // com.nextreaming.nexeditorui.NexTimeline.c
    public void a() {
        com.nexstreaming.app.general.util.m a2;
        this.c.a((List<NexTimeline.a>) this.f4586a);
        a2 = this.c.a();
        a2.a((m.a) new cy(this));
    }
}
