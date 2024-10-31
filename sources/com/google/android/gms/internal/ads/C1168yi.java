package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.yi */
/* loaded from: classes2.dex */
public final class C1168yi<FieldDescriptorType> extends C1154xi<FieldDescriptorType, Object> {
    public C1168yi(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.C1154xi
    public final void b() {
        if (!a()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b2 = b(i);
                if (((zzbqw) b2.getKey()).zzamn()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzbqw) entry.getKey()).zzamn()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.b();
    }
}
