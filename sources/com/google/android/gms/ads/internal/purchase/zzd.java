package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@zzgr
/* loaded from: classes.dex */
public class zzd extends zzfr.zza {

    /* renamed from: a, reason: collision with root package name */
    private String f613a;
    private Context b;
    private String c;
    private ArrayList<String> d;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.c = str;
        this.d = arrayList;
        this.f613a = str2;
        this.b = context;
    }

    protected int a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    protected String a(String str, HashMap<String, String> hashMap) {
        String str2;
        String packageName = this.b.getPackageName();
        try {
            str2 = this.b.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Error to retrieve app version", e);
            str2 = "";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzp.h().zzgn().zzgx();
        for (String str3 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", str3), String.format("$1%s$2", hashMap.get(str3)));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sessionid"), String.format("$1%s$2", zzp.h().getSessionId())).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appid"), String.format("$1%s$2", packageName)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "osversion"), String.format("$1%s$2", String.valueOf(Build.VERSION.SDK_INT))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sdkversion"), String.format("$1%s$2", this.f613a)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appversion"), String.format("$1%s$2", str2)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "timestamp"), String.format("$1%s$2", String.valueOf(elapsedRealtime))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "[^@]+"), String.format("$1%s$2", "")).replaceAll("@@", "@");
    }

    void a() {
        try {
            this.b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", Context.class, String.class, String.class, Boolean.TYPE).invoke(null, this.b, this.c, "", true);
        } catch (ClassNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to report a conversion.", e3);
        }
    }

    @Override // com.google.android.gms.internal.zzfr
    public String getProductId() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.zzfr
    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            a();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.c);
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(a(i)));
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            linkedList.add(a(it.next(), hashMap));
        }
        zzp.e().zza(this.b, this.f613a, linkedList);
    }

    @Override // com.google.android.gms.internal.zzfr
    public void recordResolution(int i) {
        if (i == 1) {
            a();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(i));
        hashMap.put("sku", this.c);
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            linkedList.add(a(it.next(), hashMap));
        }
        zzp.e().zza(this.b, this.f613a, linkedList);
    }
}
