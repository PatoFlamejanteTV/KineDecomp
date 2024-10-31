package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class ResultParser {

    /* renamed from: a */
    private static final ResultParser[] f19033a = {new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};

    /* renamed from: b */
    private static final Pattern f19034b = Pattern.compile("\\d+");

    /* renamed from: c */
    private static final Pattern f19035c = Pattern.compile("&");

    /* renamed from: d */
    private static final Pattern f19036d = Pattern.compile("=");
}
