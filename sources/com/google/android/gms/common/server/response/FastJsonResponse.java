package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    /* loaded from: classes.dex */
    public static class Field<I, O> implements SafeParcelable {
        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();

        /* renamed from: a, reason: collision with root package name */
        protected final int f1033a;
        protected final boolean b;
        protected final int c;
        protected final boolean d;
        protected final String e;
        protected final int f;
        protected final Class<? extends FastJsonResponse> g;
        protected final String h;
        private final int i;
        private FieldMappingDictionary j;
        private zza<I, O> k;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.i = i;
            this.f1033a = i2;
            this.b = z;
            this.c = i3;
            this.d = z2;
            this.e = str;
            this.f = i4;
            if (str2 == null) {
                this.g = null;
                this.h = null;
            } else {
                this.g = SafeParcelResponse.class;
                this.h = str2;
            }
            if (converterWrapper == null) {
                this.k = null;
            } else {
                this.k = (zza<I, O>) converterWrapper.c();
            }
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zzaVar) {
            this.i = 1;
            this.f1033a = i;
            this.b = z;
            this.c = i2;
            this.d = z2;
            this.e = str;
            this.f = i3;
            this.g = cls;
            if (cls == null) {
                this.h = null;
            } else {
                this.h = cls.getCanonicalName();
            }
            this.k = zzaVar;
        }

        public static Field<Integer, Integer> a(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field a(String str, int i, zza<?, ?> zzaVar, boolean z) {
            return new Field(zzaVar.c(), z, zzaVar.d(), false, str, i, null, zzaVar);
        }

        public static <T extends FastJsonResponse> Field<T, T> a(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static Field<Double, Double> b(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> b(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Boolean, Boolean> c(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> d(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> e(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public Field<I, O> a() {
            return new Field<>(this.i, this.f1033a, this.b, this.c, this.d, this.e, this.f, this.h, l());
        }

        public I a(O o) {
            return this.k.a(o);
        }

        public void a(FieldMappingDictionary fieldMappingDictionary) {
            this.j = fieldMappingDictionary;
        }

        public int b() {
            return this.i;
        }

        public int c() {
            return this.f1033a;
        }

        public boolean d() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            return 0;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }

        public String g() {
            return this.e;
        }

        public int h() {
            return this.f;
        }

        public Class<? extends FastJsonResponse> i() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String j() {
            if (this.h == null) {
                return null;
            }
            return this.h;
        }

        public boolean k() {
            return this.k != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConverterWrapper l() {
            if (this.k == null) {
                return null;
            }
            return ConverterWrapper.a(this.k);
        }

        public Map<String, Field<?, ?>> m() {
            zzx.a(this.h);
            zzx.a(this.j);
            return this.j.a(this.h);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.i).append('\n');
            sb.append("                 typeIn=").append(this.f1033a).append('\n');
            sb.append("            typeInArray=").append(this.b).append('\n');
            sb.append("                typeOut=").append(this.c).append('\n');
            sb.append("           typeOutArray=").append(this.d).append('\n');
            sb.append("        outputFieldName=").append(this.e).append('\n');
            sb.append("      safeParcelFieldId=").append(this.f).append('\n');
            sb.append("       concreteTypeName=").append(j()).append('\n');
            if (i() != null) {
                sb.append("     concreteType.class=").append(i().getCanonicalName()).append('\n');
            }
            sb.append("          converterName=").append(this.k == null ? "null" : this.k.getClass().getCanonicalName()).append('\n');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            com.google.android.gms.common.server.response.zza.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public interface zza<I, O> {
        I a(O o);

        int c();

        int d();
    }

    private void a(StringBuilder sb, Field field, Object obj) {
        if (field.c() == 11) {
            sb.append(field.i().cast(obj).toString());
        } else {
            if (field.c() != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(zzmu.zzcz((String) obj));
            sb.append("\"");
        }
    }

    private void a(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(sb, field, obj);
            }
        }
        sb.append("]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public <O, I> I a(Field<I, O> field, Object obj) {
        return ((Field) field).k != null ? field.a((Field<I, O>) obj) : obj;
    }

    protected abstract Object a(String str);

    protected boolean a(Field field) {
        return field.e() == 11 ? field.f() ? d(field.g()) : c(field.g()) : b(field.g());
    }

    protected Object b(Field field) {
        String g = field.g();
        if (field.i() == null) {
            return a(field.g());
        }
        zzx.a(a(field.g()) == null, "Concrete field shouldn't be value object: %s", field.g());
        HashMap<String, Object> d = field.f() ? d() : c();
        if (d != null) {
            return d.get(g);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(g.charAt(0)) + g.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Map<String, Field<?, ?>> b();

    protected abstract boolean b(String str);

    public HashMap<String, Object> c() {
        return null;
    }

    protected boolean c(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public HashMap<String, Object> d() {
        return null;
    }

    protected boolean d(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        Map<String, Field<?, ?>> b = b();
        StringBuilder sb = new StringBuilder(100);
        for (String str : b.keySet()) {
            Field<?, ?> field = b.get(str);
            if (a(field)) {
                Object a2 = a(field, b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (a2 != null) {
                    switch (field.e()) {
                        case 8:
                            sb.append("\"").append(zzmk.zzi((byte[]) a2)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzmk.zzj((byte[]) a2)).append("\"");
                            break;
                        case 10:
                            zzmv.zza(sb, (HashMap) a2);
                            break;
                        default:
                            if (field.d()) {
                                a(sb, (Field) field, (ArrayList<Object>) a2);
                                break;
                            } else {
                                a(sb, field, a2);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
