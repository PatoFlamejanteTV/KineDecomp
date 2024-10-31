package com.google.android.gms.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class zzz implements zzar {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2246a = new Object();
    private String b;
    private String c;
    private v d;
    private k e;

    @Override // com.google.android.gms.tagmanager.zzar
    public boolean a(String str) {
        if (!this.d.a()) {
            zzbg.b("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        if (this.b != null && this.c != null) {
            try {
                str = this.b + "?" + this.c + "=" + URLEncoder.encode(str, Keyczar.DEFAULT_ENCODING);
                zzbg.d("Sending wrapped url hit: " + str);
            } catch (UnsupportedEncodingException e) {
                zzbg.b("Error wrapping URL for testing.", e);
                return false;
            }
        }
        this.e.a(str);
        return true;
    }
}
