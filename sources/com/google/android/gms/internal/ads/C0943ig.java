package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.ig, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0943ig implements zzbjt<zzbjm> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjm zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzblv zzu = zzblv.zzu(zzbpuVar);
            if (zzu instanceof zzblv) {
                zzbpd.zzs(zzu.getVersion(), 0);
                if (zzu.zzagf().size() == 32) {
                    return new zzbnz(zzu.zzagf().toByteArray());
                }
                throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
            }
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzblv) {
            zzblv zzblvVar = (zzblv) zzbslVar;
            zzbpd.zzs(zzblvVar.getVersion(), 0);
            if (zzblvVar.zzagf().size() == 32) {
                return new zzbnz(zzblvVar.zzagf().toByteArray());
            }
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
        throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        return a();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zzai(a().zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        return a();
    }

    private static zzblv a() throws GeneralSecurityException {
        return (zzblv) zzblv.zzagx().zzdo(0).zzv(zzbpu.zzr(zzboy.zzeg(32))).zzana();
    }
}
