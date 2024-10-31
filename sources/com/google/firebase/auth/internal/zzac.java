package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/* loaded from: classes2.dex */
public final class zzac {

    /* renamed from: a, reason: collision with root package name */
    private static final com.google.android.gms.internal.firebase_auth.zzz<String> f16502a = com.google.android.gms.internal.firebase_auth.zzz.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* renamed from: b, reason: collision with root package name */
    private static final zzac f16503b = new zzac();

    /* renamed from: c, reason: collision with root package name */
    private Task<AuthResult> f16504c;

    /* renamed from: d, reason: collision with root package name */
    private long f16505d = 0;

    private zzac() {
    }

    public static zzac a() {
        return f16503b;
    }

    public static void a(Context context, zzdr zzdrVar, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.b(zzdrVar));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong("timestamp", DefaultClock.d().a());
        edit.commit();
    }

    public static void a(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.O());
        edit.putLong("timestamp", DefaultClock.d().a());
        edit.commit();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007f, code lost:            if (r4.equals("com.google.firebase.auth.internal.SIGN_IN") == false) goto L26;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.firebase.auth.FirebaseAuth r12) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzac.a(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final void a(Context context) {
        Preconditions.a(context);
        a(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f16504c = null;
        this.f16505d = 0L;
    }

    private static void a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        com.google.android.gms.internal.firebase_auth.zzz<String> zzzVar = f16502a;
        int size = zzzVar.size();
        int i = 0;
        while (i < size) {
            String str = zzzVar.get(i);
            i++;
            edit.remove(str);
        }
        edit.commit();
    }
}
