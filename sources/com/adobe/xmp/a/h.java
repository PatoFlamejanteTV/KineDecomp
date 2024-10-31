package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: ParseRDF.java */
/* loaded from: classes.dex */
public class h implements com.adobe.xmp.d, com.adobe.xmp.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a(Node node) throws XMPException {
        p pVar = new p();
        a(pVar, node);
        return pVar;
    }

    private static boolean a(int i) {
        return 1 <= i && i <= 7;
    }

    private static void b(p pVar, s sVar, Node node, boolean z) throws XMPException {
        s a2 = a(pVar, sVar, node, null, z);
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node item = node.getAttributes().item(i);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String namespaceURI = item.getNamespaceURI();
                String localName = item.getLocalName();
                if ("xml:lang".equals(item.getNodeName())) {
                    a(a2, "xml:lang", item.getNodeValue());
                } else if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI) || (!"ID".equals(localName) && !"datatype".equals(localName))) {
                    throw new XMPException("Invalid attribute for literal property element", 202);
                }
            }
        }
        String str = "";
        for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
            Node item2 = node.getChildNodes().item(i2);
            if (item2.getNodeType() != 3) {
                throw new XMPException("Invalid child of literal property element", 202);
            }
            str = String.valueOf(str) + item2.getNodeValue();
        }
        a2.d(str);
    }

    private static boolean b(int i) {
        return 10 <= i && i <= 12;
    }

    private static void c(p pVar, s sVar, Node node, boolean z) throws XMPException {
        int b2 = b(node);
        if (b2 != 8 && b2 != 0) {
            throw new XMPException("Node element must be rdf:Description or typed node", 202);
        }
        if (z && b2 == 0) {
            throw new XMPException("Top level typed node not allowed", 203);
        }
        d(pVar, sVar, node, z);
        g(pVar, sVar, node, z);
    }

    private static void d(p pVar, s sVar, Node node, boolean z) throws XMPException {
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                int b2 = b(item);
                if (b2 == 0) {
                    a(pVar, sVar, item, item.getNodeValue(), z);
                } else {
                    if (b2 != 6 && b2 != 2 && b2 != 3) {
                        throw new XMPException("Invalid nodeElement attribute", 202);
                    }
                    if (i > 0) {
                        throw new XMPException("Mutally exclusive about, ID, nodeID attributes", 202);
                    }
                    i++;
                    if (z && b2 == 3) {
                        if (sVar.h() != null && sVar.h().length() > 0) {
                            if (!sVar.h().equals(item.getNodeValue())) {
                                throw new XMPException("Mismatched top level rdf:about values", 203);
                            }
                        } else {
                            sVar.c(item.getNodeValue());
                        }
                    }
                }
            }
        }
    }

    private static void e(p pVar, s sVar, Node node, boolean z) throws XMPException {
        s a2 = a(pVar, sVar, node, "", z);
        a2.i().j(true);
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node item = node.getAttributes().item(i);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String localName = item.getLocalName();
                String namespaceURI = item.getNamespaceURI();
                if ("xml:lang".equals(item.getNodeName())) {
                    a(a2, "xml:lang", item.getNodeValue());
                } else if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI) || (!"ID".equals(localName) && !"parseType".equals(localName))) {
                    throw new XMPException("Invalid attribute for ParseTypeResource property element", 202);
                }
            }
        }
        g(pVar, a2, node, false);
        if (a2.g()) {
            a(a2);
        }
    }

    private static void f(p pVar, s sVar, Node node, boolean z) throws XMPException {
        if (c(b(node))) {
            NamedNodeMap attributes = node.getAttributes();
            ArrayList arrayList = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                Node item = attributes.item(i);
                if ("xmlns".equals(item.getPrefix()) || (item.getPrefix() == null && "xmlns".equals(item.getNodeName()))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(item.getNodeName());
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    attributes.removeNamedItem((String) it.next());
                }
            }
            if (attributes.getLength() > 3) {
                a(pVar, sVar, node, z);
                return;
            }
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Node item2 = attributes.item(i2);
                String localName = item2.getLocalName();
                String namespaceURI = item2.getNamespaceURI();
                String nodeValue = item2.getNodeValue();
                if (!"xml:lang".equals(item2.getNodeName()) || ("ID".equals(localName) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI))) {
                    if ("datatype".equals(localName) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        b(pVar, sVar, node, z);
                        return;
                    }
                    if ("parseType".equals(localName) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        if (!"Literal".equals(nodeValue)) {
                            if ("Resource".equals(nodeValue)) {
                                e(pVar, sVar, node, z);
                                return;
                            } else {
                                if ("Collection".equals(nodeValue)) {
                                    a();
                                    throw null;
                                }
                                c();
                                throw null;
                            }
                        }
                        b();
                        throw null;
                    }
                    a(pVar, sVar, node, z);
                    return;
                }
            }
            if (node.hasChildNodes()) {
                for (int i3 = 0; i3 < node.getChildNodes().getLength(); i3++) {
                    if (node.getChildNodes().item(i3).getNodeType() != 3) {
                        h(pVar, sVar, node, z);
                        return;
                    }
                }
                b(pVar, sVar, node, z);
                return;
            }
            a(pVar, sVar, node, z);
            return;
        }
        throw new XMPException("Invalid property element name", 202);
    }

    private static void g(p pVar, s sVar, Node node, boolean z) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!c(item)) {
                if (item.getNodeType() == 1) {
                    f(pVar, sVar, item, z);
                } else {
                    throw new XMPException("Expected property element node not found", 202);
                }
            }
        }
    }

    private static void h(p pVar, s sVar, Node node, boolean z) throws XMPException {
        if (z && "iX:changes".equals(node.getNodeName())) {
            return;
        }
        s a2 = a(pVar, sVar, node, "", z);
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node item = node.getAttributes().item(i);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String localName = item.getLocalName();
                String namespaceURI = item.getNamespaceURI();
                if ("xml:lang".equals(item.getNodeName())) {
                    a(a2, "xml:lang", item.getNodeValue());
                } else if (!"ID".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                    throw new XMPException("Invalid attribute for resource property element", 202);
                }
            }
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
            Node item2 = node.getChildNodes().item(i2);
            if (!c(item2)) {
                if (item2.getNodeType() != 1 || z2) {
                    if (z2) {
                        throw new XMPException("Invalid child of resource property element", 202);
                    }
                    throw new XMPException("Children of resource property element must be XML elements", 202);
                }
                boolean equals = "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(item2.getNamespaceURI());
                String localName2 = item2.getLocalName();
                if (equals && "Bag".equals(localName2)) {
                    a2.i().a(true);
                } else if (equals && "Seq".equals(localName2)) {
                    com.adobe.xmp.b.e i3 = a2.i();
                    i3.a(true);
                    i3.d(true);
                } else if (equals && "Alt".equals(localName2)) {
                    com.adobe.xmp.b.e i4 = a2.i();
                    i4.a(true);
                    i4.d(true);
                    i4.c(true);
                } else {
                    a2.i().j(true);
                    if (!equals && !"Description".equals(localName2)) {
                        String namespaceURI2 = item2.getNamespaceURI();
                        if (namespaceURI2 != null) {
                            a(a2, "rdf:type", String.valueOf(namespaceURI2) + ':' + localName2);
                        } else {
                            throw new XMPException("All XML elements must be in a namespace", 203);
                        }
                    }
                }
                c(pVar, a2, item2, false);
                if (a2.g()) {
                    a(a2);
                } else if (a2.i().f()) {
                    t.b(a2);
                }
                z2 = true;
            }
        }
        if (!z2) {
            throw new XMPException("Missing child of resource property element", 202);
        }
    }

    static void a(p pVar, Node node) throws XMPException {
        if (node.hasAttributes()) {
            a(pVar, pVar.a(), node);
            return;
        }
        throw new XMPException("Invalid attributes of rdf:RDF element", 202);
    }

    private static void a(p pVar, s sVar, Node node) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!c(item)) {
                c(pVar, sVar, item, true);
            }
        }
    }

    private static void c() throws XMPException {
        throw new XMPException("ParseTypeOther property element not allowed", 203);
    }

    private static boolean c(Node node) {
        if (node.getNodeType() != 3) {
            return false;
        }
        String nodeValue = node.getNodeValue();
        for (int i = 0; i < nodeValue.length(); i++) {
            if (!Character.isWhitespace(nodeValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void a() throws XMPException {
        throw new XMPException("ParseTypeCollection property element not allowed", 203);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.adobe.xmp.a.p r19, com.adobe.xmp.a.s r20, org.w3c.dom.Node r21, boolean r22) throws com.adobe.xmp.XMPException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.a.h.a(com.adobe.xmp.a.p, com.adobe.xmp.a.s, org.w3c.dom.Node, boolean):void");
    }

    private static boolean c(int i) {
        if (i == 8 || b(i)) {
            return false;
        }
        return !a(i);
    }

    private static void b() throws XMPException {
        throw new XMPException("ParseTypeLiteral property element not allowed", 203);
    }

    private static int b(Node node) {
        String localName = node.getLocalName();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI == null && ((PlaceFields.ABOUT.equals(localName) || "ID".equals(localName)) && (node instanceof Attr) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(((Attr) node).getOwnerElement().getNamespaceURI()))) {
            namespaceURI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        }
        if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
            return 0;
        }
        if ("li".equals(localName)) {
            return 9;
        }
        if ("parseType".equals(localName)) {
            return 4;
        }
        if ("Description".equals(localName)) {
            return 8;
        }
        if (PlaceFields.ABOUT.equals(localName)) {
            return 3;
        }
        if ("resource".equals(localName)) {
            return 5;
        }
        if ("RDF".equals(localName)) {
            return 1;
        }
        if ("ID".equals(localName)) {
            return 2;
        }
        if ("nodeID".equals(localName)) {
            return 6;
        }
        if ("datatype".equals(localName)) {
            return 7;
        }
        if ("aboutEach".equals(localName)) {
            return 10;
        }
        if ("aboutEachPrefix".equals(localName)) {
            return 11;
        }
        return "bagID".equals(localName) ? 12 : 0;
    }

    private static s a(p pVar, s sVar, Node node, String str, boolean z) throws XMPException {
        com.adobe.xmp.j b2 = com.adobe.xmp.h.b();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI != null) {
            if ("http://purl.org/dc/1.1/".equals(namespaceURI)) {
                namespaceURI = "http://purl.org/dc/elements/1.1/";
            }
            String a2 = b2.a(namespaceURI);
            if (a2 == null) {
                a2 = b2.a(namespaceURI, node.getPrefix() != null ? node.getPrefix() : "_dflt");
            }
            String str2 = String.valueOf(a2) + node.getLocalName();
            com.adobe.xmp.b.e eVar = new com.adobe.xmp.b.e();
            boolean z2 = false;
            if (z) {
                sVar = t.a(pVar.a(), namespaceURI, "_dflt", true);
                sVar.e(false);
                if (b2.b(str2) != null) {
                    pVar.a().c(true);
                    sVar.c(true);
                    z2 = true;
                }
            }
            boolean equals = "rdf:li".equals(str2);
            boolean equals2 = "rdf:value".equals(str2);
            s sVar2 = new s(str2, str, eVar);
            sVar2.b(z2);
            if (!equals2) {
                sVar.a(sVar2);
            } else {
                sVar.a(1, sVar2);
            }
            if (equals2) {
                if (!z && sVar.i().m()) {
                    sVar.d(true);
                } else {
                    throw new XMPException("Misplaced rdf:value element", 202);
                }
            }
            if (equals) {
                if (sVar.i().d()) {
                    sVar2.c("[]");
                } else {
                    throw new XMPException("Misplaced rdf:li element", 202);
                }
            }
            return sVar2;
        }
        throw new XMPException("XML namespace required for all elements and attributes", 202);
    }

    private static s a(s sVar, String str, String str2) throws XMPException {
        if ("xml:lang".equals(str)) {
            str2 = k.d(str2);
        }
        s sVar2 = new s(str, str2, null);
        sVar.b(sVar2);
        return sVar2;
    }

    private static void a(s sVar) throws XMPException {
        s f2 = sVar.f(1);
        if (f2.i().c()) {
            if (!sVar.i().c()) {
                s g2 = f2.g(1);
                f2.e(g2);
                sVar.b(g2);
            } else {
                throw new XMPException("Redundant xml:lang for rdf:value element", 203);
            }
        }
        for (int i = 1; i <= f2.j(); i++) {
            sVar.b(f2.g(i));
        }
        for (int i2 = 2; i2 <= sVar.e(); i2++) {
            sVar.b(sVar.f(i2));
        }
        sVar.d(false);
        sVar.i().j(false);
        sVar.i().a(f2.i());
        sVar.d(f2.getValue());
        sVar.t();
        Iterator p = f2.p();
        while (p.hasNext()) {
            sVar.a((s) p.next());
        }
    }
}
