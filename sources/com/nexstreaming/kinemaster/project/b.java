package com.nexstreaming.kinemaster.project;

import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ItemFilterPredicate.kt */
/* loaded from: classes.dex */
public final class b implements f {
    @Override // com.nexstreaming.kinemaster.project.f
    public boolean a(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        return nexTimelineItem instanceof NexAudioClipItem;
    }
}
