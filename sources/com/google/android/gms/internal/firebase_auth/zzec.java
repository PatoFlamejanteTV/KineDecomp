package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhc;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class zzec<MessageType extends zzhc> implements zzhm<MessageType> {
    private static final zzfg zzsj = zzfg.zzgq();

    private final MessageType zza(InputStream inputStream, zzfg zzfgVar) throws zzgc {
        zzet c1268p;
        if (inputStream == null) {
            byte[] bArr = zzfv.EMPTY_BYTE_ARRAY;
            c1268p = zzet.zza(bArr, 0, bArr.length, false);
        } else {
            c1268p = new C1268p(inputStream);
        }
        MessageType messagetype = (MessageType) zza(c1268p, zzfgVar);
        try {
            c1268p.zzn(0);
            return messagetype;
        } catch (zzgc e2) {
            throw e2.zzh(messagetype);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhm
    public final /* synthetic */ Object zzb(InputStream inputStream, zzfg zzfgVar) throws zzgc {
        zzip zzipVar;
        MessageType zza = zza(inputStream, zzfgVar);
        if (zza == null || zza.isInitialized()) {
            return zza;
        }
        if (!(zza instanceof zzdz)) {
            if (zza instanceof zzeb) {
                zzipVar = new zzip((zzeb) zza);
            } else {
                zzipVar = new zzip(zza);
            }
        } else {
            zzipVar = new zzip((zzdz) zza);
        }
        throw new zzgc(zzipVar.getMessage()).zzh(zza);
    }
}
