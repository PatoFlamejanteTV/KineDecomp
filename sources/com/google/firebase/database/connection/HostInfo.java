package com.google.firebase.database.connection;

import java.net.URI;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class HostInfo {

    /* renamed from: a */
    private final String f16738a;

    /* renamed from: b */
    private final String f16739b;

    /* renamed from: c */
    private final boolean f16740c;

    public HostInfo(String str, String str2, boolean z) {
        this.f16738a = str;
        this.f16739b = str2;
        this.f16740c = z;
    }

    public static URI a(String str, boolean z, String str2, String str3) {
        String str4 = (z ? "wss" : "ws") + "://" + str + "/.ws?ns=" + str2 + "&v=5";
        if (str3 != null) {
            str4 = str4 + "&ls=" + str3;
        }
        return URI.create(str4);
    }

    public String b() {
        return this.f16739b;
    }

    public boolean c() {
        return this.f16740c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.f16740c ? com.umeng.commonsdk.proguard.e.ap : "");
        sb.append("://");
        sb.append(this.f16738a);
        return sb.toString();
    }

    public String a() {
        return this.f16738a;
    }
}
