package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.ul */
/* loaded from: classes2.dex */
final class C1115ul {

    /* renamed from: a */
    private final zzhz[] f12592a;

    /* renamed from: b */
    private final zzib f12593b;

    /* renamed from: c */
    private zzhz f12594c;

    public C1115ul(zzhz[] zzhzVarArr, zzib zzibVar) {
        this.f12592a = zzhzVarArr;
        this.f12593b = zzibVar;
    }

    public final zzhz a(zzia zziaVar, Uri uri) throws IOException, InterruptedException {
        zzhz zzhzVar = this.f12594c;
        if (zzhzVar != null) {
            return zzhzVar;
        }
        zzhz[] zzhzVarArr = this.f12592a;
        int length = zzhzVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzhz zzhzVar2 = zzhzVarArr[i];
            try {
            } catch (EOFException unused) {
            } finally {
                zziaVar.zzdx();
            }
            if (zzhzVar2.zza(zziaVar)) {
                this.f12594c = zzhzVar2;
                break;
            }
            i++;
        }
        zzhz zzhzVar3 = this.f12594c;
        if (zzhzVar3 != null) {
            zzhzVar3.zza(this.f12593b);
            return this.f12594c;
        }
        String zza = zzqe.zza(this.f12592a);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zzmb(sb.toString(), uri);
    }

    public final void a() {
        zzhz zzhzVar = this.f12594c;
        if (zzhzVar != null) {
            zzhzVar.release();
            this.f12594c = null;
        }
    }
}
