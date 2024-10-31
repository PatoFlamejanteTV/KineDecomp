package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes.dex */
public final class GoogleSignIn {
    private GoogleSignIn() {
    }

    public static GoogleSignInClient a(Context context, GoogleSignInOptions googleSignInOptions) {
        Preconditions.a(googleSignInOptions);
        return new GoogleSignInClient(context, googleSignInOptions);
    }

    public static Task<GoogleSignInAccount> a(Intent intent) {
        GoogleSignInResult a2 = zzh.a(intent);
        if (a2 == null) {
            return Tasks.a((Exception) ApiExceptionUtil.a(Status.f10706c));
        }
        if (a2.getStatus().Q() && a2.a() != null) {
            return Tasks.a(a2.a());
        }
        return Tasks.a((Exception) ApiExceptionUtil.a(a2.getStatus()));
    }
}
