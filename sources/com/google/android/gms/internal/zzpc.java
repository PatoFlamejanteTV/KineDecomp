package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzpc extends com.google.android.gms.measurement.zze<zzpc> {
    private String mName;
    private String zzaGu;
    private String zzaLn;
    private String zzaLo;
    private String zzaLp;
    private String zzaLq;
    private String zzaLr;
    private String zzaLs;
    private String zzvY;
    private String zzwN;

    public String getContent() {
        return this.zzvY;
    }

    public String getId() {
        return this.zzwN;
    }

    public String getName() {
        return this.mName;
    }

    public String getSource() {
        return this.zzaGu;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, this.zzaGu);
        hashMap.put("medium", this.zzaLn);
        hashMap.put("keyword", this.zzaLo);
        hashMap.put("content", this.zzvY);
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.zzwN);
        hashMap.put("adNetworkId", this.zzaLp);
        hashMap.put("gclid", this.zzaLq);
        hashMap.put("dclid", this.zzaLr);
        hashMap.put("aclid", this.zzaLs);
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpc zzpcVar) {
        if (!TextUtils.isEmpty(this.mName)) {
            zzpcVar.setName(this.mName);
        }
        if (!TextUtils.isEmpty(this.zzaGu)) {
            zzpcVar.zzdH(this.zzaGu);
        }
        if (!TextUtils.isEmpty(this.zzaLn)) {
            zzpcVar.zzdI(this.zzaLn);
        }
        if (!TextUtils.isEmpty(this.zzaLo)) {
            zzpcVar.zzdJ(this.zzaLo);
        }
        if (!TextUtils.isEmpty(this.zzvY)) {
            zzpcVar.zzdK(this.zzvY);
        }
        if (!TextUtils.isEmpty(this.zzwN)) {
            zzpcVar.zzdL(this.zzwN);
        }
        if (!TextUtils.isEmpty(this.zzaLp)) {
            zzpcVar.zzdM(this.zzaLp);
        }
        if (!TextUtils.isEmpty(this.zzaLq)) {
            zzpcVar.zzdN(this.zzaLq);
        }
        if (!TextUtils.isEmpty(this.zzaLr)) {
            zzpcVar.zzdO(this.zzaLr);
        }
        if (TextUtils.isEmpty(this.zzaLs)) {
            return;
        }
        zzpcVar.zzdP(this.zzaLs);
    }

    public void zzdH(String str) {
        this.zzaGu = str;
    }

    public void zzdI(String str) {
        this.zzaLn = str;
    }

    public void zzdJ(String str) {
        this.zzaLo = str;
    }

    public void zzdK(String str) {
        this.zzvY = str;
    }

    public void zzdL(String str) {
        this.zzwN = str;
    }

    public void zzdM(String str) {
        this.zzaLp = str;
    }

    public void zzdN(String str) {
        this.zzaLq = str;
    }

    public void zzdO(String str) {
        this.zzaLr = str;
    }

    public void zzdP(String str) {
        this.zzaLs = str;
    }

    public String zzyu() {
        return this.zzaLn;
    }

    public String zzyv() {
        return this.zzaLo;
    }

    public String zzyw() {
        return this.zzaLp;
    }

    public String zzyx() {
        return this.zzaLq;
    }

    public String zzyy() {
        return this.zzaLr;
    }

    public String zzyz() {
        return this.zzaLs;
    }
}
