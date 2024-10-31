package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzbmp;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.ads.sg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1082sg implements zzboa {

    /* renamed from: a, reason: collision with root package name */
    private final String f12522a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12523b;

    /* renamed from: c, reason: collision with root package name */
    private zzblr f12524c;

    /* renamed from: d, reason: collision with root package name */
    private zzblb f12525d;

    /* renamed from: e, reason: collision with root package name */
    private int f12526e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1082sg(zzbna zzbnaVar) throws GeneralSecurityException {
        this.f12522a = zzbnaVar.zzaig();
        if (this.f12522a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzblt zzt = zzblt.zzt(zzbnaVar.zzaih());
                this.f12524c = (zzblr) zzbkb.zzb(zzbnaVar);
                this.f12523b = zzt.getKeySize();
                return;
            } catch (zzbrl e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (this.f12522a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzbld zzj = zzbld.zzj(zzbnaVar.zzaih());
                this.f12525d = (zzblb) zzbkb.zzb(zzbnaVar);
                this.f12526e = zzj.zzagb().getKeySize();
                this.f12523b = this.f12526e + zzj.zzagc().getKeySize();
                return;
            } catch (zzbrl e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e3);
            }
        }
        String valueOf = String.valueOf(this.f12522a);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
    }

    @Override // com.google.android.gms.internal.ads.zzboa
    public final int zzafw() {
        return this.f12523b;
    }

    @Override // com.google.android.gms.internal.ads.zzboa
    public final zzbjm zzl(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == this.f12523b) {
            if (this.f12522a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                return (zzbjm) zzbkb.zzb(this.f12522a, (zzblr) zzblr.zzagu().zza((zzblr.zza) this.f12524c).zzs(zzbpu.zzi(bArr, 0, this.f12523b)).zzana());
            }
            if (this.f12522a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f12526e);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.f12526e, this.f12523b);
                zzblf zzblfVar = (zzblf) zzblf.zzagg().zza((zzblf.zza) this.f12525d.zzafx()).zzm(zzbpu.zzr(copyOfRange)).zzana();
                return (zzbjm) zzbkb.zzb(this.f12522a, (zzblb) zzblb.zzafz().zzdk(this.f12525d.getVersion()).zzb(zzblfVar).zzb((zzbmp) zzbmp.zzahx().zza((zzbmp.zza) this.f12525d.zzafy()).zzaf(zzbpu.zzr(copyOfRange2)).zzana()).zzana());
            }
            throw new GeneralSecurityException("unknown DEM key type");
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }
}
