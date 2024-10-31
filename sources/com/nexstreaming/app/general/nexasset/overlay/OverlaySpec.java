package com.nexstreaming.app.general.nexasset.overlay;

import android.util.Xml;
import com.facebook.internal.ServerProtocol;
import com.nexstreaming.app.general.util.C1702f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class OverlaySpec {

    /* renamed from: a */
    public List<b> f19577a;

    /* renamed from: b */
    public int f19578b;

    /* renamed from: c */
    public int f19579c;

    /* renamed from: d */
    public int f19580d;

    /* renamed from: e */
    public int f19581e;

    /* renamed from: f */
    public int f19582f;

    /* loaded from: classes2.dex */
    public enum AnimDirection {
        NORMAL,
        REVERSE,
        ALTERNATE,
        ALTERNATE_REVERSE
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        public String f19583a;

        /* renamed from: b */
        public boolean f19584b;

        /* renamed from: c */
        public int f19585c;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a */
        public List<a> f19586a;

        /* renamed from: b */
        public int f19587b;

        /* renamed from: c */
        public int f19588c;

        /* renamed from: d */
        public AnimDirection f19589d;
    }

    public static OverlaySpec a(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            return c(newPullParser);
        } finally {
            C1702f.a(inputStream);
        }
    }

    private static b b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "layer");
        b bVar = new b();
        bVar.f19587b = a(xmlPullParser.getAttributeValue(null, "iteration-count"), -1);
        String attributeValue = xmlPullParser.getAttributeValue(null, "direction");
        if (attributeValue != null) {
            if ("normal".equalsIgnoreCase(attributeValue)) {
                bVar.f19589d = AnimDirection.NORMAL;
            } else if ("reverse".equalsIgnoreCase(attributeValue)) {
                bVar.f19589d = AnimDirection.REVERSE;
            } else if ("alternate".equalsIgnoreCase(attributeValue)) {
                bVar.f19589d = AnimDirection.ALTERNATE;
            } else if ("alternate-reverse".equalsIgnoreCase(attributeValue)) {
                bVar.f19589d = AnimDirection.ALTERNATE_REVERSE;
            } else {
                throw new XmlPullParserException("Unrecognized direction: " + attributeValue, xmlPullParser, null);
            }
        }
        bVar.f19586a = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equalsIgnoreCase("frame")) {
                    a a2 = a(xmlPullParser);
                    if (a2 != null) {
                        bVar.f19586a.add(a2);
                        bVar.f19588c += a2.f19585c;
                    }
                } else {
                    d(xmlPullParser);
                }
            }
        }
        return bVar;
    }

    private static OverlaySpec c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "overlay");
        OverlaySpec overlaySpec = new OverlaySpec();
        overlaySpec.f19578b = a(xmlPullParser.getAttributeValue(null, "width"), -1);
        overlaySpec.f19579c = a(xmlPullParser.getAttributeValue(null, "height"), -1);
        overlaySpec.f19580d = a(xmlPullParser.getAttributeValue(null, "fps"), 15);
        overlaySpec.f19581e = a(xmlPullParser.getAttributeValue(null, "min-fps"), overlaySpec.f19580d);
        overlaySpec.f19582f = a(xmlPullParser.getAttributeValue(null, "duration"), -1);
        overlaySpec.f19577a = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equalsIgnoreCase("layer")) {
                    b b2 = b(xmlPullParser);
                    if (b2 != null) {
                        overlaySpec.f19577a.add(b2);
                    }
                } else {
                    d(xmlPullParser);
                }
            }
        }
        return overlaySpec;
    }

    private static void d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static a a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "frame");
        a aVar = new a();
        aVar.f19583a = xmlPullParser.getAttributeValue(null, "src");
        aVar.f19584b = a(xmlPullParser.getAttributeValue(null, "blank"), false);
        aVar.f19585c = Math.max(1, a(xmlPullParser.getAttributeValue(null, "hold"), 1));
        d(xmlPullParser);
        return aVar;
    }

    private static int a(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static boolean a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        if (str.equalsIgnoreCase("false")) {
            return false;
        }
        return z;
    }
}
