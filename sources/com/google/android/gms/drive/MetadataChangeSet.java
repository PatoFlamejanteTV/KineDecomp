package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public final class MetadataChangeSet {

    /* renamed from: a, reason: collision with root package name */
    public static final MetadataChangeSet f1061a = new MetadataChangeSet(MetadataBundle.a());
    private final MetadataBundle b;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final MetadataBundle f1062a = MetadataBundle.a();
    }

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.b = MetadataBundle.a(metadataBundle);
    }
}
