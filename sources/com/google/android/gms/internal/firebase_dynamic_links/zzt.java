package com.google.android.gms.internal.firebase_dynamic_links;

import android.os.Bundle;
import com.google.firebase.appinvite.FirebaseAppInvite;

/* loaded from: classes2.dex */
public final class zzt extends FirebaseAppInvite {
    private final Bundle zzt;

    public zzt(Bundle bundle) {
        this.zzt = bundle;
    }

    @Override // com.google.firebase.appinvite.FirebaseAppInvite
    public final String getInvitationId() {
        return this.zzt.getString("com.google.firebase.appinvite.fdl.extension.InvitationId", null);
    }
}
