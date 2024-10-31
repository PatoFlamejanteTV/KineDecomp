package com.google.firebase.database.util;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class GAuthToken {

    /* renamed from: a */
    private final String f17266a;

    /* renamed from: b */
    private final Map<String, Object> f17267b;

    public GAuthToken(String str, Map<String, Object> map) {
        this.f17266a = str;
        this.f17267b = map;
    }

    public static GAuthToken a(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map<String, Object> a2 = JsonMapper.a(str.substring(6));
            return new GAuthToken((String) a2.get("token"), (Map) a2.get("auth"));
        } catch (IOException e2) {
            throw new RuntimeException("Failed to parse gauth token", e2);
        }
    }

    public String b() {
        return this.f17266a;
    }

    public Map<String, Object> a() {
        return this.f17267b;
    }
}
