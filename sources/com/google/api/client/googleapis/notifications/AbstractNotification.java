package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractNotification {

    /* renamed from: a */
    private long f14695a;

    /* renamed from: b */
    private String f14696b;

    /* renamed from: c */
    private String f14697c;

    /* renamed from: d */
    private String f14698d;

    /* renamed from: e */
    private String f14699e;

    /* renamed from: f */
    private String f14700f;

    /* renamed from: g */
    private String f14701g;

    /* renamed from: h */
    private String f14702h;

    protected AbstractNotification(long j, String str, String str2, String str3, String str4) {
        a(j);
        f(str);
        e(str2);
        g(str3);
        c(str4);
    }

    public AbstractNotification a(long j) {
        Preconditions.a(j >= 1);
        this.f14695a = j;
        return this;
    }

    public final String b() {
        return this.f14700f;
    }

    public final String c() {
        return this.f14699e;
    }

    public final String d() {
        return this.f14701g;
    }

    public final long e() {
        return this.f14695a;
    }

    public AbstractNotification f(String str) {
        Preconditions.a(str);
        this.f14696b = str;
        return this;
    }

    public final String g() {
        return this.f14696b;
    }

    public final String h() {
        return this.f14698d;
    }

    public Objects.ToStringHelper i() {
        return Objects.a(this).a("messageNumber", Long.valueOf(this.f14695a)).a("resourceState", this.f14696b).a("resourceId", this.f14697c).a("resourceUri", this.f14698d).a("channelId", this.f14699e).a("channelExpiration", this.f14700f).a("channelToken", this.f14701g).a("changed", this.f14702h);
    }

    public String toString() {
        return i().toString();
    }

    public AbstractNotification b(String str) {
        this.f14700f = str;
        return this;
    }

    public AbstractNotification c(String str) {
        Preconditions.a(str);
        this.f14699e = str;
        return this;
    }

    public AbstractNotification d(String str) {
        this.f14701g = str;
        return this;
    }

    public AbstractNotification e(String str) {
        Preconditions.a(str);
        this.f14697c = str;
        return this;
    }

    public final String f() {
        return this.f14697c;
    }

    public AbstractNotification g(String str) {
        Preconditions.a(str);
        this.f14698d = str;
        return this;
    }

    public final String a() {
        return this.f14702h;
    }

    public AbstractNotification a(String str) {
        this.f14702h = str;
        return this;
    }

    public AbstractNotification(AbstractNotification abstractNotification) {
        this(abstractNotification.e(), abstractNotification.g(), abstractNotification.f(), abstractNotification.h(), abstractNotification.c());
        b(abstractNotification.b());
        d(abstractNotification.d());
        a(abstractNotification.a());
    }
}
