package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class Transaction {

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public interface Handler {
        @PublicApi
        Result a(MutableData mutableData);

        @PublicApi
        void a(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public static class Result {

        /* renamed from: a, reason: collision with root package name */
        private boolean f16647a;

        /* renamed from: b, reason: collision with root package name */
        private Node f16648b;

        public Node a() {
            return this.f16648b;
        }

        @PublicApi
        public boolean b() {
            return this.f16647a;
        }

        private Result(boolean z, Node node) {
            this.f16647a = z;
            this.f16648b = node;
        }
    }

    @PublicApi
    public static Result a() {
        return new Result(false, null);
    }
}
