package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.gg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0916gg implements zzbjt<zzbjm> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjm zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzbll zzo = zzbll.zzo(zzbpuVar);
            if (zzo instanceof zzbll) {
                zzbpd.zzs(zzo.getVersion(), 0);
                zzbpd.zzeh(zzo.zzagf().size());
                if (zzo.zzago().zzagl() != 12 && zzo.zzago().zzagl() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return new zzbnv(zzo.zzagf().toByteArray(), zzo.zzago().zzagl());
            }
            throw new GeneralSecurityException("expected AesEaxKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbll) {
            zzbll zzbllVar = (zzbll) zzbslVar;
            zzbpd.zzs(zzbllVar.getVersion(), 0);
            zzbpd.zzeh(zzbllVar.zzagf().size());
            if (zzbllVar.zzago().zzagl() != 12 && zzbllVar.zzago().zzagl() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
            return new zzbnv(zzbllVar.zzagf().toByteArray(), zzbllVar.zzago().zzagl());
        }
        throw new GeneralSecurityException("expected AesEaxKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzbln.zzq(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.AesEaxKey").zzai(((zzbll) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbln) {
            zzbln zzblnVar = (zzbln) zzbslVar;
            zzbpd.zzeh(zzblnVar.getKeySize());
            if (zzblnVar.zzago().zzagl() != 12 && zzblnVar.zzago().zzagl() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
            return (zzbrd) zzbll.zzagp().zzp(zzbpu.zzr(zzboy.zzeg(zzblnVar.getKeySize()))).zzb(zzblnVar.zzago()).zzdm(0).zzana();
        }
        throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
    }
}
