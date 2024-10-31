package org.keyczar.experimental;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.TreeSet;
import org.keyczar.Signer;
import org.keyczar.annotations.Experimental;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

@Experimental
/* loaded from: classes3.dex */
public class UriSigner {
    private static final String DEFAULT_SIG_PARAM = "sig";
    private Signer signer;

    public UriSigner(KeyczarReader keyczarReader) throws KeyczarException {
        this.signer = new Signer(keyczarReader);
    }

    private String canonicalQuery(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        TreeSet treeSet = new TreeSet();
        if (str != null) {
            for (String str2 : str.split("&")) {
                treeSet.add(str2);
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
                stringBuffer.append('&');
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private URI canonicalUri(URI uri) throws URISyntaxException {
        if (uri == null) {
            return null;
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), canonicalQuery(uri.getQuery()), uri.getFragment());
    }

    public URI sign(URI uri) throws KeyczarException {
        return sign(uri, DEFAULT_SIG_PARAM);
    }

    public boolean verify(URI uri) throws KeyczarException {
        return verify(uri, DEFAULT_SIG_PARAM);
    }

    public URI sign(URI uri, String str) throws KeyczarException {
        try {
            URI canonicalUri = canonicalUri(uri);
            String str2 = str + "=" + this.signer.sign(canonicalUri.toASCIIString());
            String query = canonicalUri.getQuery();
            if (query != null) {
                str2 = query + "&" + str2;
            }
            try {
                return new URI(canonicalUri.getScheme(), canonicalUri.getAuthority(), canonicalUri.getPath(), str2, canonicalUri.getFragment());
            } catch (URISyntaxException e2) {
                throw new KeyczarException(e2);
            }
        } catch (URISyntaxException e3) {
            throw new KeyczarException(e3);
        }
    }

    public boolean verify(URI uri, String str) throws KeyczarException {
        String query;
        URI uri2;
        if (uri == null || (query = uri.getQuery()) == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = null;
        for (String str3 : query.split("&")) {
            if (str3.startsWith(str)) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    str2 = split[1];
                }
            } else {
                stringBuffer.append(str3);
                stringBuffer.append('&');
            }
        }
        if (str2 == null) {
            return false;
        }
        try {
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuffer.toString(), uri.getFragment());
            } else {
                uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment());
            }
            return this.signer.verify(canonicalUri(uri2).toASCIIString(), str2);
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    public UriSigner(String str) throws KeyczarException {
        this.signer = new Signer(str);
    }
}
