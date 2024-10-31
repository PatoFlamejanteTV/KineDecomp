package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractHasher.java */
@CanIgnoreReturnValue
/* loaded from: classes2.dex */
public abstract class a implements Hasher {
    @Override // com.google.common.hash.Hasher
    public Hasher a(CharSequence charSequence, Charset charset) {
        return a(charSequence.toString().getBytes(charset));
    }
}
