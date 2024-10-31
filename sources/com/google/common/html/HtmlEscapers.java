package com.google.common.html;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class HtmlEscapers {

    /* renamed from: a */
    private static final Escaper f15948a = Escapers.a().a('\"', "&quot;").a('\'', "&#39;").a('&', "&amp;").a('<', "&lt;").a('>', "&gt;").a();

    private HtmlEscapers() {
    }
}
