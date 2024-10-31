package com.google.android.gms.plus.internal.model.people;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.people.Person;

/* loaded from: classes.dex */
public final class zzk extends com.google.android.gms.common.data.zzc implements Person {
    public zzk(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String c() {
        return e("displayName");
    }

    public String d() {
        return e("personId");
    }

    public Person.Image e() {
        return new PersonEntity.ImageEntity(e("image"));
    }

    public int f() {
        return PersonEntity.zza.a(e("objectType"));
    }

    public String g() {
        return e("url");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Person a() {
        return new PersonEntity(c(), d(), (PersonEntity.ImageEntity) e(), f(), g());
    }
}
