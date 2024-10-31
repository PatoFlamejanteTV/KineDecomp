package com.nexstreaming.kinemaster.kmpackage;

import com.facebook.share.internal.ShareConstants;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMTContentHandler.java */
/* loaded from: classes.dex */
public class af implements ContentHandler {

    /* renamed from: a, reason: collision with root package name */
    private Locator f3432a;
    private int e;
    private final String g;
    private am b = null;
    private int c = 0;
    private StringBuilder d = null;
    private int[] f = new int[100];

    public af(String str) {
        this.g = str;
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.d == null) {
            this.d = new StringBuilder();
            this.e = this.c;
        }
        this.d.append(cArr, i, i2);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        String str4;
        if (this.d != null) {
            if (this.c < this.f.length) {
                str4 = this.d.substring(this.f[this.c]);
            } else {
                str4 = this.d.toString();
            }
            if (this.e == this.c) {
                this.d = null;
            }
        } else {
            str4 = null;
        }
        if (this.b != null) {
            try {
                this.b.a(str2, str4, this.c);
            } catch (KineMasterPackageException e) {
                throw new SAXParseException("Failed to parse '" + str2 + "' element (" + e.getMessage() + ")", a(), e);
            }
        }
        this.c--;
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.f3432a = locator;
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        this.c++;
        if (this.c < this.f.length) {
            if (this.d != null) {
                this.f[this.c] = this.d.length();
            } else {
                this.f[this.c] = 0;
            }
        }
        a aVar = new a(attributes);
        if (this.b == null) {
            String value = attributes.getValue("", ShareConstants.WEB_DIALOG_PARAM_ID);
            if (value == null || value.trim().length() < 1) {
                throw new SAXParseException("Root element missing ID", a());
            }
            if (str2.equalsIgnoreCase("theme")) {
                Theme b = Theme.b(this.g);
                b.b();
                this.b = b;
            } else if (str2.equalsIgnoreCase("effect")) {
                String value2 = attributes.getValue("", "type");
                if (value2 == null || value2.trim().length() < 1) {
                    this.b = new com.nexstreaming.kinemaster.kmpackage.a();
                } else if (value2.equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_TITLE)) {
                    this.b = new com.nexstreaming.kinemaster.kmpackage.a();
                } else if (value2.equalsIgnoreCase("transition")) {
                    this.b = new at();
                }
            }
        }
        if (this.b == null) {
            throw new SAXParseException("Invalid root element", a());
        }
        try {
            this.b.a(str2, aVar, this.c);
        } catch (KineMasterPackageException e) {
            throw new SAXParseException("Failed to parse '" + str2 + "' element (" + e.getMessage() + ")", a(), e);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
    }

    protected Locator a() {
        return this.f3432a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public am b() {
        return this.b;
    }

    /* compiled from: KMTContentHandler.java */
    /* loaded from: classes.dex */
    private static class a implements ae {

        /* renamed from: a, reason: collision with root package name */
        private final Attributes f3433a;

        a(Attributes attributes) {
            this.f3433a = attributes;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ae
        public String a(String str) {
            return this.f3433a.getValue("", str);
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ae
        public int a(String str, int i) {
            String a2 = a(str);
            if (a2 != null) {
                try {
                    return Integer.parseInt(a2);
                } catch (NumberFormatException e) {
                    return i;
                }
            }
            return i;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ae
        public long b(String str) {
            return a(str, 0L);
        }

        public long a(String str, long j) {
            String a2 = a(str);
            if (a2 != null) {
                try {
                    return Long.parseLong(a2);
                } catch (NumberFormatException e) {
                    return j;
                }
            }
            return j;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ae
        public String a(String str, String str2) {
            String value = this.f3433a.getValue("", str);
            return value == null ? str2 : value;
        }
    }
}
