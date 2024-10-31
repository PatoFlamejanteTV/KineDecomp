package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.ads.tg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1096tg implements zzbjt<zzbjx> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzbjt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbjx zza(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            zzbmp zzae = zzbmp.zzae(zzbpuVar);
            if (zzae instanceof zzbmp) {
                zzbpd.zzs(zzae.getVersion(), 0);
                if (zzae.zzagf().size() >= 16) {
                    a(zzae.zzahw());
                    zzbmn zzaic = zzae.zzahw().zzaic();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(zzae.zzagf().toByteArray(), "HMAC");
                    int zzaid = zzae.zzahw().zzaid();
                    int i = C1110ug.f12580a[zzaic.ordinal()];
                    if (i == 1) {
                        return new zzbow("HMACSHA1", secretKeySpec, zzaid);
                    }
                    if (i == 2) {
                        return new zzbow("HMACSHA256", secretKeySpec, zzaid);
                    }
                    if (i == 3) {
                        return new zzbow("HMACSHA512", secretKeySpec, zzaid);
                    }
                    throw new GeneralSecurityException("unknown hash");
                }
                throw new GeneralSecurityException("key too short");
            }
            throw new GeneralSecurityException("expected HmacKey proto");
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjx zza(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbmp) {
            zzbmp zzbmpVar = (zzbmp) zzbslVar;
            zzbpd.zzs(zzbmpVar.getVersion(), 0);
            if (zzbmpVar.zzagf().size() >= 16) {
                a(zzbmpVar.zzahw());
                zzbmn zzaic = zzbmpVar.zzahw().zzaic();
                SecretKeySpec secretKeySpec = new SecretKeySpec(zzbmpVar.zzagf().toByteArray(), "HMAC");
                int zzaid = zzbmpVar.zzahw().zzaid();
                int i = C1110ug.f12580a[zzaic.ordinal()];
                if (i == 1) {
                    return new zzbow("HMACSHA1", secretKeySpec, zzaid);
                }
                if (i == 2) {
                    return new zzbow("HMACSHA256", secretKeySpec, zzaid);
                }
                if (i == 3) {
                    return new zzbow("HMACSHA512", secretKeySpec, zzaid);
                }
                throw new GeneralSecurityException("unknown hash");
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpuVar) throws GeneralSecurityException {
        try {
            return zzb(zzbmr.zzag(zzbpuVar));
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpuVar) throws GeneralSecurityException {
        return (zzbmv) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.HmacKey").zzai(((zzbmp) zzb(zzbpuVar)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbslVar) throws GeneralSecurityException {
        if (zzbslVar instanceof zzbmr) {
            zzbmr zzbmrVar = (zzbmr) zzbslVar;
            if (zzbmrVar.getKeySize() >= 16) {
                a(zzbmrVar.zzahw());
                return (zzbrd) zzbmp.zzahx().zzdu(0).zzc(zzbmrVar.zzahw()).zzaf(zzbpu.zzr(zzboy.zzeg(zzbmrVar.getKeySize()))).zzana();
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    private static void a(zzbmt zzbmtVar) throws GeneralSecurityException {
        if (zzbmtVar.zzaid() >= 10) {
            int i = C1110ug.f12580a[zzbmtVar.zzaic().ordinal()];
            if (i == 1) {
                if (zzbmtVar.zzaid() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else if (i == 2) {
                if (zzbmtVar.zzaid() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else {
                if (i == 3) {
                    if (zzbmtVar.zzaid() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                }
                throw new GeneralSecurityException("unknown hash type");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }
}
