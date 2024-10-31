package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public final class zzw extends zzr {

    /* renamed from: a */
    private final Context f10612a;

    public zzw(Context context) {
        this.f10612a = context;
    }

    private final void v() {
        if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.f10612a, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzq
    public final void j() {
        v();
        Storage a2 = Storage.a(this.f10612a);
        GoogleSignInAccount b2 = a2.b();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f10565f;
        if (b2 != null) {
            googleSignInOptions = a2.c();
        }
        GoogleApiClient a3 = new GoogleApiClient.Builder(this.f10612a).a(Auth.f10423g, googleSignInOptions).a();
        try {
            if (a3.a().R()) {
                if (b2 != null) {
                    Auth.j.a(a3);
                } else {
                    a3.b();
                }
            }
        } finally {
            a3.d();
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzq
    public final void zzk() {
        v();
        zzp.a(this.f10612a).a();
    }
}
