package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class B<T> extends Property<T, Float> {

    /* renamed from: a */
    private final Property<T, PointF> f524a;

    /* renamed from: b */
    private final PathMeasure f525b;

    /* renamed from: c */
    private final float f526c;

    /* renamed from: d */
    private final float[] f527d;

    /* renamed from: e */
    private final PointF f528e;

    /* renamed from: f */
    private float f529f;

    public B(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f527d = new float[2];
        this.f528e = new PointF();
        this.f524a = property;
        this.f525b = new PathMeasure(path, false);
        this.f526c = this.f525b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f529f = f2.floatValue();
        this.f525b.getPosTan(this.f526c * f2.floatValue(), this.f527d, null);
        PointF pointF = this.f528e;
        float[] fArr = this.f527d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f524a.set(t, pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((B<T>) obj);
    }

    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f529f);
    }
}
