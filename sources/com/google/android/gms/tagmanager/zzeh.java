package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
class zzeh {

    /* renamed from: a */
    private static zzeh f14247a;

    /* renamed from: b */
    private volatile zza f14248b = zza.NONE;

    /* renamed from: d */
    private volatile String f14250d = null;

    /* renamed from: c */
    private volatile String f14249c = null;

    /* renamed from: e */
    private volatile String f14251e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzeh() {
    }

    @ShowFirstParty
    public static zzeh b() {
        zzeh zzehVar;
        synchronized (zzeh.class) {
            if (f14247a == null) {
                f14247a = new zzeh();
            }
            zzehVar = f14247a;
        }
        return zzehVar;
    }

    public final synchronized boolean a(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                String valueOf = String.valueOf(decode);
                zzdi.a(valueOf.length() != 0 ? "Container preview url: ".concat(valueOf) : new String("Container preview url: "));
                if (decode.matches(".*?&gtm_debug=x$")) {
                    this.f14248b = zza.CONTAINER_DEBUG;
                } else {
                    this.f14248b = zza.CONTAINER;
                }
                this.f14251e = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.f14248b == zza.CONTAINER || this.f14248b == zza.CONTAINER_DEBUG) {
                    String valueOf2 = String.valueOf(this.f14251e);
                    this.f14250d = valueOf2.length() != 0 ? "/r?".concat(valueOf2) : new String("/r?");
                }
                this.f14249c = a(this.f14251e);
                return true;
            }
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                if (!a(uri.getQuery()).equals(this.f14249c)) {
                    return false;
                }
                String valueOf3 = String.valueOf(this.f14249c);
                zzdi.a(valueOf3.length() != 0 ? "Exit preview mode for container: ".concat(valueOf3) : new String("Exit preview mode for container: "));
                this.f14248b = zza.NONE;
                this.f14250d = null;
                return true;
            }
            String valueOf4 = String.valueOf(decode);
            zzdi.b(valueOf4.length() != 0 ? "Invalid preview uri: ".concat(valueOf4) : new String("Invalid preview uri: "));
            return false;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public final zza c() {
        return this.f14248b;
    }

    public final String d() {
        return this.f14250d;
    }

    public final String a() {
        return this.f14249c;
    }

    private static String a(String str) {
        return str.split("&")[0].split("=")[1];
    }
}
