package b.b.e.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class k extends j {

    /* renamed from: b, reason: collision with root package name */
    static final PorterDuff.Mode f3319b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private f f3320c;

    /* renamed from: d, reason: collision with root package name */
    private PorterDuffColorFilter f3321d;

    /* renamed from: e, reason: collision with root package name */
    private ColorFilter f3322e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3323f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3324g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable.ConstantState f3325h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends d {
        public a() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, b.b.e.a.a.f3296d);
                a(obtainAttributes);
                obtainAttributes.recycle();
            }
        }

        @Override // b.b.e.a.k.d
        public boolean a() {
            return true;
        }

        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3340b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3339a = PathParser.createNodesFromPathData(string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Matrix f3331a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<Object> f3332b;

        /* renamed from: c, reason: collision with root package name */
        float f3333c;

        /* renamed from: d, reason: collision with root package name */
        private float f3334d;

        /* renamed from: e, reason: collision with root package name */
        private float f3335e;

        /* renamed from: f, reason: collision with root package name */
        private float f3336f;

        /* renamed from: g, reason: collision with root package name */
        private float f3337g;

        /* renamed from: h, reason: collision with root package name */
        private float f3338h;
        private float i;
        private final Matrix j;
        int k;
        private int[] l;
        private String m;

        public c(c cVar, ArrayMap<String, Object> arrayMap) {
            d aVar;
            this.f3331a = new Matrix();
            this.f3332b = new ArrayList<>();
            this.f3333c = 0.0f;
            this.f3334d = 0.0f;
            this.f3335e = 0.0f;
            this.f3336f = 1.0f;
            this.f3337g = 1.0f;
            this.f3338h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f3333c = cVar.f3333c;
            this.f3334d = cVar.f3334d;
            this.f3335e = cVar.f3335e;
            this.f3336f = cVar.f3336f;
            this.f3337g = cVar.f3337g;
            this.f3338h = cVar.f3338h;
            this.i = cVar.i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            String str = this.m;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.j.set(cVar.j);
            ArrayList<Object> arrayList = cVar.f3332b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.f3332b.add(new c((c) obj, arrayMap));
                } else {
                    if (obj instanceof b) {
                        aVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        aVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f3332b.add(aVar);
                    String str2 = aVar.f3340b;
                    if (str2 != null) {
                        arrayMap.put(str2, aVar);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f3334d;
        }

        public float getPivotY() {
            return this.f3335e;
        }

        public float getRotation() {
            return this.f3333c;
        }

        public float getScaleX() {
            return this.f3336f;
        }

        public float getScaleY() {
            return this.f3337g;
        }

        public float getTranslateX() {
            return this.f3338h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f3334d) {
                this.f3334d = f2;
                a();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f3335e) {
                this.f3335e = f2;
                a();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f3333c) {
                this.f3333c = f2;
                a();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f3336f) {
                this.f3336f = f2;
                a();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f3337g) {
                this.f3337g = f2;
                a();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3338h) {
                this.f3338h = f2;
                a();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                a();
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, b.b.e.a.a.f3294b);
            a(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f3333c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f3333c);
            this.f3334d = typedArray.getFloat(1, this.f3334d);
            this.f3335e = typedArray.getFloat(2, this.f3335e);
            this.f3336f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.f3336f);
            this.f3337g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.f3337g);
            this.f3338h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.f3338h);
            this.i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        private void a() {
            this.j.reset();
            this.j.postTranslate(-this.f3334d, -this.f3335e);
            this.j.postScale(this.f3336f, this.f3337g);
            this.j.postRotate(this.f3333c, 0.0f, 0.0f);
            this.j.postTranslate(this.f3338h + this.f3334d, this.i + this.f3335e);
        }

        public c() {
            this.f3331a = new Matrix();
            this.f3332b = new ArrayList<>();
            this.f3333c = 0.0f;
            this.f3334d = 0.0f;
            this.f3335e = 0.0f;
            this.f3336f = 1.0f;
            this.f3337g = 1.0f;
            this.f3338h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Matrix f3342a = new Matrix();

        /* renamed from: b, reason: collision with root package name */
        private final Path f3343b;

        /* renamed from: c, reason: collision with root package name */
        private final Path f3344c;

        /* renamed from: d, reason: collision with root package name */
        private final Matrix f3345d;

        /* renamed from: e, reason: collision with root package name */
        private Paint f3346e;

        /* renamed from: f, reason: collision with root package name */
        private Paint f3347f;

        /* renamed from: g, reason: collision with root package name */
        private PathMeasure f3348g;

        /* renamed from: h, reason: collision with root package name */
        private int f3349h;
        final c i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        final ArrayMap<String, Object> p;

        public e() {
            this.f3345d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = new ArrayMap<>();
            this.i = new c();
            this.f3343b = new Path();
            this.f3344c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.n = i;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f3331a.set(matrix);
            cVar.f3331a.preConcat(cVar.j);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f3332b.size(); i3++) {
                Object obj = cVar.f3332b.get(i3);
                if (obj instanceof c) {
                    a((c) obj, cVar.f3331a, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    a(cVar, (d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public e(e eVar) {
            this.f3345d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = new ArrayMap<>();
            this.i = new c(eVar.i, this.p);
            this.f3343b = new Path(eVar.f3343b);
            this.f3344c = new Path(eVar.f3344c);
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
            this.f3349h = eVar.f3349h;
            this.n = eVar.n;
            this.o = eVar.o;
            String str = eVar.o;
            if (str != null) {
                this.p.put(str, this);
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.i, f3342a, canvas, i, i2, colorFilter);
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f2 = i / this.l;
            float f3 = i2 / this.m;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f3331a;
            this.f3345d.set(matrix);
            this.f3345d.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 == 0.0f) {
                return;
            }
            dVar.a(this.f3343b);
            Path path = this.f3343b;
            this.f3344c.reset();
            if (dVar.a()) {
                this.f3344c.addPath(path, this.f3345d);
                canvas.clipPath(this.f3344c);
                return;
            }
            b bVar = (b) dVar;
            if (bVar.k != 0.0f || bVar.l != 1.0f) {
                float f4 = bVar.k;
                float f5 = bVar.m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (bVar.l + f5) % 1.0f;
                if (this.f3348g == null) {
                    this.f3348g = new PathMeasure();
                }
                this.f3348g.setPath(this.f3343b, false);
                float length = this.f3348g.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f3348g.getSegment(f8, length, path, true);
                    this.f3348g.getSegment(0.0f, f9, path, true);
                } else {
                    this.f3348g.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f3344c.addPath(path, this.f3345d);
            if (bVar.f3329g != 0) {
                if (this.f3347f == null) {
                    this.f3347f = new Paint();
                    this.f3347f.setStyle(Paint.Style.FILL);
                    this.f3347f.setAntiAlias(true);
                }
                Paint paint = this.f3347f;
                paint.setColor(k.a(bVar.f3329g, bVar.j));
                paint.setColorFilter(colorFilter);
                this.f3344c.setFillType(bVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f3344c, paint);
            }
            if (bVar.f3327e != 0) {
                if (this.f3346e == null) {
                    this.f3346e = new Paint();
                    this.f3346e.setStyle(Paint.Style.STROKE);
                    this.f3346e.setAntiAlias(true);
                }
                Paint paint2 = this.f3346e;
                Paint.Join join = bVar.o;
                if (join != null) {
                    paint2.setStrokeJoin(join);
                }
                Paint.Cap cap = bVar.n;
                if (cap != null) {
                    paint2.setStrokeCap(cap);
                }
                paint2.setStrokeMiter(bVar.p);
                paint2.setColor(k.a(bVar.f3327e, bVar.f3330h));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.f3328f * min * a2);
                canvas.drawPath(this.f3344c, paint2);
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class f extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f3350a;

        /* renamed from: b, reason: collision with root package name */
        e f3351b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f3352c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f3353d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3354e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f3355f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f3356g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f3357h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f(f fVar) {
            this.f3352c = null;
            this.f3353d = k.f3319b;
            if (fVar != null) {
                this.f3350a = fVar.f3350a;
                this.f3351b = new e(fVar.f3351b);
                if (fVar.f3351b.f3347f != null) {
                    this.f3351b.f3347f = new Paint(fVar.f3351b.f3347f);
                }
                if (fVar.f3351b.f3346e != null) {
                    this.f3351b.f3346e = new Paint(fVar.f3351b.f3346e);
                }
                this.f3352c = fVar.f3352c;
                this.f3353d = fVar.f3353d;
                this.f3354e = fVar.f3354e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3355f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f3351b.getRootAlpha() < 255;
        }

        public void c(int i, int i2) {
            this.f3355f.eraseColor(0);
            this.f3351b.a(new Canvas(this.f3355f), i, i2, (ColorFilter) null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3350a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k(this);
        }

        public void b(int i, int i2) {
            if (this.f3355f == null || !a(i, i2)) {
                this.f3355f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new k(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (!b() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f3351b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void c() {
            this.f3356g = this.f3352c;
            this.f3357h = this.f3353d;
            this.i = this.f3351b.getRootAlpha();
            this.j = this.f3354e;
            this.k = false;
        }

        public boolean a(int i, int i2) {
            return i == this.f3355f.getWidth() && i2 == this.f3355f.getHeight();
        }

        public boolean a() {
            return !this.k && this.f3356g == this.f3352c && this.f3357h == this.f3353d && this.j == this.f3354e && this.i == this.f3351b.getRootAlpha();
        }

        public f() {
            this.f3352c = null;
            this.f3353d = k.f3319b;
            this.f3351b = new e();
        }
    }

    k() {
        this.f3324g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f3320c = new f();
    }

    public static k createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        k kVar = new k();
        kVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f3320c.f3351b.p.get(str);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3318a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(drawable);
        return false;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f3322e;
        if (colorFilter == null) {
            colorFilter = this.f3321d;
        }
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float abs = Math.abs(this.i[0]);
        float abs2 = Math.abs(this.i[4]);
        float abs3 = Math.abs(this.i[1]);
        float abs4 = Math.abs(this.i[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.k.width() * abs));
        int min2 = Math.min(2048, (int) (this.k.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.k;
        canvas.translate(rect.left, rect.top);
        if (a()) {
            canvas.translate(this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.f3320c.b(min, min2);
        if (!this.f3324g) {
            this.f3320c.c(min, min2);
        } else if (!this.f3320c.a()) {
            this.f3320c.c(min, min2);
            this.f3320c.c();
        }
        this.f3320c.a(canvas, colorFilter, this.k);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.f3320c.f3351b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3320c.getChangingConfigurations();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f3318a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new g(drawable.getConstantState());
        }
        this.f3320c.f3350a = getChangingConfigurations();
        return this.f3320c;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f3320c.f3351b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f3320c.f3351b.j;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.f3320c.f3354e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || !((fVar = this.f3320c) == null || (colorStateList = fVar.f3352c) == null || !colorStateList.isStateful());
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3323f && super.mutate() == this) {
            this.f3320c = new f(this.f3320c);
            this.f3323f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        f fVar = this.f3320c;
        ColorStateList colorStateList = fVar.f3352c;
        if (colorStateList == null || (mode = fVar.f3353d) == null) {
            return false;
        }
        this.f3321d = a(this.f3321d, colorStateList, mode);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f3320c.f3351b.getRootAlpha() != i) {
            this.f3320c.f3351b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f3320c.f3354e = z;
        }
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // b.b.e.a.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        f fVar = this.f3320c;
        if (fVar.f3352c != colorStateList) {
            fVar.f3352c = colorStateList;
            this.f3321d = a(this.f3321d, colorStateList, fVar.f3353d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        f fVar = this.f3320c;
        if (fVar.f3353d != mode) {
            fVar.f3353d = mode;
            this.f3321d = a(this.f3321d, fVar.f3352c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        protected PathParser.PathDataNode[] f3339a;

        /* renamed from: b, reason: collision with root package name */
        String f3340b;

        /* renamed from: c, reason: collision with root package name */
        int f3341c;

        public d() {
            this.f3339a = null;
        }

        public void a(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f3339a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public boolean a() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f3339a;
        }

        public String getPathName() {
            return this.f3340b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.f3339a, pathDataNodeArr)) {
                this.f3339a = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.f3339a, pathDataNodeArr);
            }
        }

        public d(d dVar) {
            this.f3339a = null;
            this.f3340b = dVar.f3340b;
            this.f3341c = dVar.f3341c;
            this.f3339a = PathParser.deepCopyNodes(dVar.f3339a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class g extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f3358a;

        public g(Drawable.ConstantState constantState) {
            this.f3358a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3358a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3358a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            k kVar = new k();
            kVar.f3318a = (VectorDrawable) this.f3358a.newDrawable();
            return kVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            k kVar = new k();
            kVar.f3318a = (VectorDrawable) this.f3358a.newDrawable(resources);
            return kVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            k kVar = new k();
            kVar.f3318a = (VectorDrawable) this.f3358a.newDrawable(resources, theme);
            return kVar;
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3322e = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends d {

        /* renamed from: d, reason: collision with root package name */
        private int[] f3326d;

        /* renamed from: e, reason: collision with root package name */
        int f3327e;

        /* renamed from: f, reason: collision with root package name */
        float f3328f;

        /* renamed from: g, reason: collision with root package name */
        int f3329g;

        /* renamed from: h, reason: collision with root package name */
        float f3330h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public b() {
            this.f3327e = 0;
            this.f3328f = 0.0f;
            this.f3329g = 0;
            this.f3330h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            if (i == 0) {
                return Paint.Cap.BUTT;
            }
            if (i != 1) {
                return i != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.f3329g;
        }

        float getStrokeAlpha() {
            return this.f3330h;
        }

        int getStrokeColor() {
            return this.f3327e;
        }

        float getStrokeWidth() {
            return this.f3328f;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f2) {
            this.j = f2;
        }

        void setFillColor(int i) {
            this.f3329g = i;
        }

        void setStrokeAlpha(float f2) {
            this.f3330h = f2;
        }

        void setStrokeColor(int i) {
            this.f3327e = i;
        }

        void setStrokeWidth(float f2) {
            this.f3328f = f2;
        }

        void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        void setTrimPathStart(float f2) {
            this.k = f2;
        }

        private Paint.Join a(int i, Paint.Join join) {
            if (i == 0) {
                return Paint.Join.MITER;
            }
            if (i != 1) {
                return i != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, b.b.e.a.a.f3295c);
            a(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f3326d = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3340b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3339a = PathParser.createNodesFromPathData(string2);
                }
                this.f3329g = TypedArrayUtils.getNamedColor(typedArray, xmlPullParser, "fillColor", 1, this.f3329g);
                this.j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f3327e = TypedArrayUtils.getNamedColor(typedArray, xmlPullParser, "strokeColor", 3, this.f3327e);
                this.f3330h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3330h);
                this.f3328f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.f3328f);
                this.l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        public b(b bVar) {
            super(bVar);
            this.f3327e = 0;
            this.f3328f = 0.0f;
            this.f3329g = 0;
            this.f3330h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f3326d = bVar.f3326d;
            this.f3327e = bVar.f3327e;
            this.f3328f = bVar.f3328f;
            this.f3330h = bVar.f3330h;
            this.f3329g = bVar.f3329g;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
        }
    }

    public static k a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            k kVar = new k();
            kVar.f3318a = ResourcesCompat.getDrawable(resources, i, theme);
            kVar.f3325h = new g(kVar.f3318a.getConstantState());
            return kVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3318a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.f3320c;
        fVar.f3351b = new e();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, b.b.e.a.a.f3293a);
        a(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        fVar.f3350a = getChangingConfigurations();
        fVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f3321d = a(this.f3321d, fVar.f3352c, fVar.f3353d);
    }

    k(f fVar) {
        this.f3324g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f3320c = fVar;
        this.f3321d = a(this.f3321d, fVar.f3352c, fVar.f3353d);
    }

    static int a(int i, float f2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i != 9) {
            switch (i) {
                case 14:
                    return PorterDuff.Mode.MULTIPLY;
                case 15:
                    return PorterDuff.Mode.SCREEN;
                case 16:
                    return PorterDuff.Mode.ADD;
                default:
                    return mode;
            }
        }
        return PorterDuff.Mode.SRC_ATOP;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        f fVar = this.f3320c;
        e eVar = fVar.f3351b;
        fVar.f3353d = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.f3352c = colorStateList;
        }
        fVar.f3354e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, fVar.f3354e);
        eVar.l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, eVar.l);
        eVar.m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, eVar.m);
        if (eVar.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (eVar.m > 0.0f) {
            eVar.j = typedArray.getDimension(3, eVar.j);
            eVar.k = typedArray.getDimension(2, eVar.k);
            if (eVar.j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (eVar.k > 0.0f) {
                eVar.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    eVar.o = string;
                    eVar.p.put(string, eVar);
                    return;
                }
                return;
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f fVar = this.f3320c;
        e eVar = fVar.f3351b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(eVar.i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f3332b.add(bVar);
                    if (bVar.getPathName() != null) {
                        eVar.p.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    fVar.f3350a = bVar.f3341c | fVar.f3350a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f3332b.add(aVar);
                    if (aVar.getPathName() != null) {
                        eVar.p.put(aVar.getPathName(), aVar);
                    }
                    fVar.f3350a = aVar.f3341c | fVar.f3350a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f3332b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        eVar.p.put(cVar2.getGroupName(), cVar2);
                    }
                    fVar.f3350a = cVar2.k | fVar.f3350a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f3324g = z;
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1;
    }
}
