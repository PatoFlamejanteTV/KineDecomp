package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpl;
import com.google.android.gms.internal.ads.zzbpm;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzbpl<MessageType extends zzbpl<MessageType, BuilderType>, BuilderType extends zzbpm<MessageType, BuilderType>> implements zzbsl {
    private static boolean zzfky = false;
    protected int zzfkx = 0;

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzamj()];
            zzbqk zzt = zzbqk.zzt(bArr);
            zzb(zzt);
            zzt.zzalv();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final zzbpu zzakf() {
        try {
            Ah zzen = zzbpu.zzen(zzamj());
            zzb(zzen.b());
            return zzen.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public int zzakg() {
        throw new UnsupportedOperationException();
    }

    public void zzei(int i) {
        throw new UnsupportedOperationException();
    }
}
