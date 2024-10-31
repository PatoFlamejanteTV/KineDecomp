package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class VCardResultParser extends ResultParser {

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f19048e = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f19049f = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f19050g = Pattern.compile("\r\n[ \t]");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f19051h = Pattern.compile("\\\\[nN]");
    private static final Pattern i = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern j = Pattern.compile("=");
    private static final Pattern k = Pattern.compile(";");
    private static final Pattern l = Pattern.compile("(?<!\\\\);+");
    private static final Pattern m = Pattern.compile(",");
    private static final Pattern n = Pattern.compile("[;,]");
}
