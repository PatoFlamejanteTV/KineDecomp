package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class IdManager {

    /* renamed from: a */
    private static final Pattern f26877a = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: b */
    private static final String f26878b = Pattern.quote("/");

    /* renamed from: c */
    private final ReentrantLock f26879c = new ReentrantLock();

    /* renamed from: d */
    private final u f26880d;

    /* renamed from: e */
    private final boolean f26881e;

    /* renamed from: f */
    private final boolean f26882f;

    /* renamed from: g */
    private final Context f26883g;

    /* renamed from: h */
    private final String f26884h;
    private final String i;
    private final Collection<io.fabric.sdk.android.l> j;
    d k;
    b l;
    boolean m;
    s n;

    /* loaded from: classes3.dex */
    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);

        public final int protobufIndex;

        DeviceIdentifierType(int i) {
            this.protobufIndex = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<io.fabric.sdk.android.l> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection != null) {
            this.f26883g = context;
            this.f26884h = str;
            this.i = str2;
            this.j = collection;
            this.f26880d = new u();
            this.k = new d(context);
            this.n = new s();
            this.f26881e = CommonUtils.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f26881e) {
                io.fabric.sdk.android.f.f().d("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f26882f = CommonUtils.a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (this.f26882f) {
                return;
            }
            io.fabric.sdk.android.f.f().d("Fabric", "User information collection disabled for " + context.getPackageName());
            return;
        }
        throw new IllegalArgumentException("kits must not be null");
    }

    private String b(String str) {
        return str.replaceAll(f26878b, "");
    }

    private Boolean o() {
        b c2 = c();
        if (c2 != null) {
            return Boolean.valueOf(c2.f26886b);
        }
        return null;
    }

    public boolean a() {
        return this.f26882f;
    }

    synchronized b c() {
        if (!this.m) {
            this.l = this.k.a();
            this.m = true;
        }
        return this.l;
    }

    public String d() {
        boolean equals = Boolean.TRUE.equals(o());
        if (n() && !equals) {
            String string = Settings.Secure.getString(this.f26883g.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return a(string);
            }
        }
        return null;
    }

    public String e() {
        return this.f26884h;
    }

    public String f() {
        String str = this.i;
        if (str != null) {
            return str;
        }
        SharedPreferences i = CommonUtils.i(this.f26883g);
        a(i);
        String string = i.getString("crashlytics.installation.id", null);
        return string == null ? b(i) : string;
    }

    public Map<DeviceIdentifierType, String> g() {
        HashMap hashMap = new HashMap();
        for (Object obj : this.j) {
            if (obj instanceof n) {
                for (Map.Entry<DeviceIdentifierType, String> entry : ((n) obj).getDeviceIdentifiers().entrySet()) {
                    a(hashMap, entry.getKey(), entry.getValue());
                }
            }
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            a(hashMap, DeviceIdentifierType.ANDROID_ID, d());
        } else {
            a(hashMap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, b2);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String h() {
        return this.f26880d.a(this.f26883g);
    }

    public String i() {
        return String.format(Locale.US, "%s/%s", b(Build.MANUFACTURER), b(Build.MODEL));
    }

    public String j() {
        return b(Build.VERSION.INCREMENTAL);
    }

    public String k() {
        return b(Build.VERSION.RELEASE);
    }

    public String l() {
        return k() + "/" + j();
    }

    public Boolean m() {
        if (n()) {
            return o();
        }
        return null;
    }

    protected boolean n() {
        return this.f26881e && !this.n.b(this.f26883g);
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return f26877a.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    @SuppressLint({"CommitPrefEdits"})
    private String b(SharedPreferences sharedPreferences) {
        this.f26879c.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f26879c.unlock();
        }
    }

    private void a(SharedPreferences sharedPreferences) {
        b c2 = c();
        if (c2 != null) {
            a(sharedPreferences, c2.f26885a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void a(SharedPreferences sharedPreferences, String str) {
        this.f26879c.lock();
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String string = sharedPreferences.getString("crashlytics.advertising.id", null);
            if (TextUtils.isEmpty(string)) {
                sharedPreferences.edit().putString("crashlytics.advertising.id", str).commit();
            } else if (!string.equals(str)) {
                sharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str).commit();
            }
        } finally {
            this.f26879c.unlock();
        }
    }

    public String b() {
        b c2;
        if (!n() || (c2 = c()) == null || c2.f26886b) {
            return null;
        }
        return c2.f26885a;
    }

    private void a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }
}
