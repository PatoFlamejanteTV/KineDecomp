package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.ads.eg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0888eg implements zzbjt<zzbjm> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f12145a = Logger.getLogger(C0888eg.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0888eg() throws GeneralSecurityException {
        zzbkb.zza(new C0902fg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjm zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzblb zzi = zzblb.zzi(zzbpuVar);
            if (zzi instanceof zzblb) {
                zzbpd.zzs(zzi.getVersion(), 0);
                return new zzbok((zzbov) zzbkb.zzb("type.googleapis.com/google.crypto.tink.AesCtrKey", zzi.zzafx()), (zzbjx) zzbkb.zzb("type.googleapis.com/google.crypto.tink.HmacKey", zzi.zzafy()), zzi.zzafy().zzahw().zzaid());
            }
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzblb) {
            zzblb zzblbVar = (zzblb) zzbslVar;
            zzbpd.zzs(zzblbVar.getVersion(), 0);
            return new zzbok((zzbov) zzbkb.zzb("type.googleapis.com/google.crypto.tink.AesCtrKey", zzblbVar.zzafx()), (zzbjx) zzbkb.zzb("type.googleapis.com/google.crypto.tink.HmacKey", zzblbVar.zzafy()), zzblbVar.zzafy().zzahw().zzaid());
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzbld.zzj(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").zzai(((zzblb) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbld) {
            zzbld zzbldVar = (zzbld) zzbslVar;
            zzblf zzblfVar = (zzblf) zzbkb.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", zzbldVar.zzagb());
            return (zzbrd) zzblb.zzafz().zzb(zzblfVar).zzb((zzbmp) zzbkb.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzbldVar.zzagc())).zzdk(0).zzana();
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
    }
}
