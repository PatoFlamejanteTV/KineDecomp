package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* renamed from: a */
    private static final a f10553a = new a(null);

    /* renamed from: b */
    @VisibleForTesting
    private static int f10554b = b.f10555a;

    /* loaded from: classes.dex */
    private static class a implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private a() {
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        public final /* synthetic */ GoogleSignInAccount a(GoogleSignInResult googleSignInResult) {
            return googleSignInResult.a();
        }

        /* synthetic */ a(c cVar) {
            this();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public enum b {

        /* renamed from: a */
        public static final int f10555a = 1;

        /* renamed from: b */
        public static final int f10556b = 2;

        /* renamed from: c */
        public static final int f10557c = 3;

        /* renamed from: d */
        public static final int f10558d = 4;

        /* renamed from: e */
        private static final /* synthetic */ int[] f10559e = {f10555a, f10556b, f10557c, f10558d};

        public static int[] a() {
            return (int[]) f10559e.clone();
        }
    }

    public GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.f10423g, googleSignInOptions, new ApiExceptionMapper());
    }

    private final synchronized int c() {
        if (f10554b == b.f10555a) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability a2 = GoogleApiAvailability.a();
            int a3 = a2.a(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (a3 == 0) {
                f10554b = b.f10558d;
            } else if (a2.a(applicationContext, a3, (String) null) == null && DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") != 0) {
                f10554b = b.f10557c;
            } else {
                f10554b = b.f10556b;
            }
        }
        return f10554b;
    }

    public Intent a() {
        Context applicationContext = getApplicationContext();
        int i = c.f10582a[c() - 1];
        if (i == 1) {
            return zzh.b(applicationContext, getApiOptions());
        }
        if (i != 2) {
            return zzh.c(applicationContext, getApiOptions());
        }
        return zzh.a(applicationContext, getApiOptions());
    }

    public Task<Void> b() {
        return PendingResultUtil.a(zzh.a(asGoogleApiClient(), getApplicationContext(), c() == b.f10557c));
    }
}
