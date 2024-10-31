package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.math.BigInteger;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class BigIntegerMath {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final BigInteger f2917a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    private static final double b = Math.log(10.0d);
    private static final double c = Math.log(2.0d);

    private BigIntegerMath() {
    }
}
