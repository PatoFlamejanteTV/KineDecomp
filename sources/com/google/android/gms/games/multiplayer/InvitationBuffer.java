package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.zzf;

/* loaded from: classes.dex */
public final class InvitationBuffer extends zzf<Invitation> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Invitation a(int i, int i2) {
        return new InvitationRef(this.f982a, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "external_invitation_id";
    }
}
