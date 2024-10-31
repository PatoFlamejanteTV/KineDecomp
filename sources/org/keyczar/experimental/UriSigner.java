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
/* loaded from: classes.dex */
public class UriSigner {
    private static final String DEFAULT_SIG_PARAM = "sig";
    private Signer signer;

    public UriSigner(KeyczarReader keyczarReader) throws KeyczarException {
        this.signer = new Signer(keyczarReader);
    }

    public UriSigner(String str) throws KeyczarException {
        this.signer = new Signer(str);
    }

    public URI sign(URI uri) throws KeyczarException {
        return sign(uri, DEFAULT_SIG_PARAM);
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
            } catch (URISyntaxException e) {
                throw new KeyczarException(e);
            }
        } catch (URISyntaxException e2) {
            throw new KeyczarException(e2);
        }
    }

    public boolean verify(URI uri) throws KeyczarException {
        return verify(uri, DEFAULT_SIG_PARAM);
    }

    public boolean verify(URI uri, String str) throws KeyczarException {
        String query;
        URI uri2;
        String str2;
        String str3 = null;
        if (uri != null && (query = uri.getQuery()) != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] split = query.split("&");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str4 = split[i];
                if (str4.startsWith(str)) {
                    String[] split2 = str4.split("=");
                    if (split2.length == 2) {
                        str2 = split2[1];
                        i++;
                        str3 = str2;
                    }
                } else {
                    stringBuffer.append(str4).append('&');
                }
                str2 = str3;
                i++;
                str3 = str2;
            }
            if (str3 == null) {
                return false;
            }
            try {
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuffer.toString(), uri.getFragment());
                } else {
                    uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment());
                }
                return this.signer.verify(canonicalUri(uri2).toASCIIString(), str3);
            } catch (URISyntaxException e) {
                return false;
            }
        }
        return false;
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
                stringBuffer.append((String) it.next()).append('&');
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
}
