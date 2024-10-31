package h.a.a.a;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/* compiled from: CalligraphyUtils.java */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a */
    private static Boolean f26809a;

    public static CharSequence a(CharSequence charSequence, Typeface typeface) {
        if (charSequence != null && charSequence.length() > 0) {
            if (!(charSequence instanceof Spannable)) {
                charSequence = new SpannableString(charSequence);
            }
            ((Spannable) charSequence).setSpan(m.a(typeface), 0, charSequence.length(), 33);
        }
        return charSequence;
    }

    public static String b(Context context, AttributeSet attributeSet, int i) {
        int i2 = -1;
        if (i != -1 && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textAppearance});
            if (obtainStyledAttributes != null) {
                try {
                    i2 = obtainStyledAttributes.getResourceId(0, -1);
                } catch (Exception unused) {
                    return null;
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, new int[]{i});
            if (obtainStyledAttributes2 != null) {
                try {
                    return obtainStyledAttributes2.getString(0);
                } catch (Exception unused2) {
                } finally {
                    obtainStyledAttributes2.recycle();
                }
            }
        }
        return null;
    }

    public static String c(Context context, AttributeSet attributeSet, int i) {
        if (i != -1 && attributeSet != null) {
            try {
                String resourceEntryName = context.getResources().getResourceEntryName(i);
                int attributeResourceValue = attributeSet.getAttributeResourceValue(null, resourceEntryName, -1);
                if (attributeResourceValue > 0) {
                    return context.getString(attributeResourceValue);
                }
                return attributeSet.getAttributeValue(null, resourceEntryName);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean a(TextView textView, Typeface typeface, boolean z) {
        if (textView == null || typeface == null) {
            return false;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128 | 1);
        textView.setTypeface(typeface);
        if (z) {
            textView.setText(a(textView.getText(), typeface), TextView.BufferType.SPANNABLE);
            textView.addTextChangedListener(new h(typeface));
        }
        return true;
    }

    static boolean a(Context context, TextView textView, String str, boolean z) {
        if (textView == null || context == null) {
            return false;
        }
        return a(textView, m.a(context.getAssets(), str), z);
    }

    static void a(Context context, TextView textView, b bVar, boolean z) {
        if (context == null || textView == null || bVar == null || !bVar.f()) {
            return;
        }
        a(context, textView, bVar.d(), z);
    }

    public static void a(Context context, TextView textView, b bVar, String str, boolean z) {
        if (context == null || textView == null || bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || !a(context, textView, str, z)) {
            a(context, textView, bVar, z);
        }
    }

    public static String a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (i != -1 && attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{i})) != null) {
            try {
                String string = obtainStyledAttributes.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    obtainStyledAttributes.recycle();
                    return string;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        return null;
    }

    public static String a(Context context, int i, int i2) {
        if (i != -1 && i2 != -1) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(typedValue.resourceId, new int[]{i2});
            try {
                return obtainStyledAttributes.getString(0);
            } catch (Exception unused) {
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return null;
    }

    public static String a(Context context, int i, int i2, int i3) {
        TypedArray obtainStyledAttributes;
        if (i != -1 && i3 != -1) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(typedValue.resourceId, new int[]{i2});
            try {
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                if (resourceId != -1 && (obtainStyledAttributes = context.obtainStyledAttributes(resourceId, new int[]{i3})) != null) {
                    try {
                        return obtainStyledAttributes.getString(0);
                    } catch (Exception unused) {
                    } finally {
                        obtainStyledAttributes.recycle();
                    }
                }
                return null;
            } catch (Exception unused2) {
            } finally {
                obtainStyledAttributes2.recycle();
            }
        }
        return null;
    }

    public static boolean a() {
        if (f26809a == null) {
            try {
                Class.forName("android.support.v7.widget.Toolbar");
                f26809a = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f26809a = Boolean.FALSE;
            }
        }
        return f26809a.booleanValue();
    }
}
