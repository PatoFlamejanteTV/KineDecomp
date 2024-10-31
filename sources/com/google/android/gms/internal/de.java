package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@zzgr
/* loaded from: classes.dex */
public class de {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f1498a;
    private final List<String> b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final boolean g;
    private final String h;
    private String i;
    private int j;

    public de(int i, Map<String, String> map) {
        this.i = map.get("url");
        this.d = map.get("base_uri");
        this.e = map.get("post_parameters");
        this.g = b(map.get("drt_include"));
        this.c = map.get("activation_overlay_url");
        this.b = c(map.get("check_packages"));
        this.h = map.get("request_id");
        this.f = map.get("type");
        this.f1498a = c(map.get("errors"));
        this.j = i;
    }

    private static boolean b(String str) {
        return str != null && (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    private List<String> c(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public int a() {
        return this.j;
    }

    public void a(String str) {
        this.i = str;
    }

    public List<String> b() {
        return this.f1498a;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }
}
