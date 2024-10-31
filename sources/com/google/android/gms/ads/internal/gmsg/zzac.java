package com.google.android.gms.ads.internal.gmsg;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.facebook.appevents.u;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaoa;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzcu;
import com.google.android.gms.internal.ads.zzcv;
import com.qq.e.comm.constants.Constants;
import java.net.URISyntaxException;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zzac<T extends zzbhc & zzbhd & zzbhh & zzbhk & zzbhm> implements zzu<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzw f10063a;

    /* renamed from: b, reason: collision with root package name */
    private final zzaoa f10064b;

    public zzac(zzw zzwVar, zzaoa zzaoaVar) {
        this.f10063a = zzwVar;
        this.f10064b = zzaoaVar;
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return zzbv.g().zzzx();
        }
        if (Constants.LANDSCAPE.equalsIgnoreCase(str)) {
            return zzbv.g().zzzw();
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzbv.g().zzzy();
        }
        return -1;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbhc zzbhcVar = (zzbhc) obj;
        String zzb = zzawz.zzb((String) map.get(u.f9225a), zzbhcVar.getContext(), true);
        String str = (String) map.get(com.umeng.commonsdk.proguard.e.al);
        if (str == null) {
            zzbbd.zzeo("Action missing from an open GMSG.");
            return;
        }
        zzw zzwVar = this.f10063a;
        if (zzwVar != null && !zzwVar.b()) {
            this.f10063a.a(zzb);
            return;
        }
        if ("expand".equalsIgnoreCase(str)) {
            if (((zzbhd) zzbhcVar).zzadq()) {
                zzbbd.zzeo("Cannot expand WebView that is already expanded.");
                return;
            } else {
                a(false);
                ((zzbhh) zzbhcVar).zzb(a((Map<String, String>) map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            a(false);
            if (zzb != null) {
                ((zzbhh) zzbhcVar).zza(a((Map<String, String>) map), b(map), zzb);
                return;
            } else {
                ((zzbhh) zzbhcVar).zza(a((Map<String, String>) map), b(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if ("app".equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase((String) map.get("system_browser"))) {
            a(true);
            zzbhcVar.getContext();
            if (TextUtils.isEmpty(zzb)) {
                zzbbd.zzeo("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbhh) zzbhcVar).zza(new com.google.android.gms.ads.internal.overlay.zzc(new zzad(zzbhcVar.getContext(), ((zzbhk) zzbhcVar).zzado(), ((zzbhm) zzbhcVar).getView()).a((Map<String, String>) map)));
                return;
            } catch (ActivityNotFoundException e2) {
                zzbbd.zzeo(e2.getMessage());
                return;
            }
        }
        a(true);
        String str2 = (String) map.get("intent_url");
        Intent intent = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                intent = Intent.parseUri(str2, 0);
            } catch (URISyntaxException e3) {
                String valueOf = String.valueOf(str2);
                zzbbd.zzb(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e3);
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String uri = data.toString();
            if (!TextUtils.isEmpty(uri)) {
                try {
                    uri = a(zzbhcVar.getContext(), ((zzbhk) zzbhcVar).zzado(), uri, ((zzbhm) zzbhcVar).getView(), zzbhcVar.zzabw());
                } catch (Exception e4) {
                    zzbbd.zzb("Error occurred while adding signals.", e4);
                    zzbv.i().zza(e4, "OpenGmsgHandler.onGmsg");
                }
                try {
                    data = Uri.parse(uri);
                } catch (Exception e5) {
                    String valueOf2 = String.valueOf(uri);
                    zzbbd.zzb(valueOf2.length() != 0 ? "Error parsing the uri: ".concat(valueOf2) : new String("Error parsing the uri: "), e5);
                    zzbv.i().zza(e5, "OpenGmsgHandler.onGmsg");
                }
            }
            intent.setData(data);
        }
        if (intent != null) {
            ((zzbhh) zzbhcVar).zza(new com.google.android.gms.ads.internal.overlay.zzc(intent));
            return;
        }
        if (!TextUtils.isEmpty(zzb)) {
            zzb = a(zzbhcVar.getContext(), ((zzbhk) zzbhcVar).zzado(), zzb, ((zzbhm) zzbhcVar).getView(), zzbhcVar.zzabw());
        }
        ((zzbhh) zzbhcVar).zza(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get(com.umeng.commonsdk.proguard.e.aq), zzb, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
    }

    private final void a(boolean z) {
        zzaoa zzaoaVar = this.f10064b;
        if (zzaoaVar != null) {
            zzaoaVar.zzx(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static String a(Context context, zzcu zzcuVar, String str, View view, Activity activity) {
        if (zzcuVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzcuVar.zzc(parse)) {
                parse = zzcuVar.zza(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzcv unused) {
            return str;
        } catch (Exception e2) {
            zzbv.i().zza(e2, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }
}
