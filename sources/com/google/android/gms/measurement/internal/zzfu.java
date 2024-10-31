package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzya;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class zzfu extends La {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(zzfo zzfoVar) {
        super(zzfoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        com.google.android.gms.internal.measurement.zzfu a2 = a(zzftVar, str);
        if (a2 == null) {
            return null;
        }
        String str2 = a2.zzaml;
        if (str2 != null) {
            return str2;
        }
        Long l = a2.zzaxe;
        if (l != null) {
            return l;
        }
        Double d2 = a2.zzaun;
        if (d2 != null) {
            return d2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzfz zzfzVar, Object obj) {
        Preconditions.a(obj);
        zzfzVar.zzaml = null;
        zzfzVar.zzaxe = null;
        zzfzVar.zzaun = null;
        if (obj instanceof String) {
            zzfzVar.zzaml = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzfzVar.zzaxe = (Long) obj;
        } else if (obj instanceof Double) {
            zzfzVar.zzaun = (Double) obj;
        } else {
            b().q().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzfy h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ C1428m i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzq j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ zzfu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ Xa m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.La
    protected final boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] r() {
        Map<String, String> a2 = zzai.a(this.f13657b.getContext());
        if (a2 == null || a2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzai.aa.a().intValue();
        for (Map.Entry<String, String> entry : a2.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            b().t().a("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    b().t().a("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            iArr[i2] = ((Integer) obj).intValue();
            i2++;
        }
        return iArr;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b(com.google.android.gms.internal.measurement.zzfv zzfvVar) {
        com.google.android.gms.internal.measurement.zzfw[] zzfwVarArr;
        com.google.android.gms.internal.measurement.zzft[] zzftVarArr;
        String str;
        com.google.android.gms.internal.measurement.zzft[] zzftVarArr2;
        int i;
        int i2;
        String str2;
        com.google.android.gms.internal.measurement.zzfw[] zzfwVarArr2;
        String str3;
        zzfz[] zzfzVarArr;
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        com.google.android.gms.internal.measurement.zzfw[] zzfwVarArr3 = zzfvVar.zzaxf;
        if (zzfwVarArr3 != null) {
            int length = zzfwVarArr3.length;
            int i3 = 0;
            while (i3 < length) {
                com.google.android.gms.internal.measurement.zzfw zzfwVar = zzfwVarArr3[i3];
                if (zzfwVar == null || zzfwVar == null) {
                    zzfwVarArr = zzfwVarArr3;
                } else {
                    a(sb, 1);
                    sb.append("bundle {\n");
                    a(sb, 1, "protocol_version", zzfwVar.zzaxh);
                    a(sb, 1, "platform", zzfwVar.zzaxp);
                    a(sb, 1, "gmp_version", zzfwVar.zzaxt);
                    a(sb, 1, "uploading_gmp_version", zzfwVar.zzaxu);
                    a(sb, 1, "config_version", zzfwVar.zzayf);
                    a(sb, 1, "gmp_app_id", zzfwVar.zzafi);
                    a(sb, 1, "admob_app_id", zzfwVar.zzawp);
                    a(sb, 1, "app_id", zzfwVar.zztt);
                    a(sb, 1, "app_version", zzfwVar.zzts);
                    a(sb, 1, "app_version_major", zzfwVar.zzayb);
                    a(sb, 1, "firebase_instance_id", zzfwVar.zzafk);
                    a(sb, 1, "dev_cert_hash", zzfwVar.zzaxx);
                    a(sb, 1, "app_store", zzfwVar.zzafp);
                    a(sb, 1, "upload_timestamp_millis", zzfwVar.zzaxk);
                    a(sb, 1, "start_timestamp_millis", zzfwVar.zzaxl);
                    a(sb, 1, "end_timestamp_millis", zzfwVar.zzaxm);
                    a(sb, 1, "previous_bundle_start_timestamp_millis", zzfwVar.zzaxn);
                    a(sb, 1, "previous_bundle_end_timestamp_millis", zzfwVar.zzaxo);
                    a(sb, 1, "app_instance_id", zzfwVar.zzafh);
                    a(sb, 1, "resettable_device_id", zzfwVar.zzaxv);
                    a(sb, 1, "device_id", zzfwVar.zzaye);
                    a(sb, 1, "ds_id", zzfwVar.zzayh);
                    a(sb, 1, "limited_ad_tracking", zzfwVar.zzaxw);
                    a(sb, 1, com.umeng.commonsdk.proguard.e.x, zzfwVar.zzaxq);
                    a(sb, 1, "device_model", zzfwVar.zzaxr);
                    a(sb, 1, "user_default_language", zzfwVar.zzahr);
                    a(sb, 1, "time_zone_offset_minutes", zzfwVar.zzaxs);
                    a(sb, 1, "bundle_sequential_index", zzfwVar.zzaxy);
                    a(sb, 1, "service_upload", zzfwVar.zzaxz);
                    a(sb, 1, "health_monitor", zzfwVar.zzagm);
                    Long l = zzfwVar.zzayg;
                    if (l != null && l.longValue() != 0) {
                        a(sb, 1, "android_id", zzfwVar.zzayg);
                    }
                    Integer num = zzfwVar.zzayj;
                    if (num != null) {
                        a(sb, 1, "retry_counter", num);
                    }
                    zzfz[] zzfzVarArr2 = zzfwVar.zzaxj;
                    String str4 = "string_value";
                    String str5 = "name";
                    int i4 = 2;
                    if (zzfzVarArr2 != null) {
                        int length2 = zzfzVarArr2.length;
                        int i5 = 0;
                        while (i5 < length2) {
                            zzfz zzfzVar = zzfzVarArr2[i5];
                            if (zzfzVar != null) {
                                a(sb, 2);
                                sb.append("user_property {\n");
                                zzfzVarArr = zzfzVarArr2;
                                a(sb, 2, "set_timestamp_millis", zzfzVar.zzayu);
                                a(sb, 2, "name", g().c(zzfzVar.name));
                                a(sb, 2, "string_value", zzfzVar.zzaml);
                                a(sb, 2, "int_value", zzfzVar.zzaxe);
                                a(sb, 2, "double_value", zzfzVar.zzaun);
                                a(sb, 2);
                                sb.append("}\n");
                            } else {
                                zzfzVarArr = zzfzVarArr2;
                            }
                            i5++;
                            zzfzVarArr2 = zzfzVarArr;
                        }
                    }
                    zzfr[] zzfrVarArr = zzfwVar.zzaya;
                    String str6 = zzfwVar.zztt;
                    if (zzfrVarArr != null) {
                        int length3 = zzfrVarArr.length;
                        int i6 = 0;
                        while (i6 < length3) {
                            zzfr zzfrVar = zzfrVarArr[i6];
                            if (zzfrVar != null) {
                                a(sb, i4);
                                sb.append("audience_membership {\n");
                                i = i6;
                                i2 = length3;
                                a(sb, 2, "audience_id", zzfrVar.zzave);
                                a(sb, 2, "new_audience", zzfrVar.zzawv);
                                str2 = str5;
                                zzfwVarArr2 = zzfwVarArr3;
                                str3 = str4;
                                a(sb, 2, "current_data", zzfrVar.zzawt, str6);
                                a(sb, 2, "previous_data", zzfrVar.zzawu, str6);
                                a(sb, 2);
                                sb.append("}\n");
                            } else {
                                i = i6;
                                i2 = length3;
                                str2 = str5;
                                zzfwVarArr2 = zzfwVarArr3;
                                str3 = str4;
                            }
                            i6 = i + 1;
                            str4 = str3;
                            zzfwVarArr3 = zzfwVarArr2;
                            length3 = i2;
                            str5 = str2;
                            i4 = 2;
                        }
                    }
                    String str7 = str5;
                    zzfwVarArr = zzfwVarArr3;
                    int i7 = 2;
                    String str8 = str4;
                    com.google.android.gms.internal.measurement.zzft[] zzftVarArr3 = zzfwVar.zzaxi;
                    if (zzftVarArr3 != null) {
                        int length4 = zzftVarArr3.length;
                        int i8 = 0;
                        while (i8 < length4) {
                            com.google.android.gms.internal.measurement.zzft zzftVar = zzftVarArr3[i8];
                            if (zzftVar != null) {
                                a(sb, i7);
                                sb.append("event {\n");
                                str = str7;
                                a(sb, i7, str, g().a(zzftVar.name));
                                a(sb, i7, "timestamp_millis", zzftVar.zzaxb);
                                a(sb, i7, "previous_timestamp_millis", zzftVar.zzaxc);
                                a(sb, i7, "count", zzftVar.count);
                                com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr = zzftVar.zzaxa;
                                if (zzfuVarArr != null) {
                                    int length5 = zzfuVarArr.length;
                                    int i9 = 0;
                                    while (i9 < length5) {
                                        com.google.android.gms.internal.measurement.zzfu zzfuVar = zzfuVarArr[i9];
                                        if (zzfuVar != null) {
                                            a(sb, 3);
                                            sb.append("param {\n");
                                            zzftVarArr2 = zzftVarArr3;
                                            a(sb, 3, str, g().b(zzfuVar.name));
                                            a(sb, 3, str8, zzfuVar.zzaml);
                                            a(sb, 3, "int_value", zzfuVar.zzaxe);
                                            a(sb, 3, "double_value", zzfuVar.zzaun);
                                            a(sb, 3);
                                            sb.append("}\n");
                                        } else {
                                            zzftVarArr2 = zzftVarArr3;
                                        }
                                        i9++;
                                        zzftVarArr3 = zzftVarArr2;
                                        i7 = 2;
                                    }
                                }
                                zzftVarArr = zzftVarArr3;
                                a(sb, i7);
                                sb.append("}\n");
                            } else {
                                zzftVarArr = zzftVarArr3;
                                str = str7;
                            }
                            i8++;
                            str7 = str;
                            zzftVarArr3 = zzftVarArr;
                        }
                    }
                    a(sb, 1);
                    sb.append("}\n");
                }
                i3++;
                zzfwVarArr3 = zzfwVarArr;
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(com.google.android.gms.internal.measurement.zzfu zzfuVar, Object obj) {
        Preconditions.a(obj);
        zzfuVar.zzaml = null;
        zzfuVar.zzaxe = null;
        zzfuVar.zzaun = null;
        if (obj instanceof String) {
            zzfuVar.zzaml = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzfuVar.zzaxe = (Long) obj;
        } else if (obj instanceof Double) {
            zzfuVar.zzaun = (Double) obj;
        } else {
            b().q().a("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] a(com.google.android.gms.internal.measurement.zzfv zzfvVar) {
        try {
            byte[] bArr = new byte[zzfvVar.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfvVar.zza(zzk);
            zzk.zzza();
            return bArr;
        } catch (IOException e2) {
            b().q().a("Data loss. Failed to serialize batch", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.measurement.zzfu a(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzftVar.zzaxa) {
            if (zzfuVar.name.equals(str)) {
                return zzfuVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.measurement.zzfu[] a(com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, String str, Object obj) {
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzfuVarArr) {
            if (str.equals(zzfuVar.name)) {
                zzfuVar.zzaxe = null;
                zzfuVar.zzaml = null;
                zzfuVar.zzaun = null;
                if (obj instanceof Long) {
                    zzfuVar.zzaxe = (Long) obj;
                } else if (obj instanceof String) {
                    zzfuVar.zzaml = (String) obj;
                } else if (obj instanceof Double) {
                    zzfuVar.zzaun = (Double) obj;
                }
                return zzfuVarArr;
            }
        }
        com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr2 = new com.google.android.gms.internal.measurement.zzfu[zzfuVarArr.length + 1];
        System.arraycopy(zzfuVarArr, 0, zzfuVarArr2, 0, zzfuVarArr.length);
        com.google.android.gms.internal.measurement.zzfu zzfuVar2 = new com.google.android.gms.internal.measurement.zzfu();
        zzfuVar2.name = str;
        if (obj instanceof Long) {
            zzfuVar2.zzaxe = (Long) obj;
        } else if (obj instanceof String) {
            zzfuVar2.zzaml = (String) obj;
        } else if (obj instanceof Double) {
            zzfuVar2.zzaun = (Double) obj;
        }
        zzfuVarArr2[zzfuVarArr.length] = zzfuVar2;
        return zzfuVarArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(zzfj zzfjVar) {
        if (zzfjVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        a(sb, 0, "filter_id", zzfjVar.zzavk);
        a(sb, 0, "event_name", g().a(zzfjVar.zzavl));
        a(sb, 1, "event_count_filter", zzfjVar.zzavo);
        sb.append("  filters {\n");
        for (com.google.android.gms.internal.measurement.zzfk zzfkVar : zzfjVar.zzavm) {
            a(sb, 2, zzfkVar);
        }
        a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(zzfm zzfmVar) {
        if (zzfmVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        a(sb, 0, "filter_id", zzfmVar.zzavk);
        a(sb, 0, "property_name", g().c(zzfmVar.zzawa));
        a(sb, 1, zzfmVar.zzawb);
        sb.append("}\n");
        return sb.toString();
    }

    private final void a(StringBuilder sb, int i, String str, zzfx zzfxVar, String str2) {
        if (zzfxVar == null) {
            return;
        }
        a(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzfxVar.zzayo != null) {
            a(sb, 4);
            sb.append("results: ");
            long[] jArr = zzfxVar.zzayo;
            int length = jArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                Long valueOf = Long.valueOf(jArr[i2]);
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(valueOf);
                i2++;
                i3 = i4;
            }
            sb.append('\n');
        }
        if (zzfxVar.zzayn != null) {
            a(sb, 4);
            sb.append("status: ");
            long[] jArr2 = zzfxVar.zzayn;
            int length2 = jArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                Long valueOf2 = Long.valueOf(jArr2[i5]);
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(valueOf2);
                i5++;
                i6 = i7;
            }
            sb.append('\n');
        }
        if (j().j(str2)) {
            if (zzfxVar.zzayp != null) {
                a(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                zzfs[] zzfsVarArr = zzfxVar.zzayp;
                int length3 = zzfsVarArr.length;
                int i8 = 0;
                int i9 = 0;
                while (i8 < length3) {
                    zzfs zzfsVar = zzfsVarArr[i8];
                    int i10 = i9 + 1;
                    if (i9 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzfsVar.zzawx);
                    sb.append(":");
                    sb.append(zzfsVar.zzawy);
                    i8++;
                    i9 = i10;
                }
                sb.append("}\n");
            }
            if (zzfxVar.zzayq != null) {
                a(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                com.google.android.gms.internal.measurement.zzfy[] zzfyVarArr = zzfxVar.zzayq;
                int length4 = zzfyVarArr.length;
                int i11 = 0;
                int i12 = 0;
                while (i11 < length4) {
                    com.google.android.gms.internal.measurement.zzfy zzfyVar = zzfyVarArr[i11];
                    int i13 = i12 + 1;
                    if (i12 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzfyVar.zzawx);
                    sb.append(": [");
                    long[] jArr3 = zzfyVar.zzays;
                    int length5 = jArr3.length;
                    int i14 = 0;
                    int i15 = 0;
                    while (i14 < length5) {
                        long j = jArr3[i14];
                        int i16 = i15 + 1;
                        if (i15 != 0) {
                            sb.append(", ");
                        }
                        sb.append(j);
                        i14++;
                        i15 = i16;
                    }
                    sb.append("]");
                    i11++;
                    i12 = i13;
                }
                sb.append("}\n");
            }
        }
        a(sb, 3);
        sb.append("}\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] b(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            b().q().a("Failed to gzip content", e2);
            throw e2;
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    private final void a(StringBuilder sb, int i, String str, zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        a(sb, i);
        sb.append(str);
        sb.append(" {\n");
        Integer num = zzflVar.zzavu;
        if (num != null) {
            int intValue = num.intValue();
            a(sb, i, "comparison_type", intValue != 1 ? intValue != 2 ? intValue != 3 ? intValue != 4 ? "UNKNOWN_COMPARISON_TYPE" : "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN");
        }
        a(sb, i, "match_as_float", zzflVar.zzavv);
        a(sb, i, "comparison_value", zzflVar.zzavw);
        a(sb, i, "min_comparison_value", zzflVar.zzavx);
        a(sb, i, "max_comparison_value", zzflVar.zzavy);
        a(sb, i);
        sb.append("}\n");
    }

    private final void a(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzfk zzfkVar) {
        String str;
        if (zzfkVar == null) {
            return;
        }
        a(sb, i);
        sb.append("filter {\n");
        a(sb, i, "complement", zzfkVar.zzavs);
        a(sb, i, "param_name", g().b(zzfkVar.zzavt));
        int i2 = i + 1;
        zzfn zzfnVar = zzfkVar.zzavq;
        if (zzfnVar != null) {
            a(sb, i2);
            sb.append("string_filter");
            sb.append(" {\n");
            Integer num = zzfnVar.zzawc;
            if (num != null) {
                switch (num.intValue()) {
                    case 1:
                        str = "REGEXP";
                        break;
                    case 2:
                        str = "BEGINS_WITH";
                        break;
                    case 3:
                        str = "ENDS_WITH";
                        break;
                    case 4:
                        str = "PARTIAL";
                        break;
                    case 5:
                        str = "EXACT";
                        break;
                    case 6:
                        str = "IN_LIST";
                        break;
                    default:
                        str = "UNKNOWN_MATCH_TYPE";
                        break;
                }
                a(sb, i2, "match_type", str);
            }
            a(sb, i2, "expression", zzfnVar.zzawd);
            a(sb, i2, "case_sensitive", zzfnVar.zzawe);
            if (zzfnVar.zzawf.length > 0) {
                a(sb, i2 + 1);
                sb.append("expression_list {\n");
                for (String str2 : zzfnVar.zzawf) {
                    a(sb, i2 + 2);
                    sb.append(str2);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            a(sb, i2);
            sb.append("}\n");
        }
        a(sb, i2, "number_filter", zzfkVar.zzavr);
        a(sb, i);
        sb.append("}\n");
    }

    private static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        a(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            b().q().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(zzag zzagVar, zzk zzkVar) {
        Preconditions.a(zzagVar);
        Preconditions.a(zzkVar);
        if (!TextUtils.isEmpty(zzkVar.f14065b) || !TextUtils.isEmpty(zzkVar.r)) {
            return true;
        }
        zzgw();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(long[] jArr, int i) {
        if (i >= (jArr.length << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & jArr[i / 64]) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 < bitSet.length()) {
                    if (bitSet.get(i3)) {
                        jArr[i] = jArr[i] | (1 << i2);
                    }
                }
            }
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(a().a() - j) > j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] a(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            b().q().a("Failed to ungzip content", e2);
            throw e2;
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
