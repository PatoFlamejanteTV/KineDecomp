package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes.dex */
public final class GameSearchSuggestionBuffer extends AbstractDataBuffer<GameSearchSuggestion> {
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameSearchSuggestion a(int i) {
        return new GameSearchSuggestionRef(this.f982a, i);
    }
}
