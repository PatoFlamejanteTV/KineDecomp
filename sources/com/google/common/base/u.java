package com.google.common.base;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
final class u extends ThreadLocal<char[]> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public char[] initialValue() {
        return new char[1024];
    }
}
