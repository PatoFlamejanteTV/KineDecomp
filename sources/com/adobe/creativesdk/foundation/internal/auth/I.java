package com.adobe.creativesdk.foundation.internal.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

/* compiled from: AdobeCSDKAdobeIdAuthenticatorHelper.java */
/* loaded from: classes.dex */
public class I {

    /* renamed from: a */
    private static final String f4818a = "I";

    /* renamed from: b */
    private static I f4819b;

    /* compiled from: AdobeCSDKAdobeIdAuthenticatorHelper.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: AdobeCSDKAdobeIdAuthenticatorHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        c f4820a;

        /* renamed from: b */
        boolean f4821b = false;
    }

    /* compiled from: AdobeCSDKAdobeIdAuthenticatorHelper.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public String f4822a;

        /* renamed from: b */
        public Date f4823b;

        /* renamed from: c */
        public String f4824c;
    }

    private I() {
    }

    private String a(String str) {
        return str;
    }

    private String b(String str) {
        return str;
    }

    public static boolean b(Context context) {
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.adobe.creativesdk.foundation.auth.adobeID");
            if (accountsByType != null) {
                return accountsByType.length > 0;
            }
            return false;
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e2.getMessage(), e2);
            return false;
        }
    }

    public static void c(Context context) {
        try {
            AccountManager accountManager = AccountManager.get(context);
            Account[] accountsByType = accountManager.getAccountsByType("com.adobe.creativesdk.foundation.auth.adobeID");
            if (accountsByType == null || accountsByType.length <= 0) {
                return;
            }
            accountManager.removeAccount(accountsByType[0], null, null);
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e2.getMessage(), e2);
        }
    }

    public static I a() {
        if (f4819b == null) {
            f4819b = new I();
        }
        return f4819b;
    }

    public static boolean a(c cVar) {
        Date date;
        return cVar == null || (date = cVar.f4823b) == null || date.getTime() - System.currentTimeMillis() < ((long) io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT);
    }

    private String b(String str, Date date) {
        StringBuilder sb = new StringBuilder();
        new Formatter(sb, Locale.US).format("%d %d %d %s", 1, 2, Long.valueOf(date.getTime()), str);
        return sb.toString();
    }

    public c c(String str) {
        if (str == null) {
            return null;
        }
        a(str);
        Scanner scanner = new Scanner(str);
        if (scanner.nextInt() > 1 || scanner.nextInt() < 2) {
            return null;
        }
        long nextLong = scanner.nextLong();
        String trim = scanner.next().trim();
        c cVar = new c();
        cVar.f4822a = trim;
        cVar.f4823b = new Date(nextLong);
        return cVar;
    }

    public void a(Context context, c cVar, boolean z) {
        if (!a(context)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f4818a, "authenticator signature !valid");
            return;
        }
        AccountManager accountManager = AccountManager.get(context);
        Bundle bundle = new Bundle();
        bundle.putString("adbAuth_adobeId", cVar.f4824c);
        bundle.putString("adbAuth_authtoken", a(cVar.f4822a, cVar.f4823b));
        if (z) {
            bundle.putBoolean("adbAuth_addaccount_signup_force", true);
        }
        try {
            accountManager.addAccount("com.adobe.creativesdk.foundation.auth.adobeID", "AdobeID access", null, bundle, null, null, null);
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e2.getMessage(), e2);
        }
    }

    public String a(String str, Date date) {
        String b2 = b(str, date);
        b(b2);
        return b2;
    }

    public boolean a(Context context) {
        boolean z = false;
        for (AuthenticatorDescription authenticatorDescription : AccountManager.get(context).getAuthenticatorTypes()) {
            if (authenticatorDescription.type.equalsIgnoreCase("com.adobe.creativesdk.foundation.auth.adobeID")) {
                z = context.getPackageManager().checkSignatures(context.getApplicationInfo().packageName, authenticatorDescription.packageName) == 0;
            }
        }
        return z;
    }

    public void a(Activity activity, Bundle bundle, a aVar) {
        new H(this, activity, bundle, aVar).execute(new Void[0]);
    }
}
