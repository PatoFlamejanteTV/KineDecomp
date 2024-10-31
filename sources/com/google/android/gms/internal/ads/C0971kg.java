package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.kg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0971kg implements zzbjt<zzbjm> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjm zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzbnm zzal = zzbnm.zzal(zzbpuVar);
            if (zzal instanceof zzbnm) {
                zzbpd.zzs(zzal.getVersion(), 0);
                String zzajr = zzal.zzajo().zzajr();
                return new zzbkl(zzal.zzajo().zzajs(), zzbjw.zzfh(zzajr).zzfg(zzajr));
            }
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbnm) {
            zzbnm zzbnmVar = (zzbnm) zzbslVar;
            zzbpd.zzs(zzbnmVar.getVersion(), 0);
            String zzajr = zzbnmVar.zzajo().zzajr();
            return new zzbkl(zzbnmVar.zzajo().zzajs(), zzbjw.zzfh(zzajr).zzfg(zzajr));
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzbno.zzam(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").zzai(((zzbnm) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.REMOTE).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbno) {
            return (zzbrd) zzbnm.zzajp().zzb((zzbno) zzbslVar).zzee(0).zzana();
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
    }
}
