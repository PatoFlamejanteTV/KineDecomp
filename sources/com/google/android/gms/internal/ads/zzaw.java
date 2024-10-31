package com.google.android.gms.internal.ads;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class zzaw extends zzr<String> {
    private final Object mLock;
    private zzz<String> zzcl;

    public zzaw(int i, String str, zzz<String> zzzVar, zzy zzyVar) {
        super(i, str, zzyVar);
        this.mLock = new Object();
        this.zzcl = zzzVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    public final zzx<String> zza(zzp zzpVar) {
        String str;
        try {
            byte[] bArr = zzpVar.data;
            String str2 = "ISO-8859-1";
            String str3 = zzpVar.zzab.get(HttpHeaders.CONTENT_TYPE);
            if (str3 != null) {
                String[] split = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str2 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzpVar.data);
        }
        return zzx.zza(str, zzap.zzb(zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public void zza(String str) {
        zzz<String> zzzVar;
        synchronized (this.mLock) {
            zzzVar = this.zzcl;
        }
        if (zzzVar != null) {
            zzzVar.zzb(str);
        }
    }
}
