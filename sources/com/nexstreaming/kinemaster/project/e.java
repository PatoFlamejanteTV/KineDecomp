package com.nexstreaming.kinemaster.project;

import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ItemFilterPredicate.kt */
/* loaded from: classes.dex */
public final class e implements f {
    @Override // com.nexstreaming.kinemaster.project.f
    public boolean a(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        return nexTimelineItem instanceof VideoLayer;
    }
}
