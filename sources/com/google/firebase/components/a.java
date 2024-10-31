package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
public abstract class a implements ComponentContainer {
    @Override // com.google.firebase.components.ComponentContainer
    public <T> T a(Class<T> cls) {
        Provider<T> b2 = b(cls);
        if (b2 == null) {
            return null;
        }
        return b2.get();
    }
}
