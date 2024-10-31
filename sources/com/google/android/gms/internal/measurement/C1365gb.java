package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.gb */
/* loaded from: classes2.dex */
public final class C1365gb<FieldDescriptorType> extends C1362fb<FieldDescriptorType, Object> {
    public C1365gb(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.measurement.C1362fb
    public final void b() {
        if (!a()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b2 = b(i);
                if (((zzuh) b2.getKey()).zzwb()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzuh) entry.getKey()).zzwb()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.b();
    }
}
