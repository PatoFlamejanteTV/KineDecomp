package com.android.volley.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    protected static final Comparator<byte[]> f7993a = new c();

    /* renamed from: b */
    private final List<byte[]> f7994b = new LinkedList();

    /* renamed from: c */
    private final List<byte[]> f7995c = new ArrayList(64);

    /* renamed from: d */
    private int f7996d = 0;

    /* renamed from: e */
    private final int f7997e;

    public d(int i) {
        this.f7997e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f7995c.size(); i2++) {
            byte[] bArr = this.f7995c.get(i2);
            if (bArr.length >= i) {
                this.f7996d -= bArr.length;
                this.f7995c.remove(i2);
                this.f7994b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f7997e) {
                this.f7994b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f7995c, bArr, f7993a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f7995c.add(binarySearch, bArr);
                this.f7996d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f7996d > this.f7997e) {
            byte[] remove = this.f7994b.remove(0);
            this.f7995c.remove(remove);
            this.f7996d -= remove.length;
        }
    }
}
