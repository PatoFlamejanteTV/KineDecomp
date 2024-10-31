package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class AppCompatResources {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f2248a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> f2249b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f2250c = new Object();

    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {

        /* renamed from: a */
        final ColorStateList f2251a;

        /* renamed from: b */
        final Configuration f2252b;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
            this.f2251a = colorStateList;
            this.f2252b = configuration;
        }
    }

    private AppCompatResources() {
    }

    private static ColorStateList a(Context context, int i) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (f2250c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = f2249b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.f2252b.equals(context.getResources().getConfiguration())) {
                    return colorStateListCacheEntry.f2251a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static ColorStateList b(Context context, int i) {
        if (c(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return AppCompatColorStateListInflater.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean c(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        int i2 = a2.type;
        return i2 >= 28 && i2 <= 31;
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList a2 = a(context, i);
        if (a2 != null) {
            return a2;
        }
        ColorStateList b2 = b(context, i);
        if (b2 != null) {
            a(context, i, b2);
            return b2;
        }
        return ContextCompat.getColorStateList(context, i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return AppCompatDrawableManager.get().getDrawable(context, i);
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f2250c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = f2249b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f2249b.put(context, sparseArray);
            }
            sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = f2248a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f2248a.set(typedValue2);
        return typedValue2;
    }
}
