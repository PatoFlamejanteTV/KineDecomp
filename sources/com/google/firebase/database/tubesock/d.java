package com.google.firebase.database.tubesock;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class d implements ThreadInitializer {
    @Override // com.google.firebase.database.tubesock.ThreadInitializer
    public void a(Thread thread, String str) {
        thread.setName(str);
    }
}
