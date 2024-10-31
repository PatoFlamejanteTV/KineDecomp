package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzajt implements zzaic, zzajs {
    private final zzajr zzdjy;
    private final HashSet<AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr>>> zzdjz = new HashSet<>();

    public zzajt(zzajr zzajrVar) {
        this.zzdjy = zzajrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr> zzuVar) {
        this.zzdjy.zza(str, zzuVar);
        this.zzdjz.add(new AbstractMap.SimpleEntry<>(str, zzuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zzb(String str, com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr> zzuVar) {
        this.zzdjy.zzb(str, zzuVar);
        this.zzdjz.remove(new AbstractMap.SimpleEntry(str, zzuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        this.zzdjy.zzcg(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzuh() {
        Iterator<AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr>>> it = this.zzdjz.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzaxz.v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdjy.zzb(next.getKey(), next.getValue());
        }
        this.zzdjz.clear();
    }
}
