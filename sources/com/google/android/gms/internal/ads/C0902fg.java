package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.fg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0902fg implements zzbjt<zzbov> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbnu zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzblf zzl = zzblf.zzl(zzbpuVar);
            if (zzl instanceof zzblf) {
                zzbpd.zzs(zzl.getVersion(), 0);
                zzbpd.zzeh(zzl.zzagf().size());
                a(zzl.zzage());
                return new zzbnu(zzl.zzagf().toByteArray(), zzl.zzage().zzagl());
            }
            throw new GeneralSecurityException("expected AesCtrKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbov zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzblf) {
            zzblf zzblfVar = (zzblf) zzbslVar;
            zzbpd.zzs(zzblfVar.getVersion(), 0);
            zzbpd.zzeh(zzblfVar.zzagf().size());
            a(zzblfVar.zzage());
            return new zzbnu(zzblfVar.zzagf().toByteArray(), zzblfVar.zzage().zzagl());
        }
        throw new GeneralSecurityException("expected AesCtrKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzblh.zzn(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.AesCtrKey").zzai(((zzblf) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzblh) {
            zzblh zzblhVar = (zzblh) zzbslVar;
            zzbpd.zzeh(zzblhVar.getKeySize());
            a(zzblhVar.zzage());
            return (zzbrd) zzblf.zzagg().zzc(zzblhVar.zzage()).zzm(zzbpu.zzr(zzboy.zzeg(zzblhVar.getKeySize()))).zzdl(0).zzana();
        }
        throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
    }

    private static void a(zzblj zzbljVar) throws GeneralSecurityException {
        if (zzbljVar.zzagl() < 12 || zzbljVar.zzagl() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
