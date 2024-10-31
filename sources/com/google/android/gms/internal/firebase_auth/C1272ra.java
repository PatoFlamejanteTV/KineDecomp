package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.ra */
/* loaded from: classes2.dex */
public final class C1272ra<FieldDescriptorType> extends C1269pa<FieldDescriptorType, Object> {
    public C1272ra(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.firebase_auth.C1269pa
    public final void b() {
        if (!a()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b2 = b(i);
                if (((zzfm) b2.getKey()).zzha()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzfm) entry.getKey()).zzha()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.b();
    }
}
