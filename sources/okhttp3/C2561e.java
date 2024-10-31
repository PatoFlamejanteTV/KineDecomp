package okhttp3;

import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl.java */
/* renamed from: okhttp3.e */
/* loaded from: classes3.dex */
public final class C2561e {

    /* renamed from: a */
    public static final C2561e f28967a;

    /* renamed from: b */
    public static final C2561e f28968b;

    /* renamed from: c */
    private final boolean f28969c;

    /* renamed from: d */
    private final boolean f28970d;

    /* renamed from: e */
    private final int f28971e;

    /* renamed from: f */
    private final int f28972f;

    /* renamed from: g */
    private final boolean f28973g;

    /* renamed from: h */
    private final boolean f28974h;
    private final boolean i;
    private final int j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final boolean n;

    @Nullable
    String o;

    static {
        a aVar = new a();
        aVar.b();
        f28967a = aVar.a();
        a aVar2 = new a();
        aVar2.c();
        aVar2.a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS);
        f28968b = aVar2.a();
    }

    private C2561e(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f28969c = z;
        this.f28970d = z2;
        this.f28971e = i;
        this.f28972f = i2;
        this.f28973g = z3;
        this.f28974h = z4;
        this.i = z5;
        this.j = i3;
        this.k = i4;
        this.l = z6;
        this.m = z7;
        this.n = z8;
        this.o = str;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f28969c) {
            sb.append("no-cache, ");
        }
        if (this.f28970d) {
            sb.append("no-store, ");
        }
        if (this.f28971e != -1) {
            sb.append("max-age=");
            sb.append(this.f28971e);
            sb.append(", ");
        }
        if (this.f28972f != -1) {
            sb.append("s-maxage=");
            sb.append(this.f28972f);
            sb.append(", ");
        }
        if (this.f28973g) {
            sb.append("private, ");
        }
        if (this.f28974h) {
            sb.append("public, ");
        }
        if (this.i) {
            sb.append("must-revalidate, ");
        }
        if (this.j != -1) {
            sb.append("max-stale=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k != -1) {
            sb.append("min-fresh=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l) {
            sb.append("only-if-cached, ");
        }
        if (this.m) {
            sb.append("no-transform, ");
        }
        if (this.n) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f28973g;
    }

    public boolean b() {
        return this.f28974h;
    }

    public int c() {
        return this.f28971e;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public boolean f() {
        return this.i;
    }

    public boolean g() {
        return this.f28969c;
    }

    public boolean h() {
        return this.f28970d;
    }

    public boolean i() {
        return this.l;
    }

    public String toString() {
        String str = this.o;
        if (str != null) {
            return str;
        }
        String j = j();
        this.o = j;
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okhttp3.C2561e a(okhttp3.z r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C2561e.a(okhttp3.z):okhttp3.e");
    }

    /* compiled from: CacheControl.java */
    /* renamed from: okhttp3.e$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        boolean f28975a;

        /* renamed from: b */
        boolean f28976b;

        /* renamed from: c */
        int f28977c = -1;

        /* renamed from: d */
        int f28978d = -1;

        /* renamed from: e */
        int f28979e = -1;

        /* renamed from: f */
        boolean f28980f;

        /* renamed from: g */
        boolean f28981g;

        /* renamed from: h */
        boolean f28982h;

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f28978d = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a b() {
            this.f28975a = true;
            return this;
        }

        public a c() {
            this.f28980f = true;
            return this;
        }

        public C2561e a() {
            return new C2561e(this);
        }
    }

    C2561e(a aVar) {
        this.f28969c = aVar.f28975a;
        this.f28970d = aVar.f28976b;
        this.f28971e = aVar.f28977c;
        this.f28972f = -1;
        this.f28973g = false;
        this.f28974h = false;
        this.i = false;
        this.j = aVar.f28978d;
        this.k = aVar.f28979e;
        this.l = aVar.f28980f;
        this.m = aVar.f28981g;
        this.n = aVar.f28982h;
    }
}
