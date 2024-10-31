package com.google.firebase.appinvite;

import android.os.Bundle;
import com.google.android.gms.internal.firebase_dynamic_links.zzt;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* loaded from: classes2.dex */
public abstract class FirebaseAppInvite {
    public static FirebaseAppInvite getInvitation(PendingDynamicLinkData pendingDynamicLinkData) {
        Bundle b2 = pendingDynamicLinkData.b();
        if (b2 == null || b2.getString("com.google.firebase.appinvite.fdl.extension.InvitationId", null) == null) {
            return null;
        }
        return new zzt(b2);
    }

    public abstract String getInvitationId();
}
