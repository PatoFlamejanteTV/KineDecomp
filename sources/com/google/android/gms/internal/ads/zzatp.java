package com.google.android.gms.internal.ads;

import android.content.Context;

@zzark
/* loaded from: classes2.dex */
public final class zzatp {
    public final zzua zzeal;
    public final zzaxa zzeam;
    public final zzaab zzean;
    public final zzaug zzeao;
    public final zzakk zzeap;
    public final zzauh zzeaq;
    public final zzaov zzear;
    public final zzaxe zzeas;
    public final zzatu zzeat;
    public final zzatx zzeak = null;
    public final boolean zzeaj = true;

    private zzatp(zzatx zzatxVar, zzua zzuaVar, zzaxa zzaxaVar, zzaab zzaabVar, zzaug zzaugVar, zzakk zzakkVar, zzauh zzauhVar, zzaov zzaovVar, zzaxe zzaxeVar, boolean z, zzatu zzatuVar) {
        this.zzeal = zzuaVar;
        this.zzeam = zzaxaVar;
        this.zzean = zzaabVar;
        this.zzeao = zzaugVar;
        this.zzeap = zzakkVar;
        this.zzeaq = zzauhVar;
        this.zzear = zzaovVar;
        this.zzeas = zzaxeVar;
        this.zzeat = zzatuVar;
    }

    public static zzatp zzo(Context context) {
        com.google.android.gms.ads.internal.zzbv.q().initialize(context);
        zzauj zzaujVar = new zzauj(context);
        return new zzatp(null, new zzud(), new zzaxb(), new zzaaa(), new zzaue(context, zzaujVar.zzwp()), new zzakl(), new zzaui(), new zzaou(), new zzaxc(), true, zzaujVar);
    }
}
