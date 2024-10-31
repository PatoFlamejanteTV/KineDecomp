package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;

@GwtCompatible
/* loaded from: classes2.dex */
public final class UrlEscapers {

    /* renamed from: a */
    private static final Escaper f16033a = new PercentEscaper("-_.*", true);

    /* renamed from: b */
    private static final Escaper f16034b = new PercentEscaper("-._~!$'()*,;&=@:+", false);

    /* renamed from: c */
    private static final Escaper f16035c = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    private UrlEscapers() {
    }
}
