package com.google.android.gms.common.data;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean b;
    private ArrayList<Integer> c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.b = false;
    }

    private void d() {
        synchronized (this) {
            if (!this.b) {
                int g = this.f982a.g();
                this.c = new ArrayList<>();
                if (g > 0) {
                    this.c.add(0);
                    String b = b();
                    String c = this.f982a.c(b, 0, this.f982a.a(0));
                    int i = 1;
                    while (i < g) {
                        int a2 = this.f982a.a(i);
                        String c2 = this.f982a.c(b, i, a2);
                        if (c2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + b + ", at row: " + i + ", for window: " + a2);
                        }
                        if (c2.equals(c)) {
                            c2 = c;
                        } else {
                            this.c.add(Integer.valueOf(i));
                        }
                        i++;
                        c = c2;
                    }
                }
                this.b = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int a() {
        d();
        return this.c.size();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final T a(int i) {
        d();
        return a(b(i), c(i));
    }

    protected abstract T a(int i, int i2);

    int b(int i) {
        if (i < 0 || i >= this.c.size()) {
            throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
        }
        return this.c.get(i).intValue();
    }

    protected abstract String b();

    protected int c(int i) {
        if (i < 0 || i == this.c.size()) {
            return 0;
        }
        int g = i == this.c.size() + (-1) ? this.f982a.g() - this.c.get(i).intValue() : this.c.get(i + 1).intValue() - this.c.get(i).intValue();
        if (g != 1) {
            return g;
        }
        int b = b(i);
        int a2 = this.f982a.a(b);
        String c = c();
        if (c == null || this.f982a.c(c, b, a2) != null) {
            return g;
        }
        return 0;
    }

    protected String c() {
        return null;
    }
}
