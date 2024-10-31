package com.google.firebase.database.core.utilities;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class g implements DatabaseReference.CompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f17093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TaskCompletionSource taskCompletionSource) {
        this.f17093a = taskCompletionSource;
    }

    @Override // com.google.firebase.database.DatabaseReference.CompletionListener
    public void a(DatabaseError databaseError, DatabaseReference databaseReference) {
        if (databaseError != null) {
            this.f17093a.a((Exception) databaseError.b());
        } else {
            this.f17093a.a((TaskCompletionSource) null);
        }
    }
}
