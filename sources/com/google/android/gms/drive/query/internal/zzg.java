package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import java.util.List;

/* loaded from: classes2.dex */
public class zzg implements zzf<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f1170a = false;

    private zzg() {
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public Boolean a(Boolean bool) {
        return this.f1170a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ Boolean a(MetadataField metadataField) {
        return b((MetadataField<?>) metadataField);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ Boolean a(MetadataField metadataField, Object obj) {
        return b((MetadataField<MetadataField>) metadataField, (MetadataField) obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ Boolean a(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return b((com.google.android.gms.drive.metadata.zzb<com.google.android.gms.drive.metadata.zzb>) zzbVar, (com.google.android.gms.drive.metadata.zzb) obj);
    }

    public Boolean b(MetadataField<?> metadataField) {
        return this.f1170a;
    }

    public <T> Boolean b(MetadataField<T> metadataField, T t) {
        return this.f1170a;
    }

    public <T> Boolean b(com.google.android.gms.drive.metadata.zzb<T> zzbVar, T t) {
        return this.f1170a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public <T> Boolean a(Operator operator, MetadataField<T> metadataField, T t) {
        return this.f1170a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean a(Operator operator, List<Boolean> list) {
        return this.f1170a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean a(String str) {
        if (!str.isEmpty()) {
            this.f1170a = true;
        }
        return this.f1170a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean a() {
        return this.f1170a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        return this.f1170a;
    }
}
