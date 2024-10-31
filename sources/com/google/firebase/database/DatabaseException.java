package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class DatabaseException extends RuntimeException {
    public DatabaseException(String str) {
        super(str);
    }

    public DatabaseException(String str, Throwable th) {
        super(str, th);
    }
}
