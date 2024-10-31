package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public interface ChildEventListener {
    @PublicApi
    void a(DataSnapshot dataSnapshot);

    @PublicApi
    void a(DataSnapshot dataSnapshot, String str);

    @PublicApi
    void a(DatabaseError databaseError);

    @PublicApi
    void b(DataSnapshot dataSnapshot, String str);

    @PublicApi
    void c(DataSnapshot dataSnapshot, String str);
}
