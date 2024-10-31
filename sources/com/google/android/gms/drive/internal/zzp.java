package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public final class zzp extends Metadata {

    /* renamed from: a, reason: collision with root package name */
    private final MetadataBundle f1140a;

    public zzp(MetadataBundle metadataBundle) {
        this.f1140a = metadataBundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Metadata a() {
        return new zzp(MetadataBundle.a(this.f1140a));
    }

    public String toString() {
        return "Metadata [mImpl=" + this.f1140a + "]";
    }
}
