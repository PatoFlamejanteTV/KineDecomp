package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class an {
    private static u<zzag.zza> a(u<zzag.zza> uVar) {
        try {
            return new u<>(zzdf.c(a(zzdf.a(uVar.a()))), uVar.b());
        } catch (UnsupportedEncodingException e) {
            zzbg.a("Escape URI: unsupported encoding", e);
            return uVar;
        }
    }

    private static u<zzag.zza> a(u<zzag.zza> uVar, int i) {
        if (!a(uVar.a())) {
            zzbg.a("Escaping can only be applied to strings.");
            return uVar;
        }
        switch (i) {
            case 12:
                return a(uVar);
            default:
                zzbg.a("Unsupported Value Escaping: " + i);
                return uVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u<zzag.zza> a(u<zzag.zza> uVar, int... iArr) {
        for (int i : iArr) {
            uVar = a(uVar, i);
        }
        return uVar;
    }

    static String a(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, Keyczar.DEFAULT_ENCODING).replaceAll("\\+", "%20");
    }

    private static boolean a(zzag.zza zzaVar) {
        return zzdf.c(zzaVar) instanceof String;
    }
}
