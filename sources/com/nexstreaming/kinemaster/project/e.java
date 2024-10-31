package com.nexstreaming.kinemaster.project;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ItemFilterPredicate.java */
/* loaded from: classes.dex */
final class e implements a {
    @Override // com.nexstreaming.kinemaster.project.a
    public boolean a(NexTimelineItem nexTimelineItem) {
        return nexTimelineItem instanceof NexLayerItem;
    }
}
