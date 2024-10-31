package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: XMPSchemaRegistryImpl.java */
/* loaded from: classes.dex */
public final class w implements com.adobe.xmp.j, com.adobe.xmp.a {

    /* renamed from: a */
    private Map f7565a = new HashMap();

    /* renamed from: b */
    private Map f7566b = new HashMap();

    /* renamed from: c */
    private Map f7567c = new HashMap();

    /* renamed from: d */
    private Pattern f7568d = Pattern.compile("[/*?\\[\\]]");

    public w() {
        try {
            b();
            a();
        } catch (XMPException unused) {
            throw new RuntimeException("The XMPSchemaRegistry cannot be initialized!");
        }
    }

    private void b() throws XMPException {
        a("http://www.w3.org/XML/1998/namespace", "xml");
        a("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        a("http://purl.org/dc/elements/1.1/", "dc");
        a("http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/", "Iptc4xmpCore");
        a("http://iptc.org/std/Iptc4xmpExt/2008-02-29/", "Iptc4xmpExt");
        a("http://ns.adobe.com/DICOM/", "DICOM");
        a("http://ns.useplus.org/ldf/xmp/1.0/", "plus");
        a("adobe:ns:meta/", FragmentC2201x.f23219a);
        a("http://ns.adobe.com/iX/1.0/", "iX");
        a("http://ns.adobe.com/xap/1.0/", "xmp");
        a("http://ns.adobe.com/xap/1.0/rights/", "xmpRights");
        a("http://ns.adobe.com/xap/1.0/mm/", "xmpMM");
        a("http://ns.adobe.com/xap/1.0/bj/", "xmpBJ");
        a("http://ns.adobe.com/xmp/note/", "xmpNote");
        a("http://ns.adobe.com/pdf/1.3/", "pdf");
        a("http://ns.adobe.com/pdfx/1.3/", "pdfx");
        a("http://www.npes.org/pdfx/ns/id/", "pdfxid");
        a("http://www.aiim.org/pdfa/ns/schema#", "pdfaSchema");
        a("http://www.aiim.org/pdfa/ns/property#", "pdfaProperty");
        a("http://www.aiim.org/pdfa/ns/type#", "pdfaType");
        a("http://www.aiim.org/pdfa/ns/field#", "pdfaField");
        a("http://www.aiim.org/pdfa/ns/id/", "pdfaid");
        a("http://www.aiim.org/pdfa/ns/extension/", "pdfaExtension");
        a("http://ns.adobe.com/photoshop/1.0/", "photoshop");
        a("http://ns.adobe.com/album/1.0/", "album");
        a("http://ns.adobe.com/exif/1.0/", "exif");
        a("http://cipa.jp/exif/1.0/", "exifEX");
        a("http://ns.adobe.com/exif/1.0/aux/", "aux");
        a("http://ns.adobe.com/tiff/1.0/", "tiff");
        a("http://ns.adobe.com/png/1.0/", "png");
        a("http://ns.adobe.com/jpeg/1.0/", "jpeg");
        a("http://ns.adobe.com/jp2k/1.0/", "jp2k");
        a("http://ns.adobe.com/camera-raw-settings/1.0/", "crs");
        a("http://ns.adobe.com/StockPhoto/1.0/", "bmsp");
        a("http://ns.adobe.com/creatorAtom/1.0/", "creatorAtom");
        a("http://ns.adobe.com/asf/1.0/", "asf");
        a("http://ns.adobe.com/xmp/wav/1.0/", "wav");
        a("http://ns.adobe.com/bwf/bext/1.0/", "bext");
        a("http://ns.adobe.com/riff/info/", "riffinfo");
        a("http://ns.adobe.com/xmp/1.0/Script/", "xmpScript");
        a("http://ns.adobe.com/TransformXMP/", "txmp");
        a("http://ns.adobe.com/swf/1.0/", "swf");
        a("http://ns.adobe.com/xmp/1.0/DynamicMedia/", "xmpDM");
        a("http://ns.adobe.com/xmp/transient/1.0/", "xmpx");
        a("http://ns.adobe.com/xap/1.0/t/", "xmpT");
        a("http://ns.adobe.com/xap/1.0/t/pg/", "xmpTPg");
        a("http://ns.adobe.com/xap/1.0/g/", "xmpG");
        a("http://ns.adobe.com/xap/1.0/g/img/", "xmpGImg");
        a("http://ns.adobe.com/xap/1.0/sType/Font#", "stFnt");
        a("http://ns.adobe.com/xap/1.0/sType/Dimensions#", "stDim");
        a("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "stEvt");
        a("http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "stRef");
        a("http://ns.adobe.com/xap/1.0/sType/Version#", "stVer");
        a("http://ns.adobe.com/xap/1.0/sType/Job#", "stJob");
        a("http://ns.adobe.com/xap/1.0/sType/ManifestItem#", "stMfs");
        a("http://ns.adobe.com/xmp/Identifier/qual/1.0/", "xmpidq");
    }

    @Override // com.adobe.xmp.j
    public synchronized String a(String str, String str2) throws XMPException {
        g.d(str);
        g.b(str2);
        if (str2.charAt(str2.length() - 1) != ':') {
            str2 = String.valueOf(str2) + ':';
        }
        if (k.c(str2.substring(0, str2.length() - 1))) {
            String str3 = (String) this.f7565a.get(str);
            String str4 = (String) this.f7566b.get(str2);
            if (str3 != null) {
                return str3;
            }
            if (str4 != null) {
                String str5 = str2;
                int i = 1;
                while (this.f7566b.containsKey(str5)) {
                    str5 = String.valueOf(str2.substring(0, str2.length() - 1)) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + i + "_:";
                    i++;
                }
                str2 = str5;
            }
            this.f7566b.put(str2, str);
            this.f7565a.put(str, str2);
            return str2;
        }
        throw new XMPException("The prefix is a bad XML name", 201);
    }

    @Override // com.adobe.xmp.j
    public synchronized String getNamespaceURI(String str) {
        if (str != null) {
            if (!str.endsWith(":")) {
                str = String.valueOf(str) + ":";
            }
        }
        return (String) this.f7566b.get(str);
    }

    @Override // com.adobe.xmp.j
    public synchronized String a(String str) {
        return (String) this.f7565a.get(str);
    }

    synchronized void a(String str, String str2, String str3, String str4, com.adobe.xmp.b.a aVar) throws XMPException {
        com.adobe.xmp.b.a aVar2;
        g.d(str);
        g.c(str2);
        g.d(str3);
        g.c(str4);
        if (aVar != null) {
            aVar2 = new com.adobe.xmp.b.a(t.a(aVar.f(), (Object) null).a());
        } else {
            aVar2 = new com.adobe.xmp.b.a();
        }
        com.adobe.xmp.b.a aVar3 = aVar2;
        if (!this.f7568d.matcher(str2).find() && !this.f7568d.matcher(str4).find()) {
            String a2 = a(str);
            String a3 = a(str3);
            if (a2 == null) {
                throw new XMPException("Alias namespace is not registered", 101);
            }
            if (a3 != null) {
                String str5 = String.valueOf(a2) + str2;
                if (!this.f7567c.containsKey(str5)) {
                    if (!this.f7567c.containsKey(String.valueOf(a3) + str4)) {
                        this.f7567c.put(str5, new v(this, str3, a3, str4, aVar3));
                    } else {
                        throw new XMPException("Actual property is already an alias, use the base property", 4);
                    }
                } else {
                    throw new XMPException("Alias is already existing", 4);
                }
            } else {
                throw new XMPException("Actual namespace is not registered", 101);
            }
        } else {
            throw new XMPException("Alias and actual property names must be simple", 102);
        }
    }

    private void a() throws XMPException {
        com.adobe.xmp.b.a aVar = new com.adobe.xmp.b.a();
        aVar.b(true);
        com.adobe.xmp.b.a aVar2 = new com.adobe.xmp.b.a();
        aVar2.a(true);
        a("http://ns.adobe.com/xap/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", aVar);
        a("http://ns.adobe.com/xap/1.0/", "Authors", "http://purl.org/dc/elements/1.1/", "creator", null);
        a("http://ns.adobe.com/xap/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", null);
        a("http://ns.adobe.com/xap/1.0/", "Format", "http://purl.org/dc/elements/1.1/", "format", null);
        a("http://ns.adobe.com/xap/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
        a("http://ns.adobe.com/xap/1.0/", "Locale", "http://purl.org/dc/elements/1.1/", com.umeng.commonsdk.proguard.e.M, null);
        a("http://ns.adobe.com/xap/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", null);
        a("http://ns.adobe.com/xap/1.0/rights/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", null);
        a("http://ns.adobe.com/pdf/1.3/", "Author", "http://purl.org/dc/elements/1.1/", "creator", aVar);
        a("http://ns.adobe.com/pdf/1.3/", "BaseURL", "http://ns.adobe.com/xap/1.0/", "BaseURL", null);
        a("http://ns.adobe.com/pdf/1.3/", "CreationDate", "http://ns.adobe.com/xap/1.0/", "CreateDate", null);
        a("http://ns.adobe.com/pdf/1.3/", "Creator", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
        a("http://ns.adobe.com/pdf/1.3/", "ModDate", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
        a("http://ns.adobe.com/pdf/1.3/", "Subject", "http://purl.org/dc/elements/1.1/", "description", aVar2);
        a("http://ns.adobe.com/pdf/1.3/", "Title", "http://purl.org/dc/elements/1.1/", "title", aVar2);
        a("http://ns.adobe.com/photoshop/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", aVar);
        a("http://ns.adobe.com/photoshop/1.0/", "Caption", "http://purl.org/dc/elements/1.1/", "description", aVar2);
        a("http://ns.adobe.com/photoshop/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", aVar2);
        a("http://ns.adobe.com/photoshop/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
        a("http://ns.adobe.com/photoshop/1.0/", "Marked", "http://ns.adobe.com/xap/1.0/rights/", "Marked", null);
        a("http://ns.adobe.com/photoshop/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", aVar2);
        a("http://ns.adobe.com/photoshop/1.0/", "WebStatement", "http://ns.adobe.com/xap/1.0/rights/", "WebStatement", null);
        a("http://ns.adobe.com/tiff/1.0/", "Artist", "http://purl.org/dc/elements/1.1/", "creator", aVar);
        a("http://ns.adobe.com/tiff/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", null);
        a("http://ns.adobe.com/tiff/1.0/", "DateTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
        a("http://ns.adobe.com/tiff/1.0/", "ImageDescription", "http://purl.org/dc/elements/1.1/", "description", null);
        a("http://ns.adobe.com/tiff/1.0/", "Software", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
        a("http://ns.adobe.com/png/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", aVar);
        a("http://ns.adobe.com/png/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", aVar2);
        a("http://ns.adobe.com/png/1.0/", "CreationTime", "http://ns.adobe.com/xap/1.0/", "CreateDate", null);
        a("http://ns.adobe.com/png/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", aVar2);
        a("http://ns.adobe.com/png/1.0/", "ModificationTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
        a("http://ns.adobe.com/png/1.0/", "Software", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
        a("http://ns.adobe.com/png/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", aVar2);
    }

    @Override // com.adobe.xmp.j
    public synchronized com.adobe.xmp.c.a b(String str) {
        return (com.adobe.xmp.c.a) this.f7567c.get(str);
    }
}
