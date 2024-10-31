package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.IndexedNode;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class DataSnapshot {

    /* renamed from: a */
    private final IndexedNode f16628a;

    /* renamed from: b */
    private final DatabaseReference f16629b;

    public DataSnapshot(DatabaseReference databaseReference, IndexedNode indexedNode) {
        this.f16628a = indexedNode;
        this.f16629b = databaseReference;
    }

    @PublicApi
    public DataSnapshot a(String str) {
        return new DataSnapshot(this.f16629b.a(str), IndexedNode.b(this.f16628a.e().a(new Path(str))));
    }

    @PublicApi
    public boolean b(String str) {
        if (this.f16629b.d() == null) {
            Validation.b(str);
        } else {
            Validation.a(str);
        }
        return !this.f16628a.e().a(new Path(str)).isEmpty();
    }

    @PublicApi
    public DatabaseReference c() {
        return this.f16629b;
    }

    public String toString() {
        return "DataSnapshot { key = " + this.f16629b.c() + ", value = " + this.f16628a.e().a(true) + " }";
    }

    @PublicApi
    public boolean a() {
        return !this.f16628a.e().isEmpty();
    }

    @PublicApi
    public Object a(boolean z) {
        return this.f16628a.e().a(z);
    }

    @PublicApi
    public String b() {
        return this.f16629b.c();
    }

    @PublicApi
    public <T> T a(Class<T> cls) {
        return (T) CustomClassMapper.a(this.f16628a.e().getValue(), (Class) cls);
    }
}
