package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes.dex */
public abstract class AbstractNotification {

    /* renamed from: a, reason: collision with root package name */
    private long f2440a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    protected AbstractNotification(long j, String str, String str2, String str3, String str4) {
        a(j);
        a(str);
        b(str2);
        c(str3);
        d(str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractNotification(AbstractNotification abstractNotification) {
        this(abstractNotification.b(), abstractNotification.c(), abstractNotification.d(), abstractNotification.e(), abstractNotification.f());
        e(abstractNotification.g());
        f(abstractNotification.h());
        g(abstractNotification.i());
    }

    public String toString() {
        return a().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Objects.ToStringHelper a() {
        return Objects.a(this).a("messageNumber", Long.valueOf(this.f2440a)).a("resourceState", this.b).a("resourceId", this.c).a("resourceUri", this.d).a("channelId", this.e).a("channelExpiration", this.f).a("channelToken", this.g).a("changed", this.h);
    }

    public final long b() {
        return this.f2440a;
    }

    public AbstractNotification a(long j) {
        Preconditions.a(j >= 1);
        this.f2440a = j;
        return this;
    }

    public final String c() {
        return this.b;
    }

    public AbstractNotification a(String str) {
        this.b = (String) Preconditions.a(str);
        return this;
    }

    public final String d() {
        return this.c;
    }

    public AbstractNotification b(String str) {
        this.c = (String) Preconditions.a(str);
        return this;
    }

    public final String e() {
        return this.d;
    }

    public AbstractNotification c(String str) {
        this.d = (String) Preconditions.a(str);
        return this;
    }

    public final String f() {
        return this.e;
    }

    public AbstractNotification d(String str) {
        this.e = (String) Preconditions.a(str);
        return this;
    }

    public final String g() {
        return this.f;
    }

    public AbstractNotification e(String str) {
        this.f = str;
        return this;
    }

    public final String h() {
        return this.g;
    }

    public AbstractNotification f(String str) {
        this.g = str;
        return this;
    }

    public final String i() {
        return this.h;
    }

    public AbstractNotification g(String str) {
        this.h = str;
        return this;
    }
}
