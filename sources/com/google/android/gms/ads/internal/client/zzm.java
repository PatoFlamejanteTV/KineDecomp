package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzv;
import java.util.Random;

/* loaded from: classes.dex */
public class zzm extends zzv.zza {
    private long b;
    private Object c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Random f546a = new Random();

    public zzm() {
        a();
    }

    public void a() {
        synchronized (this.c) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = this.f546a.nextInt() + 2147483648L;
                if (j != this.b && j != 0) {
                    break;
                }
            }
            this.b = j;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzv
    public long b() {
        return this.b;
    }
}
