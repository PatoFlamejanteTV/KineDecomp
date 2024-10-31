package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.oa */
/* loaded from: classes2.dex */
final class C1216oa {

    /* renamed from: a */
    private final String f12872a;

    /* renamed from: b */
    private int f12873b = 0;

    public C1216oa(String str) {
        this.f12872a = str;
    }

    public final boolean a() {
        return this.f12873b < this.f12872a.length();
    }

    public final int b() {
        String str = this.f12872a;
        int i = this.f12873b;
        this.f12873b = i + 1;
        char charAt = str.charAt(i);
        if (charAt < 55296) {
            return charAt;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.f12872a;
            int i4 = this.f12873b;
            this.f12873b = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 < 55296) {
                return i2 | (charAt2 << i3);
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}
