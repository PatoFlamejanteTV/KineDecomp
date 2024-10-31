package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;
import java.lang.reflect.Field;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.clearcut.na, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1214na {
    private int A;
    private int B;
    private Field C;
    private Object D;
    private Object E;
    private Object F;

    /* renamed from: a, reason: collision with root package name */
    private final C1216oa f12860a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f12861b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f12862c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12863d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12864e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12865f;

    /* renamed from: g, reason: collision with root package name */
    private final int f12866g;

    /* renamed from: h, reason: collision with root package name */
    private final int f12867h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int[] n;
    private int o;
    private int p;
    private int q = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int r = Integer.MIN_VALUE;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1214na(Class<?> cls, String str, Object[] objArr) {
        this.f12862c = cls;
        this.f12860a = new C1216oa(str);
        this.f12861b = objArr;
        this.f12863d = this.f12860a.b();
        this.f12864e = this.f12860a.b();
        if (this.f12864e == 0) {
            this.f12865f = 0;
            this.f12866g = 0;
            this.f12867h = 0;
            this.i = 0;
            this.j = 0;
            this.l = 0;
            this.k = 0;
            this.m = 0;
            this.n = null;
            return;
        }
        this.f12865f = this.f12860a.b();
        this.f12866g = this.f12860a.b();
        this.f12867h = this.f12860a.b();
        this.i = this.f12860a.b();
        this.l = this.f12860a.b();
        this.k = this.f12860a.b();
        this.j = this.f12860a.b();
        this.m = this.f12860a.b();
        int b2 = this.f12860a.b();
        this.n = b2 != 0 ? new int[b2] : null;
        this.o = (this.f12865f << 1) + this.f12866g;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final Object p() {
        Object[] objArr = this.f12861b;
        int i = this.o;
        this.o = i + 1;
        return objArr[i];
    }

    private final boolean q() {
        return (this.f12863d & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d0, code lost:            if (q() != false) goto L40;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d2, code lost:            r5.E = p();     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015e, code lost:            if (((r5.y & 2048) != 0) != false) goto L40;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0165, code lost:            if (q() != false) goto L40;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1214na.a():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return this.z > zzcb.MAP.id();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field e() {
        int i = this.A << 1;
        Object obj = this.f12861b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field a2 = a(this.f12862c, (String) obj);
        this.f12861b[i] = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field f() {
        int i = (this.A << 1) + 1;
        Object obj = this.f12861b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field a2 = a(this.f12862c, (String) obj);
        this.f12861b[i] = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field g() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h() {
        return q() && this.z <= zzcb.GROUP.id();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field i() {
        int i = (this.f12865f << 1) + (this.B / 32);
        Object obj = this.f12861b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field a2 = a(this.f12862c, (String) obj);
        this.f12861b[i] = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int j() {
        return this.B % 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return (this.y & 256) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l() {
        return (this.y & 512) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object m() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object n() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object o() {
        return this.F;
    }
}
