package com.google.android.gms.internal.firebase_dynamic_links;

import android.app.Activity;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class zze implements AppInviteApi {
    public final PendingResult<Status> convertInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.a((GoogleApiClient) new e(this, googleApiClient, str));
    }

    public final PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient googleApiClient, Activity activity, boolean z) {
        return googleApiClient.a((GoogleApiClient) new g(this, googleApiClient, activity, z));
    }

    public final PendingResult<Status> updateInvitationOnInstall(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.a((GoogleApiClient) new c(this, googleApiClient, str));
    }
}
