package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.protos.datapol.SemanticAnnotations;

/* loaded from: classes2.dex */
public final class zzq {
    public static PendingIntent zzc(Context context, Auth.AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        Preconditions.a(context, "context must not be null");
        Preconditions.a(hintRequest, "request must not be null");
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", (String) null);
        SafeParcelableSerializer.a(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, putExtra, 134217728);
    }
}
