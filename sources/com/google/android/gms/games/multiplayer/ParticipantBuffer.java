package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class ParticipantBuffer extends AbstractDataBuffer<Participant> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Participant a(int i) {
        return new ParticipantRef(this.f982a, i);
    }
}
