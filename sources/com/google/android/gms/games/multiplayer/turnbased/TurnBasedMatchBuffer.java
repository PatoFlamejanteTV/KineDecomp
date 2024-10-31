package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.zzf;

/* loaded from: classes.dex */
public final class TurnBasedMatchBuffer extends zzf<TurnBasedMatch> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatch a(int i, int i2) {
        return new TurnBasedMatchRef(this.f982a, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "external_match_id";
    }
}
