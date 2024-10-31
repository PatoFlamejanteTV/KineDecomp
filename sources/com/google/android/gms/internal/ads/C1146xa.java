package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.xa */
/* loaded from: classes2.dex */
public final class C1146xa extends zzbie {

    /* renamed from: a */
    private final /* synthetic */ zzahv f12650a;

    /* JADX INFO: Access modifiers changed from: private */
    public C1146xa(zzahv zzahvVar) {
        this.f12650a = zzahvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zza(zzbif zzbifVar) {
        zzaij zzaijVar;
        zzaij zzaijVar2;
        zzaijVar = this.f12650a.zzdie;
        if (zzaijVar != null) {
            zzaijVar2 = this.f12650a.zzdie;
            zzaijVar2.zzub();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zzb(zzbif zzbifVar) {
        this.f12650a.zzf(zzbifVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final boolean zzc(zzbif zzbifVar) {
        return this.f12650a.zzf(zzbifVar.uri);
    }

    public /* synthetic */ C1146xa(zzahv zzahvVar, C1118va c1118va) {
        this(zzahvVar);
    }
}
