package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* compiled from: XMPMetaParser.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7547a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static DocumentBuilderFactory f7548b = a();

    public static com.adobe.xmp.f a(Object obj, com.adobe.xmp.b.d dVar) throws XMPException {
        g.a(obj);
        if (dVar == null) {
            dVar = new com.adobe.xmp.b.d();
        }
        Object[] a2 = a(b(obj, dVar), dVar.f(), new Object[3]);
        if (a2 != null && a2[1] == f7547a) {
            p a3 = h.a((Node) a2[0]);
            a3.a((String) a2[2]);
            if (!dVar.e()) {
                u.a(a3, dVar);
            }
            return a3;
        }
        return new p();
    }

    private static Document b(Object obj, com.adobe.xmp.b.d dVar) throws XMPException {
        if (obj instanceof InputStream) {
            return a((InputStream) obj, dVar);
        }
        if (obj instanceof byte[]) {
            return a(new b((byte[]) obj), dVar);
        }
        return a((String) obj, dVar);
    }

    private static Document a(InputStream inputStream, com.adobe.xmp.b.d dVar) throws XMPException {
        if (!dVar.c() && !dVar.d()) {
            return a(new InputSource(inputStream));
        }
        try {
            return a(new b(inputStream), dVar);
        } catch (IOException e2) {
            throw new XMPException("Error reading the XML-file", 204, e2);
        }
    }

    private static Document a(b bVar, com.adobe.xmp.b.d dVar) throws XMPException {
        try {
            return a(new InputSource(bVar.a()));
        } catch (XMPException e2) {
            if (e2.getErrorCode() != 201 && e2.getErrorCode() != 204) {
                throw e2;
            }
            if (dVar.c()) {
                bVar = f.a(bVar);
            }
            if (dVar.d()) {
                try {
                    return a(new InputSource(new d(new InputStreamReader(bVar.a(), bVar.b()))));
                } catch (UnsupportedEncodingException unused) {
                    throw new XMPException("Unsupported Encoding", 9, e2);
                }
            }
            return a(new InputSource(bVar.a()));
        }
    }

    private static Document a(String str, com.adobe.xmp.b.d dVar) throws XMPException {
        try {
            return a(new InputSource(new StringReader(str)));
        } catch (XMPException e2) {
            if (e2.getErrorCode() == 201 && dVar.d()) {
                return a(new InputSource(new d(new StringReader(str))));
            }
            throw e2;
        }
    }

    private static Document a(InputSource inputSource) throws XMPException {
        try {
            DocumentBuilder newDocumentBuilder = f7548b.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler(null);
            return newDocumentBuilder.parse(inputSource);
        } catch (IOException e2) {
            throw new XMPException("Error reading the XML-file", 204, e2);
        } catch (ParserConfigurationException e3) {
            throw new XMPException("XML Parser not correctly configured", 0, e3);
        } catch (SAXException e4) {
            throw new XMPException("XML parsing failure", 201, e4);
        }
    }

    private static Object[] a(Node node, boolean z, Object[] objArr) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (7 == item.getNodeType()) {
                ProcessingInstruction processingInstruction = (ProcessingInstruction) item;
                if ("xpacket".equals(processingInstruction.getTarget())) {
                    if (objArr != null) {
                        objArr[2] = processingInstruction.getData();
                    }
                }
            }
            if (3 != item.getNodeType() && 7 != item.getNodeType()) {
                String namespaceURI = item.getNamespaceURI();
                String localName = item.getLocalName();
                if (("xmpmeta".equals(localName) || "xapmeta".equals(localName)) && "adobe:ns:meta/".equals(namespaceURI)) {
                    return a(item, false, objArr);
                }
                if (!z && "RDF".equals(localName) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                    if (objArr != null) {
                        objArr[0] = item;
                        objArr[1] = f7547a;
                    }
                    return objArr;
                }
                Object[] a2 = a(item, z, objArr);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    private static DocumentBuilderFactory a() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setIgnoringComments(true);
        try {
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        } catch (Exception unused) {
        }
        return newInstance;
    }
}
