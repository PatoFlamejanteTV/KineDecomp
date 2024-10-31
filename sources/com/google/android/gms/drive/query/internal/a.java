package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* loaded from: classes2.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataField<?> a(MetadataBundle metadataBundle) {
        Set<MetadataField<?>> b = metadataBundle.b();
        if (b.size() != 1) {
            throw new IllegalArgumentException("bundle should have exactly 1 populated field");
        }
        return b.iterator().next();
    }
}
