package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProfileInformationCache.java */
/* loaded from: classes.dex */
public class B {

    /* renamed from: a */
    private static final ConcurrentHashMap<String, JSONObject> f9269a = new ConcurrentHashMap<>();

    public static JSONObject a(String str) {
        return f9269a.get(str);
    }

    public static void a(String str, JSONObject jSONObject) {
        f9269a.put(str, jSONObject);
    }
}
