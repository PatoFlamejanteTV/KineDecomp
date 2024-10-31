package com.adobe.creativesdk.foundation.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public class AdobeAuthKeychain {

    /* renamed from: a, reason: collision with root package name */
    private static AdobeAuthKeychain f4770a;

    /* renamed from: b, reason: collision with root package name */
    protected SharedPreferences f4771b;

    /* renamed from: c, reason: collision with root package name */
    protected SharedPreferences f4772c;

    /* renamed from: d, reason: collision with root package name */
    private AdobeAuthKeychainMigrationStatusValue f4773d = AdobeAuthKeychainMigrationStatusValue.Undefined;

    /* renamed from: e, reason: collision with root package name */
    protected Context f4774e;

    /* renamed from: f, reason: collision with root package name */
    private AdobeAuthIdentityManagementService f4775f;

    /* renamed from: g, reason: collision with root package name */
    private String f4776g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum AdobeAuthKeychainMigrationStatusValue {
        Undefined,
        NotMigrated,
        Migrated
    }

    public AdobeAuthKeychain(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService) {
        c("");
        this.f4774e = c.a.a.a.c.a.a.b().a();
        this.f4775f = adobeAuthIdentityManagementService;
        this.f4771b = this.f4774e.getSharedPreferences("Foundation", 0);
        if (Integer.valueOf(this.f4771b.getInt("KeychainVersion", 0)).intValue() < 10) {
            SharedPreferences.Editor edit = this.f4771b.edit();
            edit.remove("EnvironmentIndicator");
            s();
            edit.putInt("KeychainVersion", 10);
            edit.apply();
            J.e().b();
        }
        this.f4772c = this.f4774e.getSharedPreferences("FoundationMigrated", 0);
        if (t() == AdobeAuthKeychainMigrationStatusValue.NotMigrated) {
            v();
        }
    }

    public static void a(AdobeAuthKeychain adobeAuthKeychain) {
        f4770a = adobeAuthKeychain;
    }

    private String e(String str) {
        if (this.f4773d == AdobeAuthKeychainMigrationStatusValue.NotMigrated) {
            return this.f4775f.g().a(this.f4771b.getString(str, null));
        }
        return this.f4772c.getString(str, null);
    }

    public static AdobeAuthKeychain r() {
        return f4770a;
    }

    private AdobeAuthKeychainMigrationStatusValue t() {
        if (this.f4773d == AdobeAuthKeychainMigrationStatusValue.Undefined) {
            this.f4773d = AdobeAuthKeychainMigrationStatusValue.values()[this.f4771b.getInt("KeyChainMigrated", AdobeAuthKeychainMigrationStatusValue.NotMigrated.ordinal())];
        }
        return this.f4773d;
    }

    private boolean u() {
        int i = this.f4771b.getInt("EnvironmentIndicator", -1);
        if (i != -1) {
            if (i == this.f4775f.w().ordinal() || AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined == this.f4775f.w()) {
                return false;
            }
            a("EnvironmentIndicator", this.f4775f.w());
            return true;
        }
        a("EnvironmentIndicator", this.f4775f.w());
        return true;
    }

    private void v() {
        Map<String, ?> all = this.f4771b.getAll();
        if (all.size() > 0) {
            SharedPreferences.Editor edit = this.f4772c.edit();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(entry.getKey(), e(entry.getKey()));
                } else if (value instanceof Integer) {
                    edit.putInt(entry.getKey(), ((Integer) value).intValue());
                }
            }
            edit.apply();
        }
        SharedPreferences.Editor edit2 = this.f4771b.edit();
        this.f4773d = AdobeAuthKeychainMigrationStatusValue.Migrated;
        edit2.putInt("KeyChainMigrated", this.f4773d.ordinal());
        edit2.apply();
    }

    public String b(String str) {
        if (u()) {
            s();
            return null;
        }
        return e(str);
    }

    public void c(String str) {
        this.f4776g = str;
    }

    public String d() {
        return b("ContinuableEventErrorCode");
    }

    public String f() {
        return b("CountryCode");
    }

    public String g() {
        return b("DeviceToken");
    }

    public Date h() {
        return d(b("DeviceTokenExpiration"));
    }

    public String i() {
        return b("DisplayName");
    }

    public String j() {
        return b("Email");
    }

    public String k() {
        return b("EmailVerified");
    }

    public String l() {
        return b("EnterpriseInfo");
    }

    public String m() {
        return b("FirstName");
    }

    public AdobeAuthIMSEnvironment n() {
        int i = this.f4771b.getInt("EnvironmentIndicator", -1);
        if (i == -1) {
            return AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS;
        }
        return AdobeAuthIMSEnvironment.values()[i];
    }

    public String o() {
        return b("LastName");
    }

    public String p() {
        return b("RefreshToken");
    }

    public Date q() {
        return d(b("RefreshTokenExpiration"));
    }

    public void s() {
        a("AdobeID");
        a("AccessToken");
        a("AccessTokenExpiration");
        a("ContinuationToken");
        a("DeviceToken");
        a("DeviceTokenExpiration");
        a("DisplayName");
        a("Email");
        a("EmailVerified");
        a("Entitlements");
        a("FirstName");
        a("LastName");
        a("RefreshToken");
        a("RefreshTokenExpiration");
        a("EnterpriseInfo");
        a("ContinuableEventJumpURL");
        a("ContinuableEventErrorCode");
        a("idpFlow");
    }

    private Date d(String str) {
        if (str == null) {
            return null;
        }
        try {
            Long valueOf = Long.valueOf(str.trim());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(valueOf.longValue());
            return calendar.getTime();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAuthKeychain.class.getSimpleName(), e2.getMessage(), e2);
            return null;
        }
    }

    public void a(String str) {
        if (t() == AdobeAuthKeychainMigrationStatusValue.NotMigrated) {
            SharedPreferences.Editor edit = this.f4771b.edit();
            edit.remove(str);
            edit.apply();
        } else {
            SharedPreferences.Editor edit2 = this.f4772c.edit();
            edit2.remove(str);
            edit2.apply();
        }
    }

    public String c() {
        return b("AdobeID");
    }

    private void b(String str, Object obj) {
        String obj2;
        if (obj instanceof Date) {
            obj2 = Long.toString(((Date) obj).getTime());
        } else {
            obj2 = obj.toString();
        }
        if (t() == AdobeAuthKeychainMigrationStatusValue.NotMigrated) {
            String b2 = this.f4775f.g().b(obj2);
            SharedPreferences.Editor edit = this.f4771b.edit();
            edit.putString(str, b2);
            edit.apply();
            return;
        }
        SharedPreferences.Editor edit2 = this.f4772c.edit();
        edit2.putString(str, obj2);
        edit2.apply();
    }

    public String e() {
        return b("ContinuableEventJumpURL");
    }

    public void a(String str, Object obj) {
        u();
        b(str, obj);
    }

    private void a(String str, AdobeAuthIMSEnvironment adobeAuthIMSEnvironment) {
        SharedPreferences.Editor edit = this.f4771b.edit();
        edit.putInt(str, adobeAuthIMSEnvironment.ordinal());
        edit.apply();
    }

    public String a() {
        return b("AccessToken");
    }

    public Date b() {
        return d(b("AccessTokenExpiration"));
    }
}
