package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

/* loaded from: classes.dex */
public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> b;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.f() == null || !dataHolder.f().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.b = null;
        } else {
            this.b = new zzd<>(dataHolder, PersonEntity.CREATOR);
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Person a(int i) {
        return this.b != null ? this.b.a(i) : new zzk(this.f982a, i);
    }
}
