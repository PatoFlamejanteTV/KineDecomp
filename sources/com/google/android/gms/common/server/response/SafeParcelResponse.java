package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();

    /* renamed from: a */
    private final int f11218a;

    /* renamed from: b */
    private final Parcel f11219b;

    /* renamed from: c */
    private final int f11220c;

    /* renamed from: d */
    private final zak f11221d;

    /* renamed from: e */
    private final String f11222e;

    /* renamed from: f */
    private int f11223f;

    /* renamed from: g */
    private int f11224g;

    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zak zakVar) {
        this.f11218a = i;
        Preconditions.a(parcel);
        this.f11219b = parcel;
        this.f11220c = 2;
        this.f11221d = zakVar;
        zak zakVar2 = this.f11221d;
        if (zakVar2 == null) {
            this.f11222e = null;
        } else {
            this.f11222e = zakVar2.O();
        }
        this.f11223f = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:            if (r0 != 1) goto L20;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Parcel a() {
        /*
            r2 = this;
            int r0 = r2.f11223f
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.f11219b
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.a(r0)
            r2.f11224g = r0
        L10:
            android.os.Parcel r0 = r2.f11219b
            int r1 = r2.f11224g
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.a(r0, r1)
            r0 = 2
            r2.f11223f = r0
        L1a:
            android.os.Parcel r0 = r2.f11219b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.a():android.os.Parcel");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        a(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            T t = arrayList.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) t).a());
        }
        SafeParcelWriter.b(this.f11219b, field.a(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), ((SafeParcelResponse) t).a(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zak zakVar = this.f11221d;
        if (zakVar == null) {
            return null;
        }
        return zakVar.e(this.f11222e);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), z);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), j);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        a(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.a(this.f11219b, field.a(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        Preconditions.a(this.f11221d, "Cannot convert to JSON on client side.");
        Parcel a2 = a();
        a2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.f11221d.e(this.f11222e), a2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zak zakVar;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11218a);
        SafeParcelWriter.a(parcel, 2, a(), false);
        int i2 = this.f11220c;
        if (i2 == 0) {
            zakVar = null;
        } else if (i2 == 1) {
            zakVar = this.f11221d;
        } else if (i2 == 2) {
            zakVar = this.f11221d;
        } else {
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        SafeParcelWriter.a(parcel, 3, (Parcelable) zakVar, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        a(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.a(this.f11219b, field.a(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zab(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        a(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.a(this.f11219b, field.a(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zac(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        a(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.a(this.f11219b, field.a(), jArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zad(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        a(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.a(this.f11219b, field.a(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zae(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        a(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.a(this.f11219b, field.a(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaf(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        a(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.a(this.f11219b, field.a(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zag(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        a(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.a(this.f11219b, field.a(), zArr, true);
    }

    private final void a(FastJsonResponse.Field<?, ?> field) {
        if (field.f11208g != -1) {
            Parcel parcel = this.f11219b;
            if (parcel != null) {
                int i = this.f11223f;
                if (i == 0) {
                    this.f11224g = SafeParcelWriter.a(parcel);
                    this.f11223f = 1;
                    return;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                        }
                        throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                    }
                    return;
                }
            }
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, float f2) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), f2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, double d2) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), d2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        a(field);
        SafeParcelWriter.a(this.f11219b, field.a(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        a(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.a(this.f11219b, field.a(), bundle, true);
    }

    private final void a(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().a(), entry);
        }
        sb.append('{');
        int b2 = SafeParcelReader.b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.a(a2));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.O()) {
                    int i = field.f11205d;
                    switch (i) {
                        case 0:
                            a(sb, field, FastJsonResponse.zab(field, Integer.valueOf(SafeParcelReader.A(parcel, a2))));
                            break;
                        case 1:
                            a(sb, field, FastJsonResponse.zab(field, SafeParcelReader.c(parcel, a2)));
                            break;
                        case 2:
                            a(sb, field, FastJsonResponse.zab(field, Long.valueOf(SafeParcelReader.C(parcel, a2))));
                            break;
                        case 3:
                            a(sb, field, FastJsonResponse.zab(field, Float.valueOf(SafeParcelReader.x(parcel, a2))));
                            break;
                        case 4:
                            a(sb, field, FastJsonResponse.zab(field, Double.valueOf(SafeParcelReader.v(parcel, a2))));
                            break;
                        case 5:
                            a(sb, field, FastJsonResponse.zab(field, SafeParcelReader.a(parcel, a2)));
                            break;
                        case 6:
                            a(sb, field, FastJsonResponse.zab(field, Boolean.valueOf(SafeParcelReader.t(parcel, a2))));
                            break;
                        case 7:
                            a(sb, field, FastJsonResponse.zab(field, SafeParcelReader.p(parcel, a2)));
                            break;
                        case 8:
                        case 9:
                            a(sb, field, FastJsonResponse.zab(field, SafeParcelReader.g(parcel, a2)));
                            break;
                        case 10:
                            Bundle f2 = SafeParcelReader.f(parcel, a2);
                            HashMap hashMap = new HashMap();
                            for (String str2 : f2.keySet()) {
                                hashMap.put(str2, f2.getString(str2));
                            }
                            a(sb, field, FastJsonResponse.zab(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f11206e) {
                    sb.append("[");
                    switch (field.f11205d) {
                        case 0:
                            ArrayUtils.a(sb, SafeParcelReader.k(parcel, a2));
                            break;
                        case 1:
                            ArrayUtils.a(sb, SafeParcelReader.d(parcel, a2));
                            break;
                        case 2:
                            ArrayUtils.a(sb, SafeParcelReader.m(parcel, a2));
                            break;
                        case 3:
                            ArrayUtils.a(sb, SafeParcelReader.j(parcel, a2));
                            break;
                        case 4:
                            ArrayUtils.a(sb, SafeParcelReader.i(parcel, a2));
                            break;
                        case 5:
                            ArrayUtils.a(sb, SafeParcelReader.b(parcel, a2));
                            break;
                        case 6:
                            ArrayUtils.a(sb, SafeParcelReader.e(parcel, a2));
                            break;
                        case 7:
                            ArrayUtils.a(sb, SafeParcelReader.q(parcel, a2));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] o = SafeParcelReader.o(parcel, a2);
                            int length = o.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (i2 > 0) {
                                    sb.append(",");
                                }
                                o[i2].setDataPosition(0);
                                a(sb, field.P(), o[i2]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f11205d) {
                        case 0:
                            sb.append(SafeParcelReader.A(parcel, a2));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, a2));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.C(parcel, a2));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.x(parcel, a2));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.v(parcel, a2));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, a2));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.t(parcel, a2));
                            break;
                        case 7:
                            String p = SafeParcelReader.p(parcel, a2);
                            sb.append("\"");
                            sb.append(JsonUtils.a(p));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] g2 = SafeParcelReader.g(parcel, a2);
                            sb.append("\"");
                            sb.append(Base64Utils.a(g2));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] g3 = SafeParcelReader.g(parcel, a2);
                            sb.append("\"");
                            sb.append(Base64Utils.b(g3));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle f3 = SafeParcelReader.f(parcel, a2);
                            Set<String> keySet = f3.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str3 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(JsonUtils.a(f3.getString(str3)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel n = SafeParcelReader.n(parcel, a2);
                            n.setDataPosition(0);
                            a(sb, field.P(), n);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == b2) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(b2);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f11204c) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                a(sb, field.f11203b, arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        a(sb, field.f11203b, obj);
    }

    private static void a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }
}
