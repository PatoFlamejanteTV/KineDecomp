package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class MilestoneBuffer extends AbstractDataBuffer<Milestone> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Milestone a(int i) {
        return new MilestoneRef(this.f982a, i);
    }
}