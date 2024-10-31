package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.hg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0930hg implements zzbjt<zzbjm> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjm zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzblr zzr = zzblr.zzr(zzbpuVar);
            if (zzr instanceof zzblr) {
                zzbpd.zzs(zzr.getVersion(), 0);
                zzbpd.zzeh(zzr.zzagf().size());
                return new zzbnw(zzr.zzagf().toByteArray());
            }
            throw new GeneralSecurityException("expected AesGcmKey proto");
        } catch (zzbrl unused) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzblr) {
            zzblr zzblrVar = (zzblr) zzbslVar;
            zzbpd.zzs(zzblrVar.getVersion(), 0);
            zzbpd.zzeh(zzblrVar.zzagf().size());
            return new zzbnw(zzblrVar.zzagf().toByteArray());
        }
        throw new GeneralSecurityException("expected AesGcmKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzblt.zzt(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.AesGcmKey").zzai(((zzblr) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzblt) {
            zzblt zzbltVar = (zzblt) zzbslVar;
            zzbpd.zzeh(zzbltVar.getKeySize());
            return (zzbrd) zzblr.zzagu().zzs(zzbpu.zzr(zzboy.zzeg(zzbltVar.getKeySize()))).zzdn(0).zzana();
        }
        throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
    }
}
