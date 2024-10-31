package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Storage {

    /* renamed from: a, reason: collision with root package name */
    private static final Lock f10597a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    private static Storage f10598b;

    /* renamed from: c, reason: collision with root package name */
    private final Lock f10599c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences f10600d;

    @VisibleForTesting
    private Storage(Context context) {
        this.f10600d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @KeepForSdk
    public static Storage a(Context context) {
        Preconditions.a(context);
        f10597a.lock();
        try {
            if (f10598b == null) {
                f10598b = new Storage(context.getApplicationContext());
            }
            return f10598b;
        } finally {
            f10597a.unlock();
        }
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInAccount b() {
        return a(c("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInOptions c() {
        return b(c("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    @Nullable
    public String d() {
        return c("refreshToken");
    }

    public final void e() {
        String c2 = c("defaultGoogleSignInAccount");
        d("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        d(b("googleSignInAccount", c2));
        d(b("googleSignInOptions", c2));
    }

    private final void d(String str) {
        this.f10599c.lock();
        try {
            this.f10600d.edit().remove(str).apply();
        } finally {
            this.f10599c.unlock();
        }
    }

    @VisibleForTesting
    @Nullable
    private final GoogleSignInOptions b(String str) {
        String c2;
        if (!TextUtils.isEmpty(str) && (c2 = c(b("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.e(c2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    private final String c(String str) {
        this.f10599c.lock();
        try {
            return this.f10600d.getString(str, null);
        } finally {
            this.f10599c.unlock();
        }
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @KeepForSdk
    public void a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.a(googleSignInAccount);
        Preconditions.a(googleSignInOptions);
        a("defaultGoogleSignInAccount", googleSignInAccount.V());
        Preconditions.a(googleSignInAccount);
        Preconditions.a(googleSignInOptions);
        String V = googleSignInAccount.V();
        a(b("googleSignInAccount", V), googleSignInAccount.W());
        a(b("googleSignInOptions", V), googleSignInOptions.W());
    }

    private final void a(String str, String str2) {
        this.f10599c.lock();
        try {
            this.f10600d.edit().putString(str, str2).apply();
        } finally {
            this.f10599c.unlock();
        }
    }

    @VisibleForTesting
    @Nullable
    private final GoogleSignInAccount a(String str) {
        String c2;
        if (!TextUtils.isEmpty(str) && (c2 = c(b("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.e(c2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @KeepForSdk
    public void a() {
        this.f10599c.lock();
        try {
            this.f10600d.edit().clear().apply();
        } finally {
            this.f10599c.unlock();
        }
    }
}
