package com.google.android.gms.games.request;

import com.google.android.gms.common.data.zzf;

/* loaded from: classes.dex */
public final class GameRequestBuffer extends zzf<GameRequest> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameRequest a(int i, int i2) {
        return new GameRequestRef(this.f982a, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "external_request_id";
    }
}
