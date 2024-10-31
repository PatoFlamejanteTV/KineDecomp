package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gtm.db */
/* loaded from: classes2.dex */
public final class C1300db<FieldDescriptorType> extends C1297cb<FieldDescriptorType, Object> {
    public C1300db(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.gtm.C1297cb
    public final void b() {
        if (!a()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b2 = b(i);
                if (((zzqv) b2.getKey()).zzoz()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzqv) entry.getKey()).zzoz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.b();
    }
}
