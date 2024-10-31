package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class ThemeUtils {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f3095a = new ThreadLocal<>();

    /* renamed from: b */
    static final int[] f3096b = {-16842910};

    /* renamed from: c */
    static final int[] f3097c = {R.attr.state_focused};

    /* renamed from: d */
    static final int[] f3098d = {R.attr.state_activated};

    /* renamed from: e */
    static final int[] f3099e = {R.attr.state_pressed};

    /* renamed from: f */
    static final int[] f3100f = {R.attr.state_checked};

    /* renamed from: g */
    static final int[] f3101g = {R.attr.state_selected};

    /* renamed from: h */
    static final int[] f3102h = {-16842919, -16842908};
    static final int[] i = new int[0];
    private static final int[] j = new int[1];

    ThemeUtils() {
    }

    private static TypedValue a() {
        TypedValue typedValue = f3095a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f3095a.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList createDisabledStateList(int i2, int i3) {
        return new ColorStateList(new int[][]{f3096b, i}, new int[]{i3, i2});
    }

    public static int getDisabledThemeAttrColor(Context context, int i2) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i2);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f3096b, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, a2, true);
        return a(context, i2, a2.getFloat());
    }

    public static int getThemeAttrColor(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int a(Context context, int i2, float f2) {
        return ColorUtils.setAlphaComponent(getThemeAttrColor(context, i2), Math.round(Color.alpha(r0) * f2));
    }
}
