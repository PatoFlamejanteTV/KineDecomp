package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: a */
    private final Context f3111a;

    /* renamed from: b */
    private final TypedArray f3112b;

    /* renamed from: c */
    private TypedValue f3113c;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f3111a = context;
        this.f3112b = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f3112b.getBoolean(i, z);
    }

    public int getChangingConfigurations() {
        return this.f3112b.getChangingConfigurations();
    }

    public int getColor(int i, int i2) {
        return this.f3112b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.f3112b.hasValue(i) || (resourceId = this.f3112b.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.f3111a, resourceId)) == null) ? this.f3112b.getColorStateList(i) : colorStateList;
    }

    public float getDimension(int i, float f2) {
        return this.f3112b.getDimension(i, f2);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f3112b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f3112b.getDimensionPixelSize(i, i2);
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        if (this.f3112b.hasValue(i) && (resourceId = this.f3112b.getResourceId(i, 0)) != 0) {
            return AppCompatResources.getDrawable(this.f3111a, resourceId);
        }
        return this.f3112b.getDrawable(i);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.f3112b.hasValue(i) || (resourceId = this.f3112b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().a(this.f3111a, resourceId, true);
    }

    public float getFloat(int i, float f2) {
        return this.f3112b.getFloat(i, f2);
    }

    public Typeface getFont(int i, int i2, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f3112b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f3113c == null) {
            this.f3113c = new TypedValue();
        }
        return ResourcesCompat.getFont(this.f3111a, resourceId, this.f3113c, i2, fontCallback);
    }

    public float getFraction(int i, int i2, int i3, float f2) {
        return this.f3112b.getFraction(i, i2, i3, f2);
    }

    public int getIndex(int i) {
        return this.f3112b.getIndex(i);
    }

    public int getIndexCount() {
        return this.f3112b.getIndexCount();
    }

    public int getInt(int i, int i2) {
        return this.f3112b.getInt(i, i2);
    }

    public int getInteger(int i, int i2) {
        return this.f3112b.getInteger(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f3112b.getLayoutDimension(i, str);
    }

    public String getNonResourceString(int i) {
        return this.f3112b.getNonResourceString(i);
    }

    public String getPositionDescription() {
        return this.f3112b.getPositionDescription();
    }

    public int getResourceId(int i, int i2) {
        return this.f3112b.getResourceId(i, i2);
    }

    public Resources getResources() {
        return this.f3112b.getResources();
    }

    public String getString(int i) {
        return this.f3112b.getString(i);
    }

    public CharSequence getText(int i) {
        return this.f3112b.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f3112b.getTextArray(i);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f3112b.getType(i);
        }
        if (this.f3113c == null) {
            this.f3113c = new TypedValue();
        }
        this.f3112b.getValue(i, this.f3113c);
        return this.f3113c.type;
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f3112b.getValue(i, typedValue);
    }

    public boolean hasValue(int i) {
        return this.f3112b.hasValue(i);
    }

    public int length() {
        return this.f3112b.length();
    }

    public TypedValue peekValue(int i) {
        return this.f3112b.peekValue(i);
    }

    public void recycle() {
        this.f3112b.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f3112b.getLayoutDimension(i, i2);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }
}
