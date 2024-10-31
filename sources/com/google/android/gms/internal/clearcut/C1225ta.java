package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.ta */
/* loaded from: classes2.dex */
public final class C1225ta<FieldDescriptorType> extends C1223sa<FieldDescriptorType, Object> {
    public C1225ta(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.clearcut.C1223sa
    public final void e() {
        if (!a()) {
            for (int i = 0; i < b(); i++) {
                Map.Entry<FieldDescriptorType, Object> b2 = b(i);
                if (((zzca) b2.getKey()).zzaw()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : c()) {
                if (((zzca) entry.getKey()).zzaw()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }
}
