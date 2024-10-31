package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzh {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f10607a = new Logger("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f10607a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        f10607a.a("getFallbackSignInIntent()", new Object[0]);
        Intent a2 = a(context, googleSignInOptions);
        a2.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return a2;
    }

    public static Intent c(Context context, GoogleSignInOptions googleSignInOptions) {
        f10607a.a("getNoImplementationSignInIntent()", new Object[0]);
        Intent a2 = a(context, googleSignInOptions);
        a2.setAction("com.google.android.gms.auth.NO_IMPL");
        return a2;
    }

    public static PendingResult<Status> b(GoogleApiClient googleApiClient, Context context, boolean z) {
        f10607a.a("Revoking access", new Object[0]);
        String d2 = Storage.a(context).d();
        a(context);
        if (z) {
            return zzd.a(d2);
        }
        return googleApiClient.b((GoogleApiClient) new c(googleApiClient));
    }

    public static PendingResult<Status> a(GoogleApiClient googleApiClient, Context context, boolean z) {
        f10607a.a("Signing out", new Object[0]);
        a(context);
        if (z) {
            return PendingResults.a(Status.f10704a, googleApiClient);
        }
        return googleApiClient.b((GoogleApiClient) new a(googleApiClient));
    }

    private static void a(Context context) {
        zzp.a(context).a();
        Iterator<GoogleApiClient> it = GoogleApiClient.e().iterator();
        while (it.hasNext()) {
            it.next().h();
        }
        GoogleApiManager.b();
    }

    public static GoogleSignInResult a(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount")) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.f10704a;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }
}
