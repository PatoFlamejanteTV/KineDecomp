package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionInfo.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private Long f9194a;

    /* renamed from: b, reason: collision with root package name */
    private Long f9195b;

    /* renamed from: c, reason: collision with root package name */
    private int f9196c;

    /* renamed from: d, reason: collision with root package name */
    private Long f9197d;

    /* renamed from: e, reason: collision with root package name */
    private SourceApplicationInfo f9198e;

    /* renamed from: f, reason: collision with root package name */
    private UUID f9199f;

    public l(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
    }

    public static void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        edit.remove("com.facebook.appevents.SessionInfo.sessionId");
        edit.apply();
        SourceApplicationInfo.a();
    }

    public static l h() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (j == 0 || j2 == 0 || string == null) {
            return null;
        }
        l lVar = new l(Long.valueOf(j), Long.valueOf(j2));
        lVar.f9196c = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        lVar.f9198e = SourceApplicationInfo.b();
        lVar.f9197d = Long.valueOf(System.currentTimeMillis());
        lVar.f9199f = UUID.fromString(string);
        return lVar;
    }

    public long b() {
        Long l = this.f9197d;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public int c() {
        return this.f9196c;
    }

    public UUID d() {
        return this.f9199f;
    }

    public Long e() {
        return this.f9195b;
    }

    public long f() {
        Long l;
        if (this.f9194a == null || (l = this.f9195b) == null) {
            return 0L;
        }
        return l.longValue() - this.f9194a.longValue();
    }

    public SourceApplicationInfo g() {
        return this.f9198e;
    }

    public void i() {
        this.f9196c++;
    }

    public void j() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.f9194a.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.f9195b.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f9196c);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f9199f.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.f9198e;
        if (sourceApplicationInfo != null) {
            sourceApplicationInfo.c();
        }
    }

    public l(Long l, Long l2, UUID uuid) {
        this.f9194a = l;
        this.f9195b = l2;
        this.f9199f = uuid;
    }

    public void a(Long l) {
        this.f9195b = l;
    }

    public void a(SourceApplicationInfo sourceApplicationInfo) {
        this.f9198e = sourceApplicationInfo;
    }
}
