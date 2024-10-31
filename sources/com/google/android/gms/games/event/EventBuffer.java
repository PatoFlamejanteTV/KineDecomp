package com.google.android.gms.games.event;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class EventBuffer extends AbstractDataBuffer<Event> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Event a(int i) {
        return new EventRef(this.f982a, i);
    }
}
