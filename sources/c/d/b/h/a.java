package c.d.b.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.PointerIconCompat;
import android.util.SparseArray;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Sticker.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f3799a = 30;

    /* renamed from: b, reason: collision with root package name */
    private static double f3800b;

    /* renamed from: c, reason: collision with root package name */
    private static List<? extends a> f3801c;

    /* renamed from: d, reason: collision with root package name */
    private static SparseArray<a> f3802d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f3803e;

    /* renamed from: f, reason: collision with root package name */
    private int f3804f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f3805g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f3806h = -1;
    private SparseArray<WeakReference<Drawable>> i = new SparseArray<>();
    private SparseArray<WeakReference<Bitmap>> j = new SparseArray<>();

    /* compiled from: Sticker.java */
    /* renamed from: c.d.b.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0017a extends a {
        private final int[] k;
        private final int l;
        private final int m;

        C0017a(int i, int i2, int i3, int... iArr) {
            super(i);
            this.l = i2;
            this.k = iArr;
            this.m = (i2 * i3) / iArr.length;
        }

        @Override // c.d.b.h.a
        protected void a(Context context) {
            Drawable drawable = context.getResources().getDrawable(this.k[0]);
            a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        @Override // c.d.b.h.a
        public int c(Context context) {
            return this.l;
        }

        @Override // c.d.b.h.a
        protected int d() {
            return this.m;
        }

        @Override // c.d.b.h.a
        protected Bitmap d(Context context) {
            return null;
        }

        @Override // c.d.b.h.a
        protected Drawable e(Context context) {
            int g2 = (g() * this.k.length) / this.l;
            if (g2 < 0) {
                g2 = 0;
            }
            int[] iArr = this.k;
            if (g2 > iArr.length - 1) {
                g2 = iArr.length - 1;
            }
            return context.getResources().getDrawable(this.k[g2]);
        }

        @Override // c.d.b.h.a
        public boolean h() {
            return true;
        }

        @Override // c.d.b.h.a
        public boolean i() {
            return false;
        }
    }

    static {
        double d2 = f3799a;
        Double.isNaN(d2);
        f3800b = 1000.0d / d2;
        f3801c = Collections.unmodifiableList(Arrays.asList(new C0017a(100014, SemanticAnnotations.SemanticType.ST_NETWORK_ENDPOINT_VALUE, 0, R.drawable.dog01, R.drawable.dog02, R.drawable.dog03, R.drawable.dog04, R.drawable.dog05, R.drawable.dog06, R.drawable.dog07, R.drawable.dog08, R.drawable.dog09, R.drawable.dog08, R.drawable.dog07, R.drawable.dog06, R.drawable.dog05, R.drawable.dog04, R.drawable.dog03, R.drawable.dog02), new C0017a(100017, SemanticAnnotations.SemanticType.ST_NETWORK_ENDPOINT_VALUE, 7, R.drawable.sticker_test_goodday08, R.drawable.sticker_test_goodday07, R.drawable.sticker_test_goodday06, R.drawable.sticker_test_goodday05, R.drawable.sticker_test_goodday04, R.drawable.sticker_test_goodday03, R.drawable.sticker_test_goodday02, R.drawable.sticker_test_goodday01), new C0017a(100018, 5000, 10, R.drawable.sticker_test_flower0000, R.drawable.sticker_test_flower0001, R.drawable.sticker_test_flower0002, R.drawable.sticker_test_flower0003, R.drawable.sticker_test_flower0004, R.drawable.sticker_test_flower0005, R.drawable.sticker_test_flower0006, R.drawable.sticker_test_flower0007, R.drawable.sticker_test_flower0008, R.drawable.sticker_test_flower0009, R.drawable.sticker_test_flower0010, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0012, R.drawable.sticker_test_flower0013, R.drawable.sticker_test_flower0014, R.drawable.sticker_test_flower0015, R.drawable.sticker_test_flower0014, R.drawable.sticker_test_flower0013, R.drawable.sticker_test_flower0012, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0010, R.drawable.sticker_test_flower0009, R.drawable.sticker_test_flower0008, R.drawable.sticker_test_flower0007, R.drawable.sticker_test_flower0006, R.drawable.sticker_test_flower0005, R.drawable.sticker_test_flower0004, R.drawable.sticker_test_flower0003, R.drawable.sticker_test_flower0002, R.drawable.sticker_test_flower0001), new b(1000, R.raw.sticker_alien), new b(1001, R.raw.sticker_emoticon_01), new b(1002, R.raw.sticker_emoticon_angry), new b(1003, R.raw.sticker_emoticon_cool), new b(1004, R.raw.sticker_emoticon_happy), new b(SemanticAnnotations.SemanticType.ST_MANDELBREAD_ID_VALUE, R.raw.sticker_jester), new b(1006, R.raw.sticker_emoticon_missingteeth), new b(1007, R.raw.sticker_emoticon_ninja), new b(1008, R.raw.sticker_emoticon_sad), new b(PointerIconCompat.TYPE_VERTICAL_TEXT, R.raw.sticker_emoticon_wink), new b(1011, R.raw.sticker_boquet), new b(PointerIconCompat.TYPE_NO_DROP, R.raw.sticker_bow), new b(PointerIconCompat.TYPE_ALL_SCROLL, R.raw.sticker_burger), new b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, R.raw.sticker_cake), new b(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, R.raw.sticker_candy), new b(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, R.raw.sticker_crown), new b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, R.raw.sticker_hourglass), new b(PointerIconCompat.TYPE_ZOOM_IN, R.raw.sticker_ice_cream), new b(PointerIconCompat.TYPE_ZOOM_OUT, R.raw.sticker_lolipop), new b(PointerIconCompat.TYPE_GRAB, R.raw.sticker_mushroom), new b(PointerIconCompat.TYPE_GRABBING, R.raw.sticker_pencil), new b(1022, R.raw.sticker_present), new b(1023, R.raw.sticker_tie), new b(1024, R.raw.sticker_eightieswig), new b(InputDeviceCompat.SOURCE_GAMEPAD, R.raw.sticker_feathermask), new b(1026, R.raw.sticker_gardenhat), new b(1027, R.raw.sticker_blondewig), new b(1028, R.raw.sticker_santahat), new b(1029, R.raw.sticker_partyhat), new b(1030, R.raw.sticker_fork), new b(1031, R.raw.sticker_knife), new b(1032, R.raw.sticker_spoon), new b(1033, R.raw.sticker_egg), new b(1034, R.raw.sticker_cupcake), new b(1035, R.raw.sticker_croissant), new b(1036, R.raw.sticker_donut), new b(1037, R.raw.sticker_coffee), new b(1038, R.raw.sticker_bowler), new b(1039, R.raw.sticker_mustache), new b(1040, R.raw.sticker_tree), new b(1041, R.raw.sticker_basketball), new b(1042, R.raw.sticker_bowling), new b(1043, R.raw.sticker_football), new b(1044, R.raw.sticker_lightning), new b(1045, R.raw.sticker_moon), new b(1046, R.raw.sticker_rainy), new b(1047, R.raw.sticker_snowy), new b(1048, R.raw.sticker_soccer), new b(1049, R.raw.sticker_sun), new b(1050, R.raw.sticker_windy), new b(1051, R.raw.sticker_circle, true), new b(1052, R.raw.sticker_musical_note, true), new b(1053, R.raw.sticker_heart, true), new b(1054, R.raw.sticker_narrowbox, true), new b(1055, R.raw.sticker_square, true), new b(1056, R.raw.sticker_star, true), new b(1057, R.raw.sticker_tie_c, true), new b(1058, R.raw.sticker_teardrop, true)));
        f3802d = null;
    }

    protected a(int i) {
        this.f3803e = i;
    }

    public static a a(int i) {
        if (f3802d == null) {
            f3802d = new SparseArray<>();
            for (a aVar : f()) {
                if (f3802d.get(aVar.f3803e) == null) {
                    f3802d.put(aVar.f3803e, aVar);
                } else {
                    throw new IllegalStateException("Duplicate sticker IDs");
                }
            }
        }
        return f3802d.get(i);
    }

    public static List<? extends a> f() {
        return f3801c;
    }

    public void a() {
    }

    protected abstract void a(Context context);

    public int b() {
        if (this.f3805g < 0 || this.f3806h < 0) {
            a(KineMasterApplication.f24056d);
            if (this.f3805g < 0 || this.f3806h < 0) {
                throw new IllegalStateException("calcIntrinsicSize didn't call setIntrinsicSize for: " + getClass().getSimpleName());
            }
        }
        return this.f3806h;
    }

    public int c() {
        if (this.f3805g < 0 || this.f3806h < 0) {
            a(KineMasterApplication.f24056d);
            if (this.f3805g < 0 || this.f3806h < 0) {
                throw new IllegalStateException("calcIntrinsicSize didn't call setIntrinsicSize for: " + getClass().getSimpleName());
            }
        }
        return this.f3805g;
    }

    public int c(Context context) {
        return 0;
    }

    protected int d() {
        return 0;
    }

    protected abstract Bitmap d(Context context);

    public int e() {
        return this.f3803e;
    }

    protected abstract Drawable e(Context context);

    public int g() {
        return this.f3804f;
    }

    public boolean h() {
        return false;
    }

    public abstract boolean i();

    /* compiled from: Sticker.java */
    /* loaded from: classes.dex */
    private static class b extends a {
        private final int k;
        private final boolean l;

        b(int i, int i2) {
            super(i);
            this.k = i2;
            this.l = false;
        }

        @Override // c.d.b.h.a
        protected void a(Context context) {
            Drawable b2 = b(context);
            a(b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
        }

        @Override // c.d.b.h.a
        protected Bitmap d(Context context) {
            return null;
        }

        @Override // c.d.b.h.a
        protected Drawable e(Context context) {
            return c.d.a.a.a.a.a(context.getResources(), this.k);
        }

        @Override // c.d.b.h.a
        public boolean i() {
            return true;
        }

        b(int i, int i2, boolean z) {
            super(i);
            this.k = i2;
            this.l = z;
        }
    }

    public final Drawable b(Context context) {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.i.get(this.f3804f);
        if (weakReference != null && (drawable = weakReference.get()) != null) {
            return drawable;
        }
        Drawable e2 = e(context);
        if (e2 == null) {
            return null;
        }
        this.i.put(this.f3804f, new WeakReference<>(e2));
        return e2;
    }

    public void a(Context context, int i) {
        if (h()) {
            double d2 = i;
            double d3 = f3800b;
            Double.isNaN(d2);
            int c2 = c(context);
            double d4 = (int) ((d2 + (d3 / 2.0d)) / d3);
            double d5 = f3800b;
            Double.isNaN(d4);
            this.f3804f = Math.max(0, Math.min(c2, (int) (d4 * d5)));
        }
    }

    public final Bitmap a(Context context, int i, int i2) {
        Bitmap a2;
        int i3 = this.f3804f;
        this.f3804f = d();
        if (i()) {
            a2 = a(context, Math.min(i / c(), i2 / b()));
        } else {
            a2 = a(context, 1.0f);
        }
        this.f3804f = i3;
        return a2;
    }

    protected final void a(int i, int i2) {
        if (i <= 0) {
            i = 480;
        }
        if (i2 <= 0) {
            i2 = 480;
        }
        this.f3805g = i;
        this.f3806h = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:            if ((java.lang.Math.max(((int) (c() * r7)) - r0.getWidth(), 0) + java.lang.Math.max(((int) (b() * r7)) - r0.getHeight(), 0)) < 10) goto L10;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap a(android.content.Context r6, float r7) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.h.a.a(android.content.Context, float):android.graphics.Bitmap");
    }
}
