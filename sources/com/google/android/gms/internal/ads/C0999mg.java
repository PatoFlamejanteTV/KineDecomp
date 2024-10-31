package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.mg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0999mg implements zzbjt<zzbjs> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjs zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzbmh zzab = zzbmh.zzab(zzbpuVar);
            if (zzab instanceof zzbmh) {
                zzbpd.zzs(zzab.getVersion(), 0);
                C1055qg.a(zzab.zzahc());
                zzbmd zzahc = zzab.zzahc();
                zzbmj zzahe = zzahc.zzahe();
                return new zzboc(zzbog.zza(C1055qg.a(zzahe.zzahr()), zzab.zzahm().toByteArray(), zzab.zzahn().toByteArray()), zzahe.zzaht().toByteArray(), C1055qg.a(zzahe.zzahs()), C1055qg.a(zzahc.zzahg()), new C1082sg(zzahc.zzahf().zzagz()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjs zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbmh) {
            zzbmh zzbmhVar = (zzbmh) zzbslVar;
            zzbpd.zzs(zzbmhVar.getVersion(), 0);
            C1055qg.a(zzbmhVar.zzahc());
            zzbmd zzahc = zzbmhVar.zzahc();
            zzbmj zzahe = zzahc.zzahe();
            return new zzboc(zzbog.zza(C1055qg.a(zzahe.zzahr()), zzbmhVar.zzahm().toByteArray(), zzbmhVar.zzahn().toByteArray()), zzahe.zzaht().toByteArray(), C1055qg.a(zzahe.zzahs()), C1055qg.a(zzahc.zzahg()), new C1082sg(zzahc.zzahf().zzagz()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }
}
