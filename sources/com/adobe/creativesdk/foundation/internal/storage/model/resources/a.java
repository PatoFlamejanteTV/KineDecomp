package com.adobe.creativesdk.foundation.internal.storage.model.resources;

import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeRequestParameters.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private int f6601a;

    /* renamed from: b */
    private int f6602b;

    /* renamed from: c */
    private String f6603c;

    /* renamed from: d */
    private String f6604d;

    /* renamed from: e */
    private final String f6605e = PlaceFields.PAGE;

    /* renamed from: f */
    private final String f6606f = "size";

    /* renamed from: g */
    private final String f6607g = ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION;

    /* renamed from: h */
    private Map<String, String> f6608h = new HashMap();

    public void a(int i) {
        this.f6601a = i;
        a(PlaceFields.PAGE, String.valueOf(i));
    }

    public void b(int i) {
        this.f6602b = i;
        if (i > 0) {
            a("size", String.valueOf(i));
        }
    }

    public void c(String str) {
        this.f6604d = str;
        a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, String.valueOf(str));
    }

    public String a(String str) {
        String str2 = this.f6608h.get(str);
        return str2 != null ? str2 : "";
    }

    public String b() {
        return this.f6603c;
    }

    public String a() {
        Iterator<Map.Entry<String, String>> it = this.f6608h.entrySet().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getValue();
        }
        return str;
    }

    public void b(String str) {
        this.f6603c = str;
    }

    private void a(String str, String str2) {
        this.f6608h.put(str, ";" + str + "=" + str2);
    }
}
