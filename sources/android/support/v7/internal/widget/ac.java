package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private final Context f163a;
    private final TypedArray b;
    private ab c;

    public static ac a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ac(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ac a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ac(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    private ac(Context context, TypedArray typedArray) {
        this.f163a = context;
        this.b = typedArray;
    }

    public Drawable a(int i) {
        int resourceId;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) ? this.b.getDrawable(i) : c().a(resourceId);
    }

    public int a() {
        return this.b.length();
    }

    public CharSequence b(int i) {
        return this.b.getText(i);
    }

    public String c(int i) {
        return this.b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public int c(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int d(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public int e(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public boolean d(int i) {
        return this.b.hasValue(i);
    }

    public void b() {
        this.b.recycle();
    }

    public ab c() {
        if (this.c == null) {
            this.c = ab.a(this.f163a);
        }
        return this.c;
    }
}
