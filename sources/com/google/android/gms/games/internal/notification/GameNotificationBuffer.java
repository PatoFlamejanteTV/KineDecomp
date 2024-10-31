package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameNotification a(int i) {
        return new GameNotificationRef(this.f982a, i);
    }
}
