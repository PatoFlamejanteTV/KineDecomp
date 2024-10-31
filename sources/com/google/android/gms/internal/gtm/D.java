package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    private int f13136a;

    /* renamed from: b, reason: collision with root package name */
    private ByteArrayOutputStream f13137b = new ByteArrayOutputStream();

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ C f13138c;

    public D(C c2) {
        this.f13138c = c2;
    }

    public final boolean a(zzcd zzcdVar) {
        byte[] bArr;
        Preconditions.a(zzcdVar);
        if (this.f13136a + 1 > zzbq.zzes()) {
            return false;
        }
        String a2 = this.f13138c.a(zzcdVar, false);
        if (a2 == null) {
            this.f13138c.zzco().zza(zzcdVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a2.getBytes();
        int length = bytes.length;
        if (length > zzbq.zzeo()) {
            this.f13138c.zzco().zza(zzcdVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.f13137b.size() > 0) {
            length++;
        }
        if (this.f13137b.size() + length > zzby.zzzz.get().intValue()) {
            return false;
        }
        try {
            if (this.f13137b.size() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = this.f13137b;
                bArr = C.f13131a;
                byteArrayOutputStream.write(bArr);
            }
            this.f13137b.write(bytes);
            this.f13136a++;
            return true;
        } catch (IOException e2) {
            this.f13138c.zze("Failed to write payload when batching hits", e2);
            return true;
        }
    }

    public final int b() {
        return this.f13136a;
    }

    public final byte[] a() {
        return this.f13137b.toByteArray();
    }
}
