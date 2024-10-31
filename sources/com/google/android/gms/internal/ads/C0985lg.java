package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;

/* renamed from: com.google.android.gms.internal.ads.lg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0985lg implements zzbjt<zzbjr> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjr zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzbmf zzx = zzbmf.zzx(zzbpuVar);
            if (zzx instanceof zzbmf) {
                zzbpd.zzs(zzx.getVersion(), 0);
                C1055qg.a(zzx.zzahj().zzahc());
                zzbmd zzahc = zzx.zzahj().zzahc();
                zzbmj zzahe = zzahc.zzahe();
                zzboi a2 = C1055qg.a(zzahe.zzahr());
                byte[] byteArray = zzx.zzagf().toByteArray();
                return new zzbob((ECPrivateKey) zzbol.zzfjx.zzfu("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzbog.zza(a2))), zzahe.zzaht().toByteArray(), C1055qg.a(zzahe.zzahs()), C1055qg.a(zzahc.zzahg()), new C1082sg(zzahc.zzahf().zzagz()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjr zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbmf) {
            zzbmf zzbmfVar = (zzbmf) zzbslVar;
            zzbpd.zzs(zzbmfVar.getVersion(), 0);
            C1055qg.a(zzbmfVar.zzahj().zzahc());
            zzbmd zzahc = zzbmfVar.zzahj().zzahc();
            zzbmj zzahe = zzahc.zzahe();
            zzboi a2 = C1055qg.a(zzahe.zzahr());
            byte[] byteArray = zzbmfVar.zzagf().toByteArray();
            return new zzbob((ECPrivateKey) zzbol.zzfjx.zzfu("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzbog.zza(a2))), zzahe.zzaht().toByteArray(), C1055qg.a(zzahe.zzahs()), C1055qg.a(zzahc.zzahg()), new C1082sg(zzahc.zzahf().zzagz()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzbmb.zzw(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zzai(((zzbmf) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.ASYMMETRIC_PRIVATE).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbmb) {
            zzbmb zzbmbVar = (zzbmb) zzbslVar;
            C1055qg.a(zzbmbVar.zzahc());
            KeyPair zza = zzbog.zza(zzbog.zza(C1055qg.a(zzbmbVar.zzahc().zzahe().zzahr())));
            ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
            ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
            ECPoint w = eCPublicKey.getW();
            return (zzbrd) zzbmf.zzahk().zzdq(0).zzb((zzbmh) zzbmh.zzaho().zzdr(0).zzc(zzbmbVar.zzahc()).zzac(zzbpu.zzr(w.getAffineX().toByteArray())).zzad(zzbpu.zzr(w.getAffineY().toByteArray())).zzana()).zzy(zzbpu.zzr(eCPrivateKey.getS().toByteArray())).zzana();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }
}
