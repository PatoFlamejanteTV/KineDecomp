package com.google.android.gms.internal.firebase_dynamic_links;

import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class zzo implements AppInviteInvitationResult {
    private final Status zzr;
    private final Intent zzs;

    public zzo(Status status, Intent intent) {
        this.zzr = status;
        this.zzs = intent;
    }

    public final Intent getInvitationIntent() {
        return this.zzs;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzr;
    }
}
