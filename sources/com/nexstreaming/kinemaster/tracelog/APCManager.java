package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import c.d.b.m.i;
import com.google.firebase.iid.FirebaseInstanceId;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.AuthPromocodeResponse;
import com.nexstreaming.app.general.util.J;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/* loaded from: classes.dex */
public class APCManager {

    /* renamed from: a */
    private static Random f21266a = new Random();

    /* renamed from: b */
    private static final String[] f21267b = {"57454348415432303136"};

    /* renamed from: c */
    private static boolean f21268c = false;

    /* renamed from: d */
    private static boolean f21269d = false;

    /* loaded from: classes.dex */
    public enum APCValidationResult {
        Valid,
        Invalid,
        Unknown
    }

    /* loaded from: classes.dex */
    public static class a implements Task.TaskError {

        /* renamed from: a */
        private final boolean f21270a;

        /* renamed from: b */
        private final int f21271b;

        /* renamed from: c */
        private final int f21272c;

        /* renamed from: d */
        private final Date f21273d;

        /* renamed from: e */
        private final String f21274e;

        /* renamed from: f */
        private final int f21275f;

        /* renamed from: g */
        private final Task.TaskError f21276g;

        public a(boolean z, String str, int i, Date date) {
            this.f21270a = z;
            this.f21271b = i;
            this.f21273d = date;
            this.f21274e = str;
            this.f21276g = null;
            this.f21275f = -1;
            this.f21272c = -1;
        }

        public Task.TaskError a() {
            return this.f21276g;
        }

        public boolean b() {
            return this.f21270a;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            Date date = this.f21273d;
            long time = date != null ? ((date.getTime() - i.b(context)) + 43200000) / 86400000 : -1L;
            if (time >= 0) {
                return context.getString(this.f21271b, Long.valueOf(time));
            }
            int i = this.f21275f;
            return i >= 0 ? context.getString(this.f21271b, Integer.valueOf(i)) : context.getString(this.f21271b);
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return this.f21274e;
        }

        public String a(Context context, boolean z) {
            int i;
            Date date = this.f21273d;
            long time = date != null ? ((date.getTime() - i.b(context)) + 43200000) / 86400000 : -1L;
            if (z && (i = this.f21272c) > -1) {
                int i2 = this.f21275f;
                return i2 >= 0 ? context.getString(i, Integer.valueOf(i2)) : context.getString(i);
            }
            if (time >= 0) {
                return context.getString(this.f21271b, Long.valueOf(time));
            }
            int i3 = this.f21275f;
            return i3 >= 0 ? context.getString(this.f21271b, Integer.valueOf(i3)) : context.getString(this.f21271b);
        }

        public a(boolean z, String str, int i, int i2, Date date) {
            this.f21270a = z;
            this.f21271b = i;
            this.f21273d = date;
            this.f21274e = str;
            this.f21276g = null;
            this.f21275f = -1;
            this.f21272c = i2;
        }

        public a(boolean z, String str, int i, int i2, Date date, int i3) {
            this.f21270a = z;
            this.f21271b = i;
            this.f21273d = date;
            this.f21274e = str;
            this.f21276g = null;
            this.f21275f = i3;
            this.f21272c = i2;
        }

        public a(boolean z, String str, int i, Date date, Task.TaskError taskError) {
            this.f21270a = z;
            this.f21271b = i;
            this.f21273d = date;
            this.f21274e = str;
            this.f21276g = taskError;
            this.f21275f = -1;
            this.f21272c = -1;
        }
    }

    public static void b(Context context, AuthPromocodeResponse authPromocodeResponse, SharedPreferences sharedPreferences, String str) {
        String b2;
        long time = authPromocodeResponse.getExpDate().getTime();
        long b3 = time - i.b(context);
        String accountType = authPromocodeResponse.getAccountType();
        String accountName = authPromocodeResponse.getAccountName();
        if (accountType == null) {
            accountType = "Promotional";
        }
        Log.i("APCManager", "cacheCode() called with: exp_date = [" + time + "]remaining = [" + b3 + "]");
        if (b3 > 0) {
            String str2 = io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + (f21266a.nextInt(26) + 65) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + f21266a.nextInt(SupportMenu.USER_MASK);
            if (str == null) {
                str = "!!!!!!!!!!!!!!!" + (f21266a.nextInt(26) + 65) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + f21266a.nextInt(SupportMenu.USER_MASK);
            }
            String a2 = FirebaseInstanceId.b().a();
            if (!accountType.equals("Team") && !accountType.equals("Standard")) {
                b2 = b("awnzk" + time + "jdtr01c" + str2 + "hzD5KEP" + str + "ZoXVD" + a2);
            } else {
                b2 = b("awnzk" + time + "jdtr01c" + str2 + "hzD5KEP" + str + "tXoeEK" + accountType + "ZoXVD" + a2);
            }
            sharedPreferences.edit().putString("apc_code", str).putString("apc_base", str2).putLong("apc_date", time).putString("apc_account_type", accountType).putString("apc_account_name", accountName).putString("apc_check", b2).putBoolean("is_subscription_or_promotion", true).commit();
        }
    }

    private static String c(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return sb.toString();
    }

    public static boolean a() {
        return f21268c;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.tracelog.APCManager.a(android.content.Context):boolean");
    }

    private static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(("z5[}V0r(!3?v7nap" + str.length() + str).getBytes());
            return J.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Required digest algorithm not found", e2);
        }
    }

    public static ResultTask<APCValidationResult> a(Context context, boolean z) {
        ResultTask<APCValidationResult> resultTask = new ResultTask<>();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("com.kinemaster.apc.sel_account_name", null);
        context.getApplicationContext();
        if (string != null && string.trim().length() > 0) {
            a(context, (String) null, string, z).onResultAvailable(new b(resultTask, defaultSharedPreferences)).onFailure((Task.OnFailListener) new com.nexstreaming.kinemaster.tracelog.a(resultTask, defaultSharedPreferences));
        } else {
            resultTask.sendResult(APCValidationResult.Invalid);
        }
        return resultTask;
    }

    public static ResultTask<a> a(Context context, String str, String str2, boolean z) {
        ResultTask<a> resultTask = new ResultTask<>();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString("com.kinemaster.apc.sel_account_name", str2).apply();
        if (z) {
            str2 = b(str2);
        }
        f.a(context, str, str2).onResultAvailable(new d(context, defaultSharedPreferences, str, resultTask)).onFailure((Task.OnFailListener) new c(resultTask));
        return resultTask;
    }

    public static boolean a(String str) {
        if (str == null) {
            return true;
        }
        for (String str2 : f21267b) {
            if (str.equalsIgnoreCase(c(str2).toString())) {
                return false;
            }
        }
        return true;
    }

    public static String a(int i) {
        String[] strArr = f21267b;
        if (i < strArr.length) {
            return c(strArr[i]);
        }
        return null;
    }
}
