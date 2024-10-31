package com.google.firebase.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.utilities.Pair;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CompoundWrite f16649a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Pair f16650b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f16651c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ DatabaseReference f16652d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DatabaseReference databaseReference, CompoundWrite compoundWrite, Pair pair, Map map) {
        this.f16652d = databaseReference;
        this.f16649a = compoundWrite;
        this.f16650b = pair;
        this.f16651c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        DatabaseReference databaseReference = this.f16652d;
        databaseReference.f16642a.a(databaseReference.a(), this.f16649a, (DatabaseReference.CompletionListener) this.f16650b.b(), this.f16651c);
    }
}
