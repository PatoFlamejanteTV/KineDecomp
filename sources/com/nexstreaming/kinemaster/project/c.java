package com.nexstreaming.kinemaster.project;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ItemFilterPredicate.kt */
/* loaded from: classes.dex */
public final class c implements f {
    @Override // com.nexstreaming.kinemaster.project.f
    public boolean a(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        return nexTimelineItem instanceof NexLayerItem;
    }
}
