package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.util.NoSuchElementException;

/* compiled from: ByteString.java */
/* renamed from: com.google.protobuf.e */
/* loaded from: classes2.dex */
public class C1651e implements ByteString.ByteIterator {

    /* renamed from: a */
    private int f18771a = 0;

    /* renamed from: b */
    private final int f18772b;

    /* renamed from: c */
    final /* synthetic */ ByteString f18773c;

    public C1651e(ByteString byteString) {
        this.f18773c = byteString;
        this.f18772b = this.f18773c.size();
    }

    public byte a() {
        try {
            ByteString byteString = this.f18773c;
            int i = this.f18771a;
            this.f18771a = i + 1;
            return byteString.byteAt(i);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f18771a < this.f18772b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public Byte next() {
        return Byte.valueOf(a());
    }
}
