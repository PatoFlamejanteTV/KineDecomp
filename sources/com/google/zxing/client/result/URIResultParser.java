package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class URIResultParser extends ResultParser {

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f19046e = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f19047f = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
}
