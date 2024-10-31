package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class zzc implements zzf<String> {
    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ String a(MetadataField metadataField) {
        return b((MetadataField<?>) metadataField);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ String a(MetadataField metadataField, Object obj) {
        return b((MetadataField<MetadataField>) metadataField, (MetadataField) obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ String a(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return b((com.google.android.gms.drive.metadata.zzb<com.google.android.gms.drive.metadata.zzb>) zzbVar, (com.google.android.gms.drive.metadata.zzb) obj);
    }

    public String b(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", metadataField.getName());
    }

    public <T> String b(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", metadataField.getName(), t);
    }

    public <T> String b(com.google.android.gms.drive.metadata.zzb<T> zzbVar, T t) {
        return String.format("contains(%s,%s)", zzbVar.getName(), t);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public <T> String a(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", operator.a(), metadataField.getName(), t);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(Operator operator, List<String> list) {
        StringBuilder sb = new StringBuilder(operator.a() + "(");
        String str = "";
        Iterator<String> it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return sb.append(")").toString();
            }
            String next = it.next();
            sb.append(str2);
            sb.append(next);
            str = ",";
        }
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(String str) {
        return String.format("not(%s)", str);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String a() {
        return "all()";
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String a2(String str) {
        return String.format("fullTextSearch(%s)", str);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String b() {
        return "ownedByMe()";
    }
}
