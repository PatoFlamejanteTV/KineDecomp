package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.os.BuildCompat;
import android.text.Editable;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;

    /* renamed from: a */
    static final TextViewCompatBaseImpl f2055a;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AutoSizeTextType {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextViewCompatApi16Impl extends TextViewCompatBaseImpl {
        TextViewCompatApi16Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getMaxLines(TextView textView) {
            return textView.getMaxLines();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getMinLines(TextView textView) {
            return textView.getMinLines();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextViewCompatApi18Impl extends TextViewCompatApi17Impl {
        TextViewCompatApi18Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public Drawable[] getCompoundDrawablesRelative(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextViewCompatApi23Impl extends TextViewCompatApi18Impl {
        TextViewCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setTextAppearance(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    /* loaded from: classes.dex */
    static class TextViewCompatApi27Impl extends TextViewCompatApi26Impl {
        TextViewCompatApi27Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeMaxTextSize(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeMinTextSize(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int[] getAutoSizeTextAvailableSizes(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeTextType(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) throws IllegalArgumentException {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) throws IllegalArgumentException {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setAutoSizeTextTypeWithDefaults(TextView textView, int i) {
            textView.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextViewCompatBaseImpl {

        /* renamed from: a */
        private static Field f2063a;

        /* renamed from: b */
        private static boolean f2064b;

        /* renamed from: c */
        private static Field f2065c;

        /* renamed from: d */
        private static boolean f2066d;

        /* renamed from: e */
        private static Field f2067e;

        /* renamed from: f */
        private static boolean f2068f;

        /* renamed from: g */
        private static Field f2069g;

        /* renamed from: h */
        private static boolean f2070h;

        TextViewCompatBaseImpl() {
        }

        private static Field a(String str) {
            Field field = null;
            try {
                field = TextView.class.getDeclaredField(str);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException unused) {
                Log.e("TextViewCompatBase", "Could not retrieve " + str + " field.");
                return field;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeMaxTextSize(TextView textView) {
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeMinTextSize(TextView textView) {
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeMinTextSize();
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeStepGranularity(TextView textView) {
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeStepGranularity();
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int[] getAutoSizeTextAvailableSizes(TextView textView) {
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes();
            }
            return new int[0];
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeTextType(TextView textView) {
            if (textView instanceof AutoSizeableTextView) {
                return ((AutoSizeableTextView) textView).getAutoSizeTextType();
            }
            return 0;
        }

        public Drawable[] getCompoundDrawablesRelative(TextView textView) {
            return textView.getCompoundDrawables();
        }

        public int getMaxLines(TextView textView) {
            if (!f2066d) {
                f2065c = a("mMaxMode");
                f2066d = true;
            }
            Field field = f2065c;
            if (field == null || a(field, textView) != 1) {
                return -1;
            }
            if (!f2064b) {
                f2063a = a("mMaximum");
                f2064b = true;
            }
            Field field2 = f2063a;
            if (field2 != null) {
                return a(field2, textView);
            }
            return -1;
        }

        public int getMinLines(TextView textView) {
            if (!f2070h) {
                f2069g = a("mMinMode");
                f2070h = true;
            }
            Field field = f2069g;
            if (field == null || a(field, textView) != 1) {
                return -1;
            }
            if (!f2068f) {
                f2067e = a("mMinimum");
                f2068f = true;
            }
            Field field2 = f2067e;
            if (field2 != null) {
                return a(field2, textView);
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) throws IllegalArgumentException {
            if (textView instanceof AutoSizeableTextView) {
                ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) throws IllegalArgumentException {
            if (textView instanceof AutoSizeableTextView) {
                ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setAutoSizeTextTypeWithDefaults(TextView textView, int i) {
            if (textView instanceof AutoSizeableTextView) {
                ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i);
            }
        }

        public void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
            textView.setCustomSelectionActionModeCallback(callback);
        }

        public void setTextAppearance(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        }

        private static int a(Field field, TextView textView) {
            try {
                return field.getInt(textView);
            } catch (IllegalAccessException unused) {
                Log.d("TextViewCompatBase", "Could not retrieve value of " + field.getName() + " field.");
                return -1;
            }
        }
    }

    static {
        if (BuildCompat.isAtLeastOMR1()) {
            f2055a = new TextViewCompatApi27Impl();
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            f2055a = new TextViewCompatApi26Impl();
            return;
        }
        if (i >= 23) {
            f2055a = new TextViewCompatApi23Impl();
            return;
        }
        if (i >= 18) {
            f2055a = new TextViewCompatApi18Impl();
            return;
        }
        if (i >= 17) {
            f2055a = new TextViewCompatApi17Impl();
        } else if (i >= 16) {
            f2055a = new TextViewCompatApi16Impl();
        } else {
            f2055a = new TextViewCompatBaseImpl();
        }
    }

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(TextView textView) {
        return f2055a.getAutoSizeMaxTextSize(textView);
    }

    public static int getAutoSizeMinTextSize(TextView textView) {
        return f2055a.getAutoSizeMinTextSize(textView);
    }

    public static int getAutoSizeStepGranularity(TextView textView) {
        return f2055a.getAutoSizeStepGranularity(textView);
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        return f2055a.getAutoSizeTextAvailableSizes(textView);
    }

    public static int getAutoSizeTextType(TextView textView) {
        return f2055a.getAutoSizeTextType(textView);
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return f2055a.getCompoundDrawablesRelative(textView);
    }

    public static int getMaxLines(TextView textView) {
        return f2055a.getMaxLines(textView);
    }

    public static int getMinLines(TextView textView) {
        return f2055a.getMinLines(textView);
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        f2055a.setAutoSizeTextTypeUniformWithConfiguration(textView, i, i2, i3, i4);
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) throws IllegalArgumentException {
        f2055a.setAutoSizeTextTypeUniformWithPresetSizes(textView, iArr, i);
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView textView, int i) {
        f2055a.setAutoSizeTextTypeWithDefaults(textView, i);
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f2055a.setCompoundDrawablesRelative(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f2055a.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        f2055a.setCustomSelectionActionModeCallback(textView, callback);
    }

    public static void setTextAppearance(TextView textView, int i) {
        f2055a.setTextAppearance(textView, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextViewCompatApi17Impl extends TextViewCompatApi16Impl {
        TextViewCompatApi17Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public Drawable[] getCompoundDrawablesRelative(TextView textView) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z) {
                Drawable drawable = compoundDrawables[2];
                Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
            boolean z = textView.getLayoutDirection() == 1;
            int i5 = z ? i3 : i;
            if (!z) {
                i = i3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
        f2055a.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextViewCompatApi26Impl extends TextViewCompatApi23Impl {
        TextViewCompatApi26Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
            int i = Build.VERSION.SDK_INT;
            if (i != 26 && i != 27) {
                super.setCustomSelectionActionModeCallback(textView, callback);
            } else {
                textView.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: android.support.v4.widget.TextViewCompat.TextViewCompatApi26Impl.1

                    /* renamed from: a */
                    private Class f2056a;

                    /* renamed from: b */
                    private Method f2057b;

                    /* renamed from: c */
                    private boolean f2058c;

                    /* renamed from: d */
                    private boolean f2059d = false;

                    /* renamed from: e */
                    final /* synthetic */ ActionMode.Callback f2060e;

                    /* renamed from: f */
                    final /* synthetic */ TextView f2061f;

                    AnonymousClass1(ActionMode.Callback callback2, TextView textView2) {
                        callback = callback2;
                        textView = textView2;
                    }

                    private void a(Menu menu) {
                        Context context = textView.getContext();
                        PackageManager packageManager = context.getPackageManager();
                        if (!this.f2059d) {
                            this.f2059d = true;
                            try {
                                this.f2056a = Class.forName("com.android.internal.view.menu.MenuBuilder");
                                this.f2057b = this.f2056a.getDeclaredMethod("removeItemAt", Integer.TYPE);
                                this.f2058c = true;
                            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                                this.f2056a = null;
                                this.f2057b = null;
                                this.f2058c = false;
                            }
                        }
                        try {
                            Method declaredMethod = (this.f2058c && this.f2056a.isInstance(menu)) ? this.f2057b : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                            for (int size = menu.size() - 1; size >= 0; size--) {
                                MenuItem item = menu.getItem(size);
                                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                                    declaredMethod.invoke(menu, Integer.valueOf(size));
                                }
                            }
                            List<ResolveInfo> a2 = a(context, packageManager);
                            for (int i2 = 0; i2 < a2.size(); i2++) {
                                ResolveInfo resolveInfo = a2.get(i2);
                                menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(a(resolveInfo, textView)).setShowAsAction(1);
                            }
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                        }
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                        return callback.onActionItemClicked(actionMode, menuItem);
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                        return callback.onCreateActionMode(actionMode, menu);
                    }

                    @Override // android.view.ActionMode.Callback
                    public void onDestroyActionMode(ActionMode actionMode) {
                        callback.onDestroyActionMode(actionMode);
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                        a(menu);
                        return callback.onPrepareActionMode(actionMode, menu);
                    }

                    private List<ResolveInfo> a(Context context, PackageManager packageManager) {
                        ArrayList arrayList = new ArrayList();
                        if (!(context instanceof Activity)) {
                            return arrayList;
                        }
                        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                            if (a(resolveInfo, context)) {
                                arrayList.add(resolveInfo);
                            }
                        }
                        return arrayList;
                    }

                    private boolean a(ResolveInfo resolveInfo, Context context) {
                        if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                            return true;
                        }
                        if (!resolveInfo.activityInfo.exported) {
                            return false;
                        }
                        String str = resolveInfo.activityInfo.permission;
                        return str == null || context.checkSelfPermission(str) == 0;
                    }

                    private Intent a(ResolveInfo resolveInfo, TextView textView2) {
                        return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !a(textView2)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    }

                    private boolean a(TextView textView2) {
                        return (textView2 instanceof Editable) && textView2.onCheckIsTextEditor() && textView2.isEnabled();
                    }

                    private Intent a() {
                        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
                    }
                });
            }
        }

        /* renamed from: android.support.v4.widget.TextViewCompat$TextViewCompatApi26Impl$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements ActionMode.Callback {

            /* renamed from: a */
            private Class f2056a;

            /* renamed from: b */
            private Method f2057b;

            /* renamed from: c */
            private boolean f2058c;

            /* renamed from: d */
            private boolean f2059d = false;

            /* renamed from: e */
            final /* synthetic */ ActionMode.Callback f2060e;

            /* renamed from: f */
            final /* synthetic */ TextView f2061f;

            AnonymousClass1(ActionMode.Callback callback2, TextView textView2) {
                callback = callback2;
                textView = textView2;
            }

            private void a(Menu menu) {
                Context context = textView.getContext();
                PackageManager packageManager = context.getPackageManager();
                if (!this.f2059d) {
                    this.f2059d = true;
                    try {
                        this.f2056a = Class.forName("com.android.internal.view.menu.MenuBuilder");
                        this.f2057b = this.f2056a.getDeclaredMethod("removeItemAt", Integer.TYPE);
                        this.f2058c = true;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        this.f2056a = null;
                        this.f2057b = null;
                        this.f2058c = false;
                    }
                }
                try {
                    Method declaredMethod = (this.f2058c && this.f2056a.isInstance(menu)) ? this.f2057b : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                    for (int size = menu.size() - 1; size >= 0; size--) {
                        MenuItem item = menu.getItem(size);
                        if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                            declaredMethod.invoke(menu, Integer.valueOf(size));
                        }
                    }
                    List<ResolveInfo> a2 = a(context, packageManager);
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        ResolveInfo resolveInfo = a2.get(i2);
                        menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(a(resolveInfo, textView)).setShowAsAction(1);
                    }
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return callback.onActionItemClicked(actionMode, menuItem);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return callback.onCreateActionMode(actionMode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                callback.onDestroyActionMode(actionMode);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                a(menu);
                return callback.onPrepareActionMode(actionMode, menu);
            }

            private List<ResolveInfo> a(Context context, PackageManager packageManager) {
                ArrayList arrayList = new ArrayList();
                if (!(context instanceof Activity)) {
                    return arrayList;
                }
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                    if (a(resolveInfo, context)) {
                        arrayList.add(resolveInfo);
                    }
                }
                return arrayList;
            }

            private boolean a(ResolveInfo resolveInfo, Context context) {
                if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
                if (!resolveInfo.activityInfo.exported) {
                    return false;
                }
                String str = resolveInfo.activityInfo.permission;
                return str == null || context.checkSelfPermission(str) == 0;
            }

            private Intent a(ResolveInfo resolveInfo, TextView textView2) {
                return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !a(textView2)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            }

            private boolean a(TextView textView2) {
                return (textView2 instanceof Editable) && textView2.onCheckIsTextEditor() && textView2.isEnabled();
            }

            private Intent a() {
                return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
            }
        }
    }
}
