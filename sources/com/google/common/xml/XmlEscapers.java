package com.google.common.xml;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public class XmlEscapers {

    /* renamed from: a */
    private static final Escaper f16229a;

    /* renamed from: b */
    private static final Escaper f16230b;

    /* renamed from: c */
    private static final Escaper f16231c;

    static {
        Escapers.Builder a2 = Escapers.a();
        a2.a((char) 0, (char) 65533);
        a2.a("�");
        for (char c2 = 0; c2 <= 31; c2 = (char) (c2 + 1)) {
            if (c2 != '\t' && c2 != '\n' && c2 != '\r') {
                a2.a(c2, "�");
            }
        }
        a2.a('&', "&amp;");
        a2.a('<', "&lt;");
        a2.a('>', "&gt;");
        f16230b = a2.a();
        a2.a('\'', "&apos;");
        a2.a('\"', "&quot;");
        f16229a = a2.a();
        a2.a('\t', "&#x9;");
        a2.a('\n', "&#xA;");
        a2.a('\r', "&#xD;");
        f16231c = a2.a();
    }

    private XmlEscapers() {
    }
}
