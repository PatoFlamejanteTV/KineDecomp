package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* renamed from: b */
    private boolean f11018b;

    /* renamed from: c */
    private ArrayList<Integer> f11019c;

    private final int a(int i) {
        if (i >= 0 && i < this.f11019c.size()) {
            return this.f11019c.get(i).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    private final void c() {
        synchronized (this) {
            if (!this.f11018b) {
                int count = this.f10989a.getCount();
                this.f11019c = new ArrayList<>();
                if (count > 0) {
                    this.f11019c.add(0);
                    String b2 = b();
                    String b3 = this.f10989a.b(b2, 0, this.f10989a.j(0));
                    for (int i = 1; i < count; i++) {
                        int j = this.f10989a.j(i);
                        String b4 = this.f10989a.b(b2, i, j);
                        if (b4 != null) {
                            if (!b4.equals(b3)) {
                                this.f11019c.add(Integer.valueOf(i));
                                b3 = b4;
                            }
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(b2);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(j);
                            throw new NullPointerException(sb.toString());
                        }
                    }
                }
                this.f11018b = true;
            }
        }
    }

    @KeepForSdk
    protected abstract T a(int i, int i2);

    @KeepForSdk
    protected String a() {
        return null;
    }

    @KeepForSdk
    protected abstract String b();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0063, code lost:            if (r6.f10989a.b(r4, r7, r3) == null) goto L40;     */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T get(int r7) {
        /*
            r6 = this;
            r6.c()
            int r0 = r6.a(r7)
            r1 = 0
            if (r7 < 0) goto L67
            java.util.ArrayList<java.lang.Integer> r2 = r6.f11019c
            int r2 = r2.size()
            if (r7 != r2) goto L13
            goto L67
        L13:
            java.util.ArrayList<java.lang.Integer> r2 = r6.f11019c
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            if (r7 != r2) goto L30
            com.google.android.gms.common.data.DataHolder r2 = r6.f10989a
            int r2 = r2.getCount()
            java.util.ArrayList<java.lang.Integer> r4 = r6.f11019c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            goto L4a
        L30:
            java.util.ArrayList<java.lang.Integer> r2 = r6.f11019c
            int r4 = r7 + 1
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.ArrayList<java.lang.Integer> r4 = r6.f11019c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
        L4a:
            int r2 = r2 - r4
            if (r2 != r3) goto L66
            int r7 = r6.a(r7)
            com.google.android.gms.common.data.DataHolder r3 = r6.f10989a
            int r3 = r3.j(r7)
            java.lang.String r4 = r6.a()
            if (r4 == 0) goto L66
            com.google.android.gms.common.data.DataHolder r5 = r6.f10989a
            java.lang.String r7 = r5.b(r4, r7, r3)
            if (r7 != 0) goto L66
            goto L67
        L66:
            r1 = r2
        L67:
            java.lang.Object r7 = r6.a(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.EntityBuffer.get(int):java.lang.Object");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        c();
        return this.f11019c.size();
    }
}
