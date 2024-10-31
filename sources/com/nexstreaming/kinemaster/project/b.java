package com.nexstreaming.kinemaster.project;

import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ItemFilterPredicate.java */
/* loaded from: classes.dex */
final class b implements a {
    @Override // com.nexstreaming.kinemaster.project.a
    public boolean a(NexTimelineItem nexTimelineItem) {
        return nexTimelineItem instanceof NexAudioClipItem;
    }
}
