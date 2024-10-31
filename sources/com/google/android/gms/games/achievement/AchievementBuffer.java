package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class AchievementBuffer extends AbstractDataBuffer<Achievement> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Achievement a(int i) {
        return new AchievementRef(this.f982a, i);
    }
}
