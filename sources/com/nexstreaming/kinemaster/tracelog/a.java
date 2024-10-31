package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.AuthPromocodeResponse;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.general.util.v;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/* compiled from: APCManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Random f3639a = new Random();
    private static final String[] b = {"57454348415432303136"};

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r11) {
        /*
            r0 = 0
            android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r11)
            java.lang.String r2 = "apc_code"
            java.lang.String r3 = ""
            java.lang.String r2 = r1.getString(r2, r3)
            java.lang.String r3 = "apc_date"
            r4 = 0
            long r4 = r1.getLong(r3, r4)
            java.lang.String r3 = "apc_base"
            java.lang.String r6 = ""
            java.lang.String r3 = r1.getString(r3, r6)
            java.lang.String r6 = "apc_check"
            java.lang.String r7 = ""
            java.lang.String r1 = r1.getString(r6, r7)
            long r6 = com.nexstreaming.kinemaster.h.a.g(r11)
            java.lang.String r8 = "APCManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "check : apc_date = ["
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r10 = "]"
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.i(r8, r9)
            java.lang.String r8 = "APCManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "check : cur_date = ["
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r6)
            java.lang.String r10 = "]"
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.i(r8, r9)
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 > 0) goto Lec
            int r6 = r3.length()
            if (r6 <= 0) goto Lec
            int r6 = r1.length()
            if (r6 <= 0) goto Lec
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "awnzk"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.String r5 = "jdtr01c"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = "hzD5KEP"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.String r4 = "ZoXVD"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = b(r3)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Le3
            com.nexstreaming.app.general.util.DiagnosticLogger r0 = com.nexstreaming.app.general.util.DiagnosticLogger.a()
            com.nexstreaming.app.general.util.DiagnosticLogger$Tag r1 = com.nexstreaming.app.general.util.DiagnosticLogger.Tag.APCM_UNEX_CC
            r0.a(r1)
            r0 = 1
            r1 = r0
        Lb7:
            if (r1 == 0) goto Lca
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r3 = "Promotion Code"
            r0.put(r3, r2)     // Catch: org.json.JSONException -> Lee
            com.mixpanel.android.mpmetrics.n$c r2 = com.nexstreaming.kinemaster.usage.KMUsage.getMixpanelPeople(r11)     // Catch: org.json.JSONException -> Lee
            r2.a(r0)     // Catch: org.json.JSONException -> Lee
        Lca:
            java.lang.String r0 = "APCManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "checkAPC() returned: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r0, r2)
            return r1
        Le3:
            com.nexstreaming.app.general.util.DiagnosticLogger r1 = com.nexstreaming.app.general.util.DiagnosticLogger.a()
            com.nexstreaming.app.general.util.DiagnosticLogger$Tag r3 = com.nexstreaming.app.general.util.DiagnosticLogger.Tag.APCM_HFAIL
            r1.a(r3)
        Lec:
            r1 = r0
            goto Lb7
        Lee:
            r0 = move-exception
            r0.printStackTrace()
            goto Lca
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.tracelog.a.a(android.content.Context):boolean");
    }

    public static ResultTask<C0073a> a(Context context, String str, String str2, boolean z) {
        ResultTask<C0073a> resultTask = new ResultTask<>();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString("com.kinemaster.apc.sel_account_name", str2).apply();
        if (z) {
            str2 = b(str2);
        }
        d.a(context, str, str2).onResultAvailable(new c(resultTask, context, defaultSharedPreferences, str)).onFailure((Task.OnFailListener) new b(resultTask));
        return resultTask;
    }

    /* compiled from: APCManager.java */
    /* renamed from: com.nexstreaming.kinemaster.tracelog.a$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3640a = new int[ResponseCode.values().length];

        static {
            try {
                f3640a[ResponseCode.ALREADYINUSE_PROMOCODE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3640a[ResponseCode.PROMOCODE_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3640a[ResponseCode.INVALID_PROMOCODE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3640a[ResponseCode.EXPIRED_PROMOCODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3640a[ResponseCode.PROMOCODE_ALREADY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3640a[ResponseCode.SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, AuthPromocodeResponse authPromocodeResponse, SharedPreferences sharedPreferences, String str) {
        long time = authPromocodeResponse.getExpDate().getTime();
        long g = time - com.nexstreaming.kinemaster.h.a.g(context);
        Log.i("APCManager", "cacheCode() called with: exp_date = [" + time + "]remaining = [" + g + "]");
        if (g > 0) {
            String str2 = "_" + (f3639a.nextInt(26) + 65) + "_" + f3639a.nextInt(65535);
            if (str == null) {
                str = "!!!!!!!!!!!!!!!" + (f3639a.nextInt(26) + 65) + "_" + f3639a.nextInt(65535);
            }
            sharedPreferences.edit().putString("apc_code", str).putString("apc_base", str2).putLong("apc_date", time).putString("apc_check", b("awnzk" + time + "jdtr01c" + str2 + "hzD5KEP" + str + "ZoXVD")).commit();
        }
    }

    private static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(("z5[}V0r(!3?v7nap" + str.length() + str).getBytes());
            return v.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Required digest algorithm not found", e);
        }
    }

    /* compiled from: APCManager.java */
    /* renamed from: com.nexstreaming.kinemaster.tracelog.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0073a implements Task.TaskError {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3641a;
        private final int b;
        private final Date c;
        private final String d;

        public C0073a(boolean z, String str, int i, Date date) {
            this.f3641a = z;
            this.b = i;
            this.c = date;
            this.d = str;
        }

        public boolean a() {
            return this.f3641a;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return this.d;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            long j = -1;
            if (this.c != null) {
                j = ((this.c.getTime() - com.nexstreaming.kinemaster.h.a.g(context)) + 43200000) / 86400000;
            }
            return j >= 0 ? context.getString(this.b, Long.valueOf(j)) : context.getString(this.b);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            for (String str2 : b) {
                if (str.equalsIgnoreCase(c(str2).toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String a(int i) {
        if (i >= b.length) {
            return null;
        }
        return c(b[i]);
    }

    private static String c(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            sb.append((char) Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return sb.toString();
    }
}
