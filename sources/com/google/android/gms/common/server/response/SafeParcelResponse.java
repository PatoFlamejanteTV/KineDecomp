package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    private final int f1037a;
    private final Parcel b;
    private final int c;
    private final FieldMappingDictionary d;
    private final String e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.f1037a = i;
        this.b = (Parcel) zzx.a(parcel);
        this.c = 2;
        this.d = fieldMappingDictionary;
        if (this.d == null) {
            this.e = null;
        } else {
            this.e = this.d.e();
        }
        this.f = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        this.f1037a = 1;
        this.b = Parcel.obtain();
        safeParcelable.writeToParcel(this.b, 0);
        this.c = 1;
        this.d = (FieldMappingDictionary) zzx.a(fieldMappingDictionary);
        this.e = (String) zzx.a(str);
        this.f = 2;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse(t, b(t), canonicalName);
    }

    public static HashMap<String, String> a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> a(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(entry.getValue().h()), entry);
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (fieldMappingDictionary.a((Class<? extends FastJsonResponse>) cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> b = fastJsonResponse.b();
        fieldMappingDictionary.a(cls, b);
        Iterator<String> it = b.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = b.get(it.next());
            Class<? extends FastJsonResponse> i = field.i();
            if (i != null) {
                try {
                    a(fieldMappingDictionary, i.newInstance());
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Could not access object of type " + field.i().getCanonicalName(), e);
                } catch (InstantiationException e2) {
                    throw new IllegalStateException("Could not instantiate an object of type " + field.i().getCanonicalName(), e2);
                }
            }
        }
    }

    private void a(StringBuilder sb, int i, Object obj) {
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
                sb.append("\"").append(zzmu.zzcz(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmk.zzi((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmk.zzj((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzmv.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        switch (field.e()) {
            case 0:
                a(sb, field, a(field, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.g(parcel, i))));
                return;
            case 1:
                a(sb, field, a(field, com.google.android.gms.common.internal.safeparcel.zza.k(parcel, i)));
                return;
            case 2:
                a(sb, field, a(field, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.i(parcel, i))));
                return;
            case 3:
                a(sb, field, a(field, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.l(parcel, i))));
                return;
            case 4:
                a(sb, field, a(field, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.n(parcel, i))));
                return;
            case 5:
                a(sb, field, a(field, com.google.android.gms.common.internal.safeparcel.zza.o(parcel, i)));
                return;
            case 6:
                a(sb, field, a(field, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.c(parcel, i))));
                return;
            case 7:
                a(sb, field, a(field, com.google.android.gms.common.internal.safeparcel.zza.p(parcel, i)));
                return;
            case 8:
            case 9:
                a(sb, field, a(field, com.google.android.gms.common.internal.safeparcel.zza.s(parcel, i)));
                return;
            case 10:
                a(sb, field, a(field, a(com.google.android.gms.common.internal.safeparcel.zza.r(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.e());
        }
    }

    private void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.d()) {
            a(sb, field, (ArrayList<?>) obj);
        } else {
            a(sb, field.c(), obj);
        }
    }

    private void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            a(sb, field.c(), arrayList.get(i));
        }
        sb.append("]");
    }

    private void a(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.k()) {
            a(sb, field, parcel, i);
        } else {
            b(sb, field, parcel, i);
        }
    }

    private void a(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> a2 = a(map);
        sb.append('{');
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a3 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            Map.Entry<String, FastJsonResponse.Field<?, ?>> entry = a2.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.a(a3)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                a(sb, entry.getKey(), entry.getValue(), parcel, a3);
                z = true;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        sb.append('}');
    }

    private static FieldMappingDictionary b(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        a(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.b();
        fieldMappingDictionary.a();
        return fieldMappingDictionary;
    }

    private void b(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        if (field.f()) {
            sb.append("[");
            switch (field.e()) {
                case 0:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.v(parcel, i));
                    break;
                case 1:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.x(parcel, i));
                    break;
                case 2:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.w(parcel, i));
                    break;
                case 3:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.y(parcel, i));
                    break;
                case 4:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.z(parcel, i));
                    break;
                case 5:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.A(parcel, i));
                    break;
                case 6:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.u(parcel, i));
                    break;
                case 7:
                    zzmj.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.B(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] F = com.google.android.gms.common.internal.safeparcel.zza.F(parcel, i);
                    int length = F.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        F[i2].setDataPosition(0);
                        a(sb, field.m(), F[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.e()) {
            case 0:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.g(parcel, i));
                return;
            case 1:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.k(parcel, i));
                return;
            case 2:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.i(parcel, i));
                return;
            case 3:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.l(parcel, i));
                return;
            case 4:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.n(parcel, i));
                return;
            case 5:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.o(parcel, i));
                return;
            case 6:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.c(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zzmu.zzcz(com.google.android.gms.common.internal.safeparcel.zza.p(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmk.zzi(com.google.android.gms.common.internal.safeparcel.zza.s(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmk.zzj(com.google.android.gms.common.internal.safeparcel.zza.s(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle r = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, i);
                Set<String> keySet = r.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzmu.zzcz(r.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel E = com.google.android.gms.common.internal.safeparcel.zza.E(parcel, i);
                E.setDataPosition(0);
                a(sb, field.m(), E);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public int a() {
        return this.f1037a;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> b() {
        if (this.d == null) {
            return null;
        }
        return this.d.a(this.e);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public Parcel e() {
        switch (this.f) {
            case 0:
                this.g = com.google.android.gms.common.internal.safeparcel.zzb.a(this.b);
                com.google.android.gms.common.internal.safeparcel.zzb.a(this.b, this.g);
                this.f = 2;
                break;
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.a(this.b, this.g);
                this.f = 2;
                break;
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMappingDictionary f() {
        switch (this.c) {
            case 0:
                return null;
            case 1:
                return this.d;
            case 2:
                return this.d;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.c);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        zzx.a(this.d, "Cannot convert to JSON on client side.");
        Parcel e = e();
        e.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.d.a(this.e), e);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.a(this, parcel, i);
    }
}
