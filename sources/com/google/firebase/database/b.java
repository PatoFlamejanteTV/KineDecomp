package com.google.firebase.database;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class b implements ValueEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ValueEventListener f16686a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Query f16687b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Query query, ValueEventListener valueEventListener) {
        this.f16687b = query;
        this.f16686a = valueEventListener;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void a(DataSnapshot dataSnapshot) {
        this.f16687b.c(this);
        this.f16686a.a(dataSnapshot);
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void a(DatabaseError databaseError) {
        this.f16686a.a(databaseError);
    }
}
