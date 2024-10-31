package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: SmallSortedMap.java */
/* loaded from: classes2.dex */
public class Q<FieldDescriptorType> extends U<FieldDescriptorType, Object> {
    public Q(int i) {
        super(i, null);
    }

    @Override // com.google.protobuf.U
    public void e() {
        if (!d()) {
            for (int i = 0; i < a(); i++) {
                Map.Entry<FieldDescriptorType, Object> a2 = a(i);
                if (((FieldSet.FieldDescriptorLite) a2.getKey()).v()) {
                    a2.setValue(Collections.unmodifiableList((List) a2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : c()) {
                if (((FieldSet.FieldDescriptorLite) entry.getKey()).v()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }

    @Override // com.google.protobuf.U, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.a((Q<FieldDescriptorType>) obj, (FieldSet.FieldDescriptorLite) obj2);
    }
}
