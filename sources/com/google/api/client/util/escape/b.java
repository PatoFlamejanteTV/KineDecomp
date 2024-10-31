package com.google.api.client.util.escape;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
final class b extends ThreadLocal<char[]> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public char[] initialValue() {
        return new char[1024];
    }
}
