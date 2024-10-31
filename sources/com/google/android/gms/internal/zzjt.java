package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.zzox;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzjt {
    private static DocumentSection zza(String str, zzox.zzc zzcVar) {
        return new DocumentSection(zzse.zzf(zzcVar), new RegisterSectionInfo.zza(str).a(true).b(str).a("blob").a());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.a());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey(ShareConstants.WEB_DIALOG_PARAM_ID) ? Uri.parse(bundle2.getString(ShareConstants.WEB_DIALOG_PARAM_ID)) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzju.zza(str, Uri.parse(bundle2.getString("url")));
        DocumentContents.zza a2 = UsageInfo.a(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            a2.a(DocumentSection.a(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            a2.a(new Account(bundle.getString(".private:accountName"), "com.google"));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        a2.a(zza(".private:action", zzf(bundle)));
        return new UsageInfo.zza().a(UsageInfo.a(str, zza)).a(j).a(i2).a(a2.a()).a(z).b(i).a();
    }

    static zzox.zzc zzf(Bundle bundle) {
        zzox.zzc zzcVar = new zzox.zzc();
        ArrayList arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            zzox.zzb zzbVar = new zzox.zzb();
            zzbVar.name = str;
            zzbVar.zzaCZ = new zzox.zzd();
            if (obj instanceof String) {
                zzbVar.zzaCZ.zzagS = (String) obj;
            } else if (obj instanceof Bundle) {
                zzbVar.zzaCZ.zzaDe = zzf((Bundle) obj);
            } else {
                Log.e("SearchIndex", "Unsupported value: " + obj);
            }
            arrayList.add(zzbVar);
        }
        if (bundle.containsKey("type")) {
            zzcVar.type = bundle.getString("type");
        }
        zzcVar.zzaDa = (zzox.zzb[]) arrayList.toArray(new zzox.zzb[arrayList.size()]);
        return zzcVar;
    }
}
