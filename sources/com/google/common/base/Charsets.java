package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;
import org.keyczar.Keyczar;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Charsets {

    /* renamed from: a, reason: collision with root package name */
    @GwtIncompatible
    public static final Charset f2576a = Charset.forName("US-ASCII");

    @GwtIncompatible
    public static final Charset b = Charset.forName("ISO-8859-1");
    public static final Charset c = Charset.forName(Keyczar.DEFAULT_ENCODING);

    @GwtIncompatible
    public static final Charset d = Charset.forName("UTF-16BE");

    @GwtIncompatible
    public static final Charset e = Charset.forName("UTF-16LE");

    @GwtIncompatible
    public static final Charset f = Charset.forName("UTF-16");

    private Charsets() {
    }
}
