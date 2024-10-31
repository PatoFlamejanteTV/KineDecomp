package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class ExperienceEventBuffer extends AbstractDataBuffer<ExperienceEvent> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ExperienceEvent a(int i) {
        return new ExperienceEventRef(this.f982a, i);
    }
}
