package android.support.v4.provider;

import android.support.v4.util.Preconditions;
import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {

    /* renamed from: a */
    private final String f1594a;

    /* renamed from: b */
    private final String f1595b;

    /* renamed from: c */
    private final String f1596c;

    /* renamed from: d */
    private final List<List<byte[]>> f1597d;

    /* renamed from: e */
    private final int f1598e;

    /* renamed from: f */
    private final String f1599f;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        Preconditions.checkNotNull(str);
        this.f1594a = str;
        Preconditions.checkNotNull(str2);
        this.f1595b = str2;
        Preconditions.checkNotNull(str3);
        this.f1596c = str3;
        Preconditions.checkNotNull(list);
        this.f1597d = list;
        this.f1598e = 0;
        this.f1599f = this.f1594a + "-" + this.f1595b + "-" + this.f1596c;
    }

    public List<List<byte[]>> getCertificates() {
        return this.f1597d;
    }

    public int getCertificatesArrayResId() {
        return this.f1598e;
    }

    public String getIdentifier() {
        return this.f1599f;
    }

    public String getProviderAuthority() {
        return this.f1594a;
    }

    public String getProviderPackage() {
        return this.f1595b;
    }

    public String getQuery() {
        return this.f1596c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1594a + ", mProviderPackage: " + this.f1595b + ", mQuery: " + this.f1596c + ", mCertificates:");
        for (int i = 0; i < this.f1597d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1597d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1598e);
        return sb.toString();
    }

    public FontRequest(String str, String str2, String str3, int i) {
        Preconditions.checkNotNull(str);
        this.f1594a = str;
        Preconditions.checkNotNull(str2);
        this.f1595b = str2;
        Preconditions.checkNotNull(str3);
        this.f1596c = str3;
        this.f1597d = null;
        Preconditions.checkArgument(i != 0);
        this.f1598e = i;
        this.f1599f = this.f1594a + "-" + this.f1595b + "-" + this.f1596c;
    }
}
