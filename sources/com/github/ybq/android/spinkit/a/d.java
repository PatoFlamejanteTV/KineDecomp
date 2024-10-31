package com.github.ybq.android.spinkit.a;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.util.Property;
import android.view.animation.Interpolator;
import com.github.ybq.android.spinkit.b.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: SpriteAnimatorBuilder.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private q f9872a;

    /* renamed from: b */
    private Interpolator f9873b;

    /* renamed from: c */
    private int f9874c = -1;

    /* renamed from: d */
    private long f9875d = 2000;

    /* renamed from: e */
    private int f9876e = 0;

    /* renamed from: f */
    private Map<String, b> f9877f = new HashMap();

    /* compiled from: SpriteAnimatorBuilder.java */
    /* loaded from: classes.dex */
    public class a extends b<Float> {
        public a(float[] fArr, Property property, Float[] fArr2) {
            super(fArr, property, fArr2);
        }
    }

    /* compiled from: SpriteAnimatorBuilder.java */
    /* loaded from: classes.dex */
    public class b<T> {

        /* renamed from: a */
        float[] f9879a;

        /* renamed from: b */
        Property f9880b;

        /* renamed from: c */
        T[] f9881c;

        public b(float[] fArr, Property property, T[] tArr) {
            this.f9879a = fArr;
            this.f9880b = property;
            this.f9881c = tArr;
        }
    }

    /* compiled from: SpriteAnimatorBuilder.java */
    /* loaded from: classes.dex */
    public class c extends b<Integer> {
        public c(float[] fArr, Property property, Integer[] numArr) {
            super(fArr, property, numArr);
        }
    }

    public d(q qVar) {
        this.f9872a = qVar;
    }

    public d a(float[] fArr, Float... fArr2) {
        a(fArr, q.k, fArr2);
        return this;
    }

    public d b(float[] fArr, Float... fArr2) {
        a(fArr, q.j, fArr2);
        return this;
    }

    public d c(float[] fArr, Integer... numArr) {
        a(fArr, q.f9885b, numArr);
        return this;
    }

    public d d(float[] fArr, Integer... numArr) {
        a(fArr, q.f9887d, numArr);
        return this;
    }

    public d a(float[] fArr, Integer... numArr) {
        a(fArr, q.l, numArr);
        return this;
    }

    public d b(float[] fArr, Integer... numArr) {
        a(fArr, q.f9886c, numArr);
        return this;
    }

    public d c(float[] fArr, Float... fArr2) {
        a(fArr, q.f9890g, fArr2);
        return this;
    }

    public d d(float[] fArr, Float... fArr2) {
        a(fArr, q.f9891h, fArr2);
        return this;
    }

    private void a(float[] fArr, Property property, Float[] fArr2) {
        a(fArr.length, fArr2.length);
        this.f9877f.put(property.getName(), new a(fArr, property, fArr2));
    }

    private void a(float[] fArr, Property property, Integer[] numArr) {
        a(fArr.length, numArr.length);
        this.f9877f.put(property.getName(), new c(fArr, property, numArr));
    }

    private void a(int i, int i2) {
        if (i != i2) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public d a(Interpolator interpolator) {
        this.f9873b = interpolator;
        return this;
    }

    public d a(float... fArr) {
        a(com.github.ybq.android.spinkit.a.a.b.a(fArr));
        return this;
    }

    public d a(long j) {
        this.f9875d = j;
        return this;
    }

    public d a(int i) {
        if (i < 0) {
            Log.w("SpriteAnimatorBuilder", "startFrame should always be non-negative");
            i = 0;
        }
        this.f9876e = i;
        return this;
    }

    public ObjectAnimator a() {
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[this.f9877f.size()];
        Iterator<Map.Entry<String, b>> it = this.f9877f.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            b value = it.next().getValue();
            float[] fArr = value.f9879a;
            Keyframe[] keyframeArr = new Keyframe[fArr.length];
            int i2 = this.f9876e;
            float f2 = fArr[i2];
            while (true) {
                int i3 = this.f9876e;
                T[] tArr = value.f9881c;
                if (i2 < tArr.length + i3) {
                    int i4 = i2 - i3;
                    int length = i2 % tArr.length;
                    float f3 = fArr[length] - f2;
                    if (f3 < 0.0f) {
                        f3 += fArr[fArr.length - 1];
                    }
                    if (value instanceof c) {
                        keyframeArr[i4] = Keyframe.ofInt(f3, ((Integer) value.f9881c[length]).intValue());
                    } else if (value instanceof a) {
                        keyframeArr[i4] = Keyframe.ofFloat(f3, ((Float) value.f9881c[length]).floatValue());
                    } else {
                        keyframeArr[i4] = Keyframe.ofObject(f3, value.f9881c[length]);
                    }
                    i2++;
                }
            }
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofKeyframe(value.f9880b, keyframeArr);
            i++;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f9872a, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration(this.f9875d);
        ofPropertyValuesHolder.setRepeatCount(this.f9874c);
        ofPropertyValuesHolder.setInterpolator(this.f9873b);
        return ofPropertyValuesHolder;
    }
}
