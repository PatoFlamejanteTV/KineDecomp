package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzrb;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzra {
    private final Context mContext;
    private String zzaWs;
    private final zzrc zzbak;
    Map<String, Object<zzrb.zzc>> zzbal;
    private final Map<String, Object> zzbam;
    private final zzmn zzpW;

    public zzra(Context context) {
        this(context, new HashMap(), new zzrc(context), zzmp.zzqt());
    }

    zzra(Context context, Map<String, Object> map, zzrc zzrcVar, zzmn zzmnVar) {
        this.zzaWs = null;
        this.zzbal = new HashMap();
        this.mContext = context;
        this.zzpW = zzmnVar;
        this.zzbak = zzrcVar;
        this.zzbam = map;
    }

    public void zzfm(String str) {
        this.zzaWs = str;
    }
}
