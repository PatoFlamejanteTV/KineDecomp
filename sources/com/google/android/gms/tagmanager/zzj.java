package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class zzj extends al {
    private final zza g;
    private final Context h;
    private static final String b = zzad.ARBITRARY_PIXEL.toString();
    private static final String c = zzae.URL.toString();
    private static final String d = zzae.ADDITIONAL_PARAMS.toString();
    private static final String e = zzae.UNREPEATABLE.toString();

    /* renamed from: a, reason: collision with root package name */
    static final String f2240a = "gtm_" + b + "_unrepeatable";
    private static final Set<String> f = new HashSet();

    /* loaded from: classes.dex */
    public interface zza {
        zzar a();
    }

    private synchronized boolean c(String str) {
        boolean z = true;
        synchronized (this) {
            if (!b(str)) {
                if (a(str)) {
                    f.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean a(String str) {
        return this.h.getSharedPreferences(f2240a, 0).contains(str);
    }

    @Override // com.google.android.gms.tagmanager.al
    public void b(Map<String, zzag.zza> map) {
        String a2 = map.get(e) != null ? zzdf.a(map.get(e)) : null;
        if (a2 == null || !c(a2)) {
            Uri.Builder buildUpon = Uri.parse(zzdf.a(map.get(c))).buildUpon();
            zzag.zza zzaVar = map.get(d);
            if (zzaVar != null) {
                Object c2 = zzdf.c(zzaVar);
                if (!(c2 instanceof List)) {
                    zzbg.a("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                    return;
                }
                for (Object obj : (List) c2) {
                    if (!(obj instanceof Map)) {
                        zzbg.a("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                        return;
                    }
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.g.a().a(uri);
            zzbg.d("ArbitraryPixel: url = " + uri);
            if (a2 != null) {
                synchronized (zzj.class) {
                    f.add(a2);
                    ah.a(this.h, f2240a, a2, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }

    boolean b(String str) {
        return f.contains(str);
    }
}
