package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzr extends com.google.android.gms.analytics.zzi<zzr> {
    private String name;
    private String zzno;
    private String zztz;
    private String zzua;
    private String zzub;
    private String zzuc;
    private String zzud;
    private String zzue;
    private String zzuf;
    private String zzug;

    public final String getId() {
        return this.zzno;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSource() {
        return this.zztz;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.name);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, this.zztz);
        hashMap.put("medium", this.zzua);
        hashMap.put("keyword", this.zzub);
        hashMap.put("content", this.zzuc);
        hashMap.put("id", this.zzno);
        hashMap.put("adNetworkId", this.zzud);
        hashMap.put("gclid", this.zzue);
        hashMap.put("dclid", this.zzuf);
        hashMap.put("aclid", this.zzug);
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzr zzrVar) {
        zzr zzrVar2 = zzrVar;
        if (!TextUtils.isEmpty(this.name)) {
            zzrVar2.name = this.name;
        }
        if (!TextUtils.isEmpty(this.zztz)) {
            zzrVar2.zztz = this.zztz;
        }
        if (!TextUtils.isEmpty(this.zzua)) {
            zzrVar2.zzua = this.zzua;
        }
        if (!TextUtils.isEmpty(this.zzub)) {
            zzrVar2.zzub = this.zzub;
        }
        if (!TextUtils.isEmpty(this.zzuc)) {
            zzrVar2.zzuc = this.zzuc;
        }
        if (!TextUtils.isEmpty(this.zzno)) {
            zzrVar2.zzno = this.zzno;
        }
        if (!TextUtils.isEmpty(this.zzud)) {
            zzrVar2.zzud = this.zzud;
        }
        if (!TextUtils.isEmpty(this.zzue)) {
            zzrVar2.zzue = this.zzue;
        }
        if (!TextUtils.isEmpty(this.zzuf)) {
            zzrVar2.zzuf = this.zzuf;
        }
        if (TextUtils.isEmpty(this.zzug)) {
            return;
        }
        zzrVar2.zzug = this.zzug;
    }

    public final String zzbd() {
        return this.zzua;
    }

    public final String zzbe() {
        return this.zzub;
    }

    public final String zzbf() {
        return this.zzuc;
    }

    public final String zzbg() {
        return this.zzud;
    }

    public final String zzbh() {
        return this.zzue;
    }

    public final String zzbi() {
        return this.zzuf;
    }

    public final String zzbj() {
        return this.zzug;
    }

    public final void zzc(String str) {
        this.zztz = str;
    }

    public final void zzd(String str) {
        this.zzua = str;
    }

    public final void zze(String str) {
        this.zzub = str;
    }

    public final void zzf(String str) {
        this.zzuc = str;
    }

    public final void zzg(String str) {
        this.zzno = str;
    }

    public final void zzh(String str) {
        this.zzud = str;
    }

    public final void zzi(String str) {
        this.zzue = str;
    }

    public final void zzj(String str) {
        this.zzuf = str;
    }

    public final void zzk(String str) {
        this.zzug = str;
    }
}
