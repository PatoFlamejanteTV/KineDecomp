package com.nexstreaming.kinemaster.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Sticker.java */
/* loaded from: classes.dex */
public abstract class a {
    private static int b = 30;
    private static double c = 1000.0d / b;
    private static List<? extends a> i = Collections.unmodifiableList(Arrays.asList(new C0067a(100014, 1300, 0, R.drawable.dog01, R.drawable.dog02, R.drawable.dog03, R.drawable.dog04, R.drawable.dog05, R.drawable.dog06, R.drawable.dog07, R.drawable.dog08, R.drawable.dog09, R.drawable.dog08, R.drawable.dog07, R.drawable.dog06, R.drawable.dog05, R.drawable.dog04, R.drawable.dog03, R.drawable.dog02), new C0067a(100017, 1300, 7, R.drawable.sticker_test_goodday08, R.drawable.sticker_test_goodday07, R.drawable.sticker_test_goodday06, R.drawable.sticker_test_goodday05, R.drawable.sticker_test_goodday04, R.drawable.sticker_test_goodday03, R.drawable.sticker_test_goodday02, R.drawable.sticker_test_goodday01), new C0067a(100018, 5000, 10, R.drawable.sticker_test_flower0000, R.drawable.sticker_test_flower0001, R.drawable.sticker_test_flower0002, R.drawable.sticker_test_flower0003, R.drawable.sticker_test_flower0004, R.drawable.sticker_test_flower0005, R.drawable.sticker_test_flower0006, R.drawable.sticker_test_flower0007, R.drawable.sticker_test_flower0008, R.drawable.sticker_test_flower0009, R.drawable.sticker_test_flower0010, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011b, R.drawable.sticker_test_flower0011a, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0012, R.drawable.sticker_test_flower0013, R.drawable.sticker_test_flower0014, R.drawable.sticker_test_flower0015, R.drawable.sticker_test_flower0014, R.drawable.sticker_test_flower0013, R.drawable.sticker_test_flower0012, R.drawable.sticker_test_flower0011, R.drawable.sticker_test_flower0010, R.drawable.sticker_test_flower0009, R.drawable.sticker_test_flower0008, R.drawable.sticker_test_flower0007, R.drawable.sticker_test_flower0006, R.drawable.sticker_test_flower0005, R.drawable.sticker_test_flower0004, R.drawable.sticker_test_flower0003, R.drawable.sticker_test_flower0002, R.drawable.sticker_test_flower0001), new b(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, R.raw.sticker_alien), new b(1001, R.raw.sticker_emoticon_01), new b(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, R.raw.sticker_emoticon_angry), new b(1003, R.raw.sticker_emoticon_cool), new b(1004, R.raw.sticker_emoticon_happy), new b(1005, R.raw.sticker_jester), new b(1006, R.raw.sticker_emoticon_missingteeth), new b(1007, R.raw.sticker_emoticon_ninja), new b(1008, R.raw.sticker_emoticon_sad), new b(1009, R.raw.sticker_emoticon_wink), new b(1011, R.raw.sticker_boquet), new b(1012, R.raw.sticker_bow), new b(1013, R.raw.sticker_burger), new b(1014, R.raw.sticker_cake), new b(1015, R.raw.sticker_candy), new b(1016, R.raw.sticker_crown), new b(1017, R.raw.sticker_hourglass), new b(1018, R.raw.sticker_ice_cream), new b(1019, R.raw.sticker_lolipop), new b(1020, R.raw.sticker_mushroom), new b(1021, R.raw.sticker_pencil), new b(1022, R.raw.sticker_present), new b(1023, R.raw.sticker_tie), new b(1024, R.raw.sticker_eightieswig), new b(1025, R.raw.sticker_feathermask), new b(1026, R.raw.sticker_gardenhat), new b(1027, R.raw.sticker_blondewig), new b(1028, R.raw.sticker_santahat), new b(1029, R.raw.sticker_partyhat), new b(1030, R.raw.sticker_fork), new b(1031, R.raw.sticker_knife), new b(1032, R.raw.sticker_spoon), new b(1033, R.raw.sticker_egg), new b(1034, R.raw.sticker_cupcake), new b(1035, R.raw.sticker_croissant), new b(1036, R.raw.sticker_donut), new b(1037, R.raw.sticker_coffee), new b(1038, R.raw.sticker_bowler), new b(1039, R.raw.sticker_mustache), new b(1040, R.raw.sticker_tree), new b(1041, R.raw.sticker_basketball), new b(1042, R.raw.sticker_bowling), new b(1043, R.raw.sticker_football), new b(1044, R.raw.sticker_lightning), new b(1045, R.raw.sticker_moon), new b(1046, R.raw.sticker_rainy), new b(1047, R.raw.sticker_snowy), new b(1048, R.raw.sticker_soccer), new b(1049, R.raw.sticker_sun), new b(1050, R.raw.sticker_windy), new b(1051, R.raw.sticker_circle, true), new b(1052, R.raw.sticker_musical_note, true), new b(1053, R.raw.sticker_heart, true), new b(1054, R.raw.sticker_narrowbox, true), new b(1055, R.raw.sticker_square, true), new b(1056, R.raw.sticker_star, true), new b(1057, R.raw.sticker_tie_c, true), new b(1058, R.raw.sticker_teardrop, true)));
    private static SparseArray<a> j = null;

    /* renamed from: a, reason: collision with root package name */
    protected final int f3295a;
    private int d = 0;
    private int e = -1;
    private int f = -1;
    private SparseArray<WeakReference<Drawable>> g = new SparseArray<>();
    private SparseArray<WeakReference<Bitmap>> h = new SparseArray<>();

    protected abstract void b(Context context);

    protected abstract Drawable d(Context context);

    protected abstract Bitmap e(Context context);

    public abstract String f(Context context);

    public abstract boolean h();

    protected a(int i2) {
        this.f3295a = i2;
    }

    public static a a(int i2) {
        if (j == null) {
            j = new SparseArray<>();
            for (a aVar : b()) {
                if (j.get(aVar.f3295a) != null) {
                    throw new IllegalStateException("Duplicate sticker IDs");
                }
                j.put(aVar.f3295a, aVar);
            }
        }
        return j.get(i2);
    }

    public int a() {
        return this.f3295a;
    }

    public static List<? extends a> b() {
        return i;
    }

    /* compiled from: Sticker.java */
    /* renamed from: com.nexstreaming.kinemaster.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0067a extends a {
        private final int[] b;
        private final int c;
        private final int d;

        C0067a(int i, int i2, int i3, int... iArr) {
            super(i);
            this.c = i2;
            this.b = iArr;
            this.d = (i2 * i3) / iArr.length;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected Drawable d(Context context) {
            int d = (d() * this.b.length) / this.c;
            if (d < 0) {
                d = 0;
            }
            if (d > this.b.length - 1) {
                d = this.b.length - 1;
            }
            return context.getResources().getDrawable(this.b[d]);
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected Bitmap e(Context context) {
            return null;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        public boolean c() {
            return true;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        public int a(Context context) {
            return this.c;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected int g() {
            return this.d;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected void b(Context context) {
            Drawable drawable = context.getResources().getDrawable(this.b[0]);
            a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        @Override // com.nexstreaming.kinemaster.e.a
        public String f(Context context) {
            return context.getResources().getResourceEntryName(this.b[0]);
        }

        @Override // com.nexstreaming.kinemaster.e.a
        public boolean h() {
            return false;
        }
    }

    /* compiled from: Sticker.java */
    /* loaded from: classes.dex */
    private static class b extends a {
        private final int b;
        private final boolean c;

        b(int i, int i2) {
            super(i);
            this.b = i2;
            this.c = false;
        }

        b(int i, int i2, boolean z) {
            super(i);
            this.b = i2;
            this.c = z;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected void b(Context context) {
            Drawable c = c(context);
            a(c.getIntrinsicWidth(), c.getIntrinsicHeight());
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected Drawable d(Context context) {
            return com.nexstreaming.app.general.a.a.a(context.getResources(), this.b);
        }

        @Override // com.nexstreaming.kinemaster.e.a
        protected Bitmap e(Context context) {
            return null;
        }

        @Override // com.nexstreaming.kinemaster.e.a
        public String f(Context context) {
            return context.getResources().getResourceEntryName(this.b);
        }

        @Override // com.nexstreaming.kinemaster.e.a
        public boolean h() {
            return true;
        }
    }

    public boolean c() {
        return false;
    }

    public int a(Context context) {
        return 0;
    }

    public void a(Context context, int i2) {
        if (c()) {
            this.d = Math.max(0, Math.min(a(context), (int) (((int) ((i2 + (c / 2.0d)) / c)) * c)));
        }
    }

    public int d() {
        return this.d;
    }

    public final Bitmap a(Context context, int i2, int i3) {
        Bitmap a2;
        int i4 = this.d;
        this.d = g();
        if (h()) {
            a2 = a(context, Math.min(i2 / e(), i3 / f()));
        } else {
            a2 = a(context, 1.0f);
        }
        this.d = i4;
        return a2;
    }

    public int e() {
        if (this.e < 0 || this.f < 0) {
            b(KineMasterApplication.a());
            if (this.e < 0 || this.f < 0) {
                throw new IllegalStateException("calcIntrinsicSize didn't call setIntrinsicSize for: " + getClass().getSimpleName());
            }
        }
        return this.e;
    }

    public int f() {
        if (this.e < 0 || this.f < 0) {
            b(KineMasterApplication.a());
            if (this.e < 0 || this.f < 0) {
                throw new IllegalStateException("calcIntrinsicSize didn't call setIntrinsicSize for: " + getClass().getSimpleName());
            }
        }
        return this.f;
    }

    protected final void a(int i2, int i3) {
        if (i2 <= 0) {
            i2 = 480;
        }
        if (i3 <= 0) {
            i3 = 480;
        }
        this.e = i2;
        this.f = i3;
    }

    public final Bitmap a(Context context, float f) {
        Bitmap bitmap;
        int indexOfKey;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        WeakReference<Bitmap> weakReference = this.h.get(this.d);
        if (weakReference != null && (bitmap4 = weakReference.get()) != null) {
            if (h()) {
                if (Math.max(((int) (e() * f)) - bitmap4.getWidth(), 0) + Math.max(((int) (f() * f)) - bitmap4.getHeight(), 0) < 10) {
                    return bitmap4;
                }
            } else {
                return bitmap4;
            }
        }
        Bitmap e = e(context);
        if (e == null) {
            Drawable c2 = c(context);
            if (c2 == null) {
                return null;
            }
            if (c2 instanceof BitmapDrawable) {
                e = ((BitmapDrawable) c2).getBitmap();
            }
            if (e == null) {
                int intrinsicWidth = (int) (c2.getIntrinsicWidth() * f);
                int intrinsicHeight = (int) (c2.getIntrinsicHeight() * f);
                if (intrinsicWidth <= 0) {
                    intrinsicWidth = 480;
                }
                if (intrinsicHeight <= 0) {
                    intrinsicHeight = 480;
                }
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                c2.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                c2.draw(canvas);
                bitmap = createBitmap;
                this.h.put(this.d, new WeakReference<>(bitmap));
                indexOfKey = this.h.indexOfKey(this.d);
                if (indexOfKey - 1 > 0 && (bitmap3 = this.h.valueAt(indexOfKey - 1).get()) != null && bitmap3.sameAs(bitmap)) {
                    this.h.put(this.d, new WeakReference<>(bitmap3));
                    bitmap = bitmap3;
                }
                if (indexOfKey + 1 < this.h.size() && (bitmap2 = this.h.valueAt(indexOfKey + 1).get()) != null && bitmap2.sameAs(bitmap)) {
                    this.h.put(this.d, new WeakReference<>(bitmap2));
                    bitmap = bitmap2;
                }
                return bitmap;
            }
        }
        bitmap = e;
        this.h.put(this.d, new WeakReference<>(bitmap));
        indexOfKey = this.h.indexOfKey(this.d);
        if (indexOfKey - 1 > 0) {
            this.h.put(this.d, new WeakReference<>(bitmap3));
            bitmap = bitmap3;
        }
        if (indexOfKey + 1 < this.h.size()) {
            this.h.put(this.d, new WeakReference<>(bitmap2));
            bitmap = bitmap2;
        }
        return bitmap;
    }

    public final Drawable c(Context context) {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.g.get(this.d);
        if (weakReference == null || (drawable = weakReference.get()) == null) {
            Drawable d = d(context);
            if (d == null) {
                return null;
            }
            this.g.put(this.d, new WeakReference<>(d));
            return d;
        }
        return drawable;
    }

    protected int g() {
        return 0;
    }

    public void i() {
    }
}
