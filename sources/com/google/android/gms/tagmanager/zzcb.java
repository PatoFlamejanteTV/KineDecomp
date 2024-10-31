package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class zzcb {

    /* renamed from: a, reason: collision with root package name */
    private static zzcb f2236a;
    private volatile zza b;
    private volatile String c;
    private volatile String d;
    private volatile String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzcb() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcb a() {
        zzcb zzcbVar;
        synchronized (zzcb.class) {
            if (f2236a == null) {
                f2236a = new zzcb();
            }
            zzcbVar = f2236a;
        }
        return zzcbVar;
    }

    private String a(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String b(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), Keyczar.DEFAULT_ENCODING);
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    zzbg.d("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.b = zza.CONTAINER_DEBUG;
                    } else {
                        this.b = zza.CONTAINER;
                    }
                    this.e = b(uri);
                    if (this.b == zza.CONTAINER || this.b == zza.CONTAINER_DEBUG) {
                        this.d = "/r?" + this.e;
                    }
                    this.c = a(this.e);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    zzbg.b("Invalid preview uri: " + decode);
                    z = false;
                } else if (a(uri.getQuery()).equals(this.c)) {
                    zzbg.d("Exit preview mode for container: " + this.c);
                    this.b = zza.NONE;
                    this.d = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.c;
    }

    void e() {
        this.b = zza.NONE;
        this.d = null;
        this.c = null;
        this.e = null;
    }
}
