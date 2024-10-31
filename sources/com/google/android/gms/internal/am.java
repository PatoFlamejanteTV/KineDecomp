package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class am implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        String str = map.get("urls");
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzizVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != null));
        }
        zzizVar.zzb("openableURLs", hashMap);
    }
}
