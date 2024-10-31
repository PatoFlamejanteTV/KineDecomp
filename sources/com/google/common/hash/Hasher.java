package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@Beta
/* loaded from: classes2.dex */
public interface Hasher extends PrimitiveSink {
    HashCode a();

    Hasher a(byte b2);

    Hasher a(int i);

    Hasher a(long j);

    Hasher a(CharSequence charSequence);

    Hasher a(CharSequence charSequence, Charset charset);

    <T> Hasher a(T t, Funnel<? super T> funnel);

    Hasher a(byte[] bArr);

    Hasher a(byte[] bArr, int i, int i2);
}
