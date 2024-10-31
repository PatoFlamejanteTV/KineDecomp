package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public final class zzdr implements zzdk {
    private final com.google.android.gms.ads.internal.zze zzxQ;
    private final zzfc zzxR;
    private final zzdm zzxT;

    /* loaded from: classes.dex */
    public static class zza extends zzhz {
        private final String zzF;
        private final zziz zzoM;
        private final String zzxU = "play.google.com";
        private final String zzxV = "market";
        private final int zzxW = 10;

        public zza(zziz zzizVar, String str) {
            this.zzoM = zzizVar;
            this.zzF = str;
        }

        @Override // com.google.android.gms.internal.zzhz
        public void onStop() {
        }

        public Intent zzaa(String str) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(parse);
            return intent;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:            com.google.android.gms.ads.internal.util.client.zzb.e("Arrived at landing page, this ideally should not happen. Will open it in browser.");     */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:            r0 = r2;     */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x008f A[EDGE_INSN: B:41:0x008f->B:42:0x008f BREAK  A[LOOP:0: B:2:0x0003->B:27:0x00ad], SYNTHETIC] */
        @Override // com.google.android.gms.internal.zzhz
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void zzbn() {
            /*
                Method dump skipped, instructions count: 284
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdr.zza.zzbn():void");
        }
    }

    /* loaded from: classes.dex */
    public static class zzb {
        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList<>());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = queryIntentActivities.get(i2);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzb(Context context, Map<String, String> map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo zza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean(map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean(map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList<ResolveInfo> arrayList = new ArrayList<>();
            Intent zzd = zzd(parse);
            Intent zzd2 = zzd(build);
            ResolveInfo zza2 = zza(context, zzd, arrayList);
            if (zza2 != null) {
                return zza(zzd, zza2);
            }
            if (zzd2 != null && (zza = zza(context, zzd2)) != null) {
                Intent zza3 = zza(zzd, zza);
                if (zza(context, zza3) != null) {
                    return zza3;
                }
            }
            if (arrayList.size() == 0) {
                return zzd;
            }
            if (parseBoolean2 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ResolveInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ResolveInfo next = it.next();
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().processName.equals(next.activityInfo.packageName)) {
                            return zza(zzd, next);
                        }
                    }
                }
            }
            return parseBoolean ? zza(zzd, arrayList.get(0)) : zzd;
        }

        public Intent zzd(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzdr(zzdm zzdmVar, com.google.android.gms.ads.internal.zze zzeVar, zzfc zzfcVar) {
        this.zzxT = zzdmVar;
        this.zzxQ = zzeVar;
        this.zzxR = zzfcVar;
    }

    private static void zza(Context context, Map<String, String> map) {
        if (TextUtils.isEmpty(map.get("u"))) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Destination url cannot be empty.");
            return;
        }
        try {
            com.google.android.gms.ads.internal.zzp.e().zzb(context, new zzb().zzb(context, map));
        } catch (ActivityNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e(e.getMessage());
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzp.g().zzgH();
            }
            if ("l".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzp.g().zzgG();
            }
            if ("c".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzp.g().zzgI();
            }
        }
        return -1;
    }

    private static void zze(zziz zzizVar, Map<String, String> map) {
        String str = map.get("u");
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Destination url cannot be empty.");
        } else {
            new zza(zzizVar, str).zzfu();
        }
    }

    private void zzm(boolean z) {
        if (this.zzxR != null) {
            this.zzxR.zzn(z);
        }
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Action missing from an open GMSG.");
            return;
        }
        if (this.zzxQ != null && !this.zzxQ.b()) {
            this.zzxQ.a(map.get("u"));
            return;
        }
        zzja zzhe = zzizVar.zzhe();
        if ("expand".equalsIgnoreCase(str)) {
            if (zzizVar.zzhi()) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzm(false);
                zzhe.zza(zzc(map), zzd(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            String str2 = map.get("u");
            zzm(false);
            if (str2 != null) {
                zzhe.zza(zzc(map), zzd(map), str2);
                return;
            } else {
                zzhe.zza(zzc(map), zzd(map), map.get("html"), map.get("baseurl"));
                return;
            }
        }
        if ("in_app_purchase".equalsIgnoreCase(str)) {
            String str3 = map.get("product_id");
            String str4 = map.get("report_urls");
            if (this.zzxT != null) {
                if (str4 == null || str4.isEmpty()) {
                    this.zzxT.zza(str3, new ArrayList<>());
                    return;
                } else {
                    this.zzxT.zza(str3, new ArrayList<>(Arrays.asList(str4.split(" "))));
                    return;
                }
            }
            return;
        }
        if ("app".equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(map.get("play_store"))) {
            zze(zzizVar, map);
            return;
        }
        if ("app".equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(map.get("system_browser"))) {
            zza(zzizVar.getContext(), map);
            return;
        }
        zzm(true);
        zzizVar.zzhg();
        String str5 = map.get("u");
        zzhe.zza(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str5) ? com.google.android.gms.ads.internal.zzp.e().zza(zzizVar, str5) : str5, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
    }
}
