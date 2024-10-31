package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import java.util.List;

/* loaded from: classes2.dex */
public interface zzf<F> {
    F a();

    F a(MetadataField<?> metadataField);

    <T> F a(MetadataField<T> metadataField, T t);

    <T> F a(com.google.android.gms.drive.metadata.zzb<T> zzbVar, T t);

    <T> F a(Operator operator, MetadataField<T> metadataField, T t);

    F a(Operator operator, List<F> list);

    F a(F f);

    F a(String str);

    F b();
}
