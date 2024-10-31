package com.mixpanel.android.mpmetrics;

import android.R;
import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ResourceReader.java */
/* loaded from: classes.dex */
public abstract class z implements y {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3051a;
    private final Map<String, Integer> b = new HashMap();
    private final SparseArray<String> c = new SparseArray<>();

    protected abstract Class<?> a();

    protected abstract String a(Context context);

    /* compiled from: ResourceReader.java */
    /* loaded from: classes.dex */
    public static class a extends z {

        /* renamed from: a, reason: collision with root package name */
        private final String f3052a;

        public a(String str, Context context) {
            super(context);
            this.f3052a = str;
            b();
        }

        @Override // com.mixpanel.android.mpmetrics.z
        protected Class<?> a() {
            return R.id.class;
        }

        @Override // com.mixpanel.android.mpmetrics.z
        protected String a(Context context) {
            return this.f3052a + ".R$id";
        }
    }

    protected z(Context context) {
        this.f3051a = context;
    }

    @Override // com.mixpanel.android.mpmetrics.y
    public boolean a(String str) {
        return this.b.containsKey(str);
    }

    @Override // com.mixpanel.android.mpmetrics.y
    public int b(String str) {
        return this.b.get(str).intValue();
    }

    @Override // com.mixpanel.android.mpmetrics.y
    public String a(int i) {
        return this.c.get(i);
    }

    private static void a(Class<?> cls, String str, Map<String, Integer> map) {
        try {
            for (Field field : cls.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    String name = field.getName();
                    int i = field.getInt(null);
                    if (str != null) {
                        name = str + ":" + name;
                    }
                    map.put(name, Integer.valueOf(i));
                }
            }
        } catch (IllegalAccessException e) {
            Log.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + cls.getName(), e);
        }
    }

    protected void b() {
        this.b.clear();
        this.c.clear();
        a(a(), "android", this.b);
        String a2 = a(this.f3051a);
        try {
            a(Class.forName(a2), null, this.b);
        } catch (ClassNotFoundException e) {
            Log.w("MixpanelAPI.RsrcReader", "Can't load names for Android view ids from '" + a2 + "', ids by name will not be available in the events editor.");
            Log.i("MixpanelAPI.RsrcReader", "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
            this.c.put(entry.getValue().intValue(), entry.getKey());
        }
    }
}
