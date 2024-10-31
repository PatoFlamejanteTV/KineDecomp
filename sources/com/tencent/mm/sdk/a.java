package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.sdk.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class a implements SharedPreferences {

    /* renamed from: a */
    private final ContentResolver f25752a;

    /* renamed from: b */
    private final String[] f25753b = {"_id", "key", "type", "value"};

    /* renamed from: c */
    private final HashMap<String, Object> f25754c = new HashMap<>();

    /* renamed from: d */
    private SharedPreferencesEditorC0132a f25755d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.mm.sdk.a$a */
    /* loaded from: classes3.dex */
    public static class SharedPreferencesEditorC0132a implements SharedPreferences.Editor {

        /* renamed from: a */
        private ContentResolver f25756a;

        /* renamed from: e */
        private Map<String, Object> f25757e = new HashMap();

        /* renamed from: f */
        private Set<String> f25758f = new HashSet();

        /* renamed from: g */
        private boolean f25759g = false;

        public SharedPreferencesEditorC0132a(ContentResolver contentResolver) {
            this.f25756a = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f25759g = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ae A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean commit() {
            /*
                r10 = this;
                android.content.ContentValues r0 = new android.content.ContentValues
                r0.<init>()
                boolean r1 = r10.f25759g
                r2 = 0
                if (r1 == 0) goto L14
                android.content.ContentResolver r1 = r10.f25756a
                android.net.Uri r3 = com.tencent.mm.sdk.c.a.b.CONTENT_URI
                r4 = 0
                r1.delete(r3, r4, r4)
                r10.f25759g = r2
            L14:
                java.util.Set<java.lang.String> r1 = r10.f25758f
                java.util.Iterator r1 = r1.iterator()
            L1a:
                boolean r3 = r1.hasNext()
                java.lang.String r4 = "key = ?"
                r5 = 1
                if (r3 == 0) goto L35
                java.lang.Object r3 = r1.next()
                java.lang.String r3 = (java.lang.String) r3
                android.content.ContentResolver r6 = r10.f25756a
                android.net.Uri r7 = com.tencent.mm.sdk.c.a.b.CONTENT_URI
                java.lang.String[] r5 = new java.lang.String[r5]
                r5[r2] = r3
                r6.delete(r7, r4, r5)
                goto L1a
            L35:
                java.util.Map<java.lang.String, java.lang.Object> r1 = r10.f25757e
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L3f:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto Lc1
                java.lang.Object r3 = r1.next()
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r6 = r3.getValue()
                java.lang.String r7 = "MicroMsg.SDK.PluginProvider.Resolver"
                if (r6 != 0) goto L5a
                java.lang.String r8 = "unresolve failed, null value"
            L55:
                com.tencent.mm.sdk.b.a.a(r7, r8)
                r7 = 0
                goto L95
            L5a:
                boolean r8 = r6 instanceof java.lang.Integer
                if (r8 == 0) goto L60
                r7 = 1
                goto L95
            L60:
                boolean r8 = r6 instanceof java.lang.Long
                if (r8 == 0) goto L66
                r7 = 2
                goto L95
            L66:
                boolean r8 = r6 instanceof java.lang.String
                if (r8 == 0) goto L6c
                r7 = 3
                goto L95
            L6c:
                boolean r8 = r6 instanceof java.lang.Boolean
                if (r8 == 0) goto L72
                r7 = 4
                goto L95
            L72:
                boolean r8 = r6 instanceof java.lang.Float
                if (r8 == 0) goto L78
                r7 = 5
                goto L95
            L78:
                boolean r8 = r6 instanceof java.lang.Double
                if (r8 == 0) goto L7e
                r7 = 6
                goto L95
            L7e:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "unresolve failed, unknown type="
                r8.<init>(r9)
                java.lang.Class r9 = r6.getClass()
                java.lang.String r9 = r9.toString()
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                goto L55
            L95:
                if (r7 != 0) goto L99
                r6 = 0
                goto Lac
            L99:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r8 = "type"
                r0.put(r8, r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r7 = "value"
                r0.put(r7, r6)
                r6 = 1
            Lac:
                if (r6 == 0) goto L3f
                android.content.ContentResolver r6 = r10.f25756a
                android.net.Uri r7 = com.tencent.mm.sdk.c.a.b.CONTENT_URI
                java.lang.String[] r8 = new java.lang.String[r5]
                java.lang.Object r3 = r3.getKey()
                java.lang.String r3 = (java.lang.String) r3
                r8[r2] = r3
                r6.update(r7, r0, r4, r8)
                goto L3f
            Lc1:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.a.SharedPreferencesEditorC0132a.commit():boolean");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f25757e.put(str, Boolean.valueOf(z));
            this.f25758f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f2) {
            this.f25757e.put(str, Float.valueOf(f2));
            this.f25758f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            this.f25757e.put(str, Integer.valueOf(i));
            this.f25758f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.f25757e.put(str, Long.valueOf(j));
            this.f25758f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.f25757e.put(str, str2);
            this.f25758f.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            this.f25758f.add(str);
            return this;
        }
    }

    public a(Context context) {
        this.f25752a = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.f25752a.query(a.b.CONTENT_URI, this.f25753b, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object a2 = query.moveToFirst() ? a.C0136a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        if (this.f25755d == null) {
            this.f25755d = new SharedPreferencesEditorC0132a(this.f25752a);
        }
        return this.f25755d;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        try {
            Cursor query = this.f25752a.query(a.b.CONTENT_URI, this.f25753b, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.f25754c.put(query.getString(columnIndex), a.C0136a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.f25754c;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f25754c;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f2 : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
