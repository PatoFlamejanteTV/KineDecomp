package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    @VisibleForTesting
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zai CREATOR = new zai();

        /* renamed from: a */
        private final int f11202a;

        /* renamed from: b */
        protected final int f11203b;

        /* renamed from: c */
        protected final boolean f11204c;

        /* renamed from: d */
        protected final int f11205d;

        /* renamed from: e */
        protected final boolean f11206e;

        /* renamed from: f */
        protected final String f11207f;

        /* renamed from: g */
        protected final int f11208g;

        /* renamed from: h */
        protected final Class<? extends FastJsonResponse> f11209h;
        private final String i;
        private zak j;
        private FieldConverter<I, O> k;

        @SafeParcelable.Constructor
        public Field(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) zaa zaaVar) {
            this.f11202a = i;
            this.f11203b = i2;
            this.f11204c = z;
            this.f11205d = i3;
            this.f11206e = z2;
            this.f11207f = str;
            this.f11208g = i4;
            if (str2 == null) {
                this.f11209h = null;
                this.i = null;
            } else {
                this.f11209h = SafeParcelResponse.class;
                this.i = str2;
            }
            if (zaaVar == null) {
                this.k = null;
            } else {
                this.k = (FieldConverter<I, O>) zaaVar.a();
            }
        }

        private final String Q() {
            String str = this.i;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa R() {
            FieldConverter<I, O> fieldConverter = this.k;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.a(fieldConverter);
        }

        @KeepForSdk
        public static Field<String, String> c(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> d(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public final boolean O() {
            return this.k != null;
        }

        public final Map<String, Field<?, ?>> P() {
            Preconditions.a(this.i);
            Preconditions.a(this.j);
            return this.j.e(this.i);
        }

        @KeepForSdk
        public int a() {
            return this.f11208g;
        }

        public final I b(O o) {
            return this.k.b(o);
        }

        public String toString() {
            Objects.ToStringHelper a2 = Objects.a(this).a("versionCode", Integer.valueOf(this.f11202a)).a("typeIn", Integer.valueOf(this.f11203b)).a("typeInArray", Boolean.valueOf(this.f11204c)).a("typeOut", Integer.valueOf(this.f11205d)).a("typeOutArray", Boolean.valueOf(this.f11206e)).a("outputFieldName", this.f11207f).a("safeParcelFieldId", Integer.valueOf(this.f11208g)).a("concreteTypeName", Q());
            Class<? extends FastJsonResponse> cls = this.f11209h;
            if (cls != null) {
                a2.a("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.k;
            if (fieldConverter != null) {
                a2.a("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return a2.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int a2 = SafeParcelWriter.a(parcel);
            SafeParcelWriter.a(parcel, 1, this.f11202a);
            SafeParcelWriter.a(parcel, 2, this.f11203b);
            SafeParcelWriter.a(parcel, 3, this.f11204c);
            SafeParcelWriter.a(parcel, 4, this.f11205d);
            SafeParcelWriter.a(parcel, 5, this.f11206e);
            SafeParcelWriter.a(parcel, 6, this.f11207f, false);
            SafeParcelWriter.a(parcel, 7, a());
            SafeParcelWriter.a(parcel, 8, Q(), false);
            SafeParcelWriter.a(parcel, 9, (Parcelable) R(), i, false);
            SafeParcelWriter.a(parcel, a2);
        }

        @VisibleForTesting
        @KeepForSdk
        public static Field<Integer, Integer> b(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public final void a(zak zakVar) {
            this.j = zakVar;
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> b(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public final O a(I i) {
            return this.k.a(i);
        }

        @VisibleForTesting
        @KeepForSdk
        public static Field<byte[], byte[]> a(String str, int i) {
            return new Field<>(8, false, 8, false, str, i, null, null);
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> a(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        private Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            this.f11202a = 1;
            this.f11203b = i;
            this.f11204c = z;
            this.f11205d = i2;
            this.f11206e = z2;
            this.f11207f = str;
            this.f11208g = i3;
            this.f11209h = cls;
            if (cls == null) {
                this.i = null;
            } else {
                this.i = cls.getCanonicalName();
            }
            this.k = fieldConverter;
        }
    }

    @ShowFirstParty
    /* loaded from: classes.dex */
    public interface FieldConverter<I, O> {
        O a(I i);

        I b(O o);
    }

    private final <I, O> void zaa(Field<I, O> field, I i) {
        String str = field.f11207f;
        O a2 = field.a((Field<I, O>) i);
        int i2 = field.f11205d;
        switch (i2) {
            case 0:
                if (zaa(str, a2)) {
                    setIntegerInternal(field, str, ((Integer) a2).intValue());
                    return;
                }
                return;
            case 1:
                zaa((Field<?, ?>) field, str, (BigInteger) a2);
                return;
            case 2:
                if (zaa(str, a2)) {
                    setLongInternal(field, str, ((Long) a2).longValue());
                    return;
                }
                return;
            case 3:
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unsupported type for conversion: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            case 4:
                if (zaa(str, a2)) {
                    zaa((Field<?, ?>) field, str, ((Double) a2).doubleValue());
                    return;
                }
                return;
            case 5:
                zaa((Field<?, ?>) field, str, (BigDecimal) a2);
                return;
            case 6:
                if (zaa(str, a2)) {
                    setBooleanInternal(field, str, ((Boolean) a2).booleanValue());
                    return;
                }
                return;
            case 7:
                setStringInternal(field, str, (String) a2);
                return;
            case 8:
            case 9:
                if (zaa(str, a2)) {
                    setDecodedBytesInternal(field, str, (byte[]) a2);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <O, I> I zab(Field<I, O> field, Object obj) {
        return ((Field) field).k != null ? field.b(obj) : obj;
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @KeepForSdk
    public Object getFieldValue(Field field) {
        String str = field.f11207f;
        if (field.f11209h != null) {
            Preconditions.b(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.f11207f);
            boolean z = field.f11206e;
            try {
                char upperCase = Character.toUpperCase(str.charAt(0));
                String substring = str.substring(1);
                StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
                sb.append("get");
                sb.append(upperCase);
                sb.append(substring);
                return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return getValueObject(str);
    }

    @KeepForSdk
    protected abstract Object getValueObject(String str);

    @KeepForSdk
    public boolean isFieldSet(Field field) {
        if (field.f11205d == 11) {
            if (field.f11206e) {
                String str = field.f11207f;
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            String str2 = field.f11207f;
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return isPrimitiveFieldSet(field.f11207f);
    }

    @KeepForSdk
    protected abstract boolean isPrimitiveFieldSet(String str);

    @KeepForSdk
    protected void setBooleanInternal(Field<?, ?> field, String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    protected void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @KeepForSdk
    protected void setIntegerInternal(Field<?, ?> field, String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    protected void setLongInternal(Field<?, ?> field, String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    protected void setStringInternal(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @KeepForSdk
    protected void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object zab = zab(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (zab == null) {
                    sb.append("null");
                } else {
                    switch (field.f11205d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.a((byte[]) zab));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.b((byte[]) zab));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.a(sb, (HashMap) zab);
                            break;
                        default:
                            if (field.f11204c) {
                                ArrayList arrayList = (ArrayList) zab;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        zaa(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                zaa(sb, field, zab);
                                break;
                            }
                    }
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

    public final <O> void zac(Field<ArrayList<Long>, O> field, ArrayList<Long> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<Long>, O>, O>) field, (Field<ArrayList<Long>, O>) arrayList);
        } else {
            zac(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zad(Field<ArrayList<Float>, O> field, ArrayList<Float> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<Float>, O>, O>) field, (Field<ArrayList<Float>, O>) arrayList);
        } else {
            zad(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zae(Field<ArrayList<Double>, O> field, ArrayList<Double> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<Double>, O>, O>) field, (Field<ArrayList<Double>, O>) arrayList);
        } else {
            zae(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zaf(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<BigDecimal>, O>, O>) field, (Field<ArrayList<BigDecimal>, O>) arrayList);
        } else {
            zaf(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zag(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<Boolean>, O>, O>) field, (Field<ArrayList<Boolean>, O>) arrayList);
        } else {
            zag(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zah(Field<ArrayList<String>, O> field, ArrayList<String> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<String>, O>, O>) field, (Field<ArrayList<String>, O>) arrayList);
        } else {
            setStringsInternal(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zab(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<BigInteger>, O>, O>) field, (Field<ArrayList<BigInteger>, O>) arrayList);
        } else {
            zab(field, field.f11207f, arrayList);
        }
    }

    protected void zac(Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    protected void zad(Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    protected void zae(Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    protected void zaf(Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    protected void zag(Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    protected void zab(Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final <O> void zaa(Field<Integer, O> field, int i) {
        if (((Field) field).k != null) {
            zaa((Field<Field<Integer, O>, O>) field, (Field<Integer, O>) Integer.valueOf(i));
        } else {
            setIntegerInternal(field, field.f11207f, i);
        }
    }

    public final <O> void zaa(Field<ArrayList<Integer>, O> field, ArrayList<Integer> arrayList) {
        if (((Field) field).k != null) {
            zaa((Field<Field<ArrayList<Integer>, O>, O>) field, (Field<ArrayList<Integer>, O>) arrayList);
        } else {
            zaa(field, field.f11207f, arrayList);
        }
    }

    public final <O> void zaa(Field<BigInteger, O> field, BigInteger bigInteger) {
        if (((Field) field).k != null) {
            zaa((Field<Field<BigInteger, O>, O>) field, (Field<BigInteger, O>) bigInteger);
        } else {
            zaa(field, field.f11207f, bigInteger);
        }
    }

    public final <O> void zaa(Field<Long, O> field, long j) {
        if (((Field) field).k != null) {
            zaa((Field<Field<Long, O>, O>) field, (Field<Long, O>) Long.valueOf(j));
        } else {
            setLongInternal(field, field.f11207f, j);
        }
    }

    public final <O> void zaa(Field<Float, O> field, float f2) {
        if (((Field) field).k != null) {
            zaa((Field<Field<Float, O>, O>) field, (Field<Float, O>) Float.valueOf(f2));
        } else {
            zaa((Field<?, ?>) field, field.f11207f, f2);
        }
    }

    public final <O> void zaa(Field<Double, O> field, double d2) {
        if (((Field) field).k != null) {
            zaa((Field<Field<Double, O>, O>) field, (Field<Double, O>) Double.valueOf(d2));
        } else {
            zaa(field, field.f11207f, d2);
        }
    }

    public final <O> void zaa(Field<BigDecimal, O> field, BigDecimal bigDecimal) {
        if (((Field) field).k != null) {
            zaa((Field<Field<BigDecimal, O>, O>) field, (Field<BigDecimal, O>) bigDecimal);
        } else {
            zaa(field, field.f11207f, bigDecimal);
        }
    }

    public final <O> void zaa(Field<Boolean, O> field, boolean z) {
        if (((Field) field).k != null) {
            zaa((Field<Field<Boolean, O>, O>) field, (Field<Boolean, O>) Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.f11207f, z);
        }
    }

    public final <O> void zaa(Field<String, O> field, String str) {
        if (((Field) field).k != null) {
            zaa((Field<Field<String, O>, O>) field, (Field<String, O>) str);
        } else {
            setStringInternal(field, field.f11207f, str);
        }
    }

    public final <O> void zaa(Field<byte[], O> field, byte[] bArr) {
        if (((Field) field).k != null) {
            zaa((Field<Field<byte[], O>, O>) field, (Field<byte[], O>) bArr);
        } else {
            setDecodedBytesInternal(field, field.f11207f, bArr);
        }
    }

    public final <O> void zaa(Field<Map<String, String>, O> field, Map<String, String> map) {
        if (((Field) field).k != null) {
            zaa((Field<Field<Map<String, String>, O>, O>) field, (Field<Map<String, String>, O>) map);
        } else {
            zaa(field, field.f11207f, map);
        }
    }

    protected void zaa(Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    protected void zaa(Field<?, ?> field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    protected void zaa(Field<?, ?> field, String str, float f2) {
        throw new UnsupportedOperationException("Float not supported");
    }

    protected void zaa(Field<?, ?> field, String str, double d2) {
        throw new UnsupportedOperationException("Double not supported");
    }

    protected void zaa(Field<?, ?> field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    protected void zaa(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    private static <O> boolean zaa(String str, O o) {
        if (o != null) {
            return true;
        }
        if (!Log.isLoggable("FastJsonResponse", 6)) {
            return false;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58);
        sb.append("Output field (");
        sb.append(str);
        sb.append(") has a null value, but expected a primitive");
        Log.e("FastJsonResponse", sb.toString());
        return false;
    }

    private static void zaa(StringBuilder sb, Field field, Object obj) {
        int i = field.f11203b;
        if (i == 11) {
            sb.append(field.f11209h.cast(obj).toString());
        } else {
            if (i == 7) {
                sb.append("\"");
                sb.append(JsonUtils.a((String) obj));
                sb.append("\"");
                return;
            }
            sb.append(obj);
        }
    }
}
