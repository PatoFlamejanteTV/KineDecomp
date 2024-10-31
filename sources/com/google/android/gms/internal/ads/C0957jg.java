package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.jg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0957jg implements zzbjt<zzbjm> {
    private static zzbjm a(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return a(zzbni.zzaj(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbslVar) throws GeneralSecurityException {
        return a(zzbslVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzbnk.zzak(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.KmsAeadKey").zzai(((zzbni) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.REMOTE).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        return a(zzbpuVar);
    }

    private static zzbjm a(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbni) {
            zzbni zzbniVar = (zzbni) zzbslVar;
            zzbpd.zzs(zzbniVar.getVersion(), 0);
            String zzajl = zzbniVar.zzaji().zzajl();
            return zzbjw.zzfh(zzajl).zzfg(zzajl);
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbnk) {
            return (zzbrd) zzbni.zzajj().zzb((zzbnk) zzbslVar).zzed(0).zzana();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }
}
