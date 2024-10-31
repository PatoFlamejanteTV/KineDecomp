package com.nexstreaming.kinemaster.kmpackage;

import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

/* compiled from: KMKeystore.java */
/* loaded from: classes.dex */
final class aa implements KeyczarReader {
    @Override // org.keyczar.interfaces.KeyczarReader
    public String getMetadata() throws KeyczarException {
        return "{\"name\":\"KEDL Testing\",\"purpose\":\"VERIFY\",\"type\":\"DSA_PUB\",\"versions\":[{\"exportable\":false,\"status\":\"PRIMARY\",\"versionNumber\":1},{\"exportable\":false,\"status\":\"ACTIVE\",\"versionNumber\":2},{\"exportable\":false,\"status\":\"ACTIVE\",\"versionNumber\":3}],\"encrypted\":false}";
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey(int i) throws KeyczarException {
        switch (i) {
            case 1:
                return "{\"y\":\"Uj_sZnp1zeLqdGRuVYLk-P2LLvemjyfi41aSF1UGM7QoqoGS0eocr7zDXKlG6sIukXB7k3Zo6_3lHoH50e7ubr3DEFiUaA_8bA72HFjqv4-3-qQv8MG29HO6QmHqSkBp3rS4wy8y7ZDIfl-SMc3HGeV9Vl-JqS-j6PHJDXydhSM\",\"p\":\"AP1_U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq_xfW6MPbLm1Vs14E7gB00b_JmYLdrmVClpJ-f6AR7ECLCT7up1_63xhv4O1fnxqimFQ8E-4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHH\",\"q\":\"AJdgUI8VIwvMspK5gqLrhAvwWBz1\",\"g\":\"APfhoIXWmz3ey7yrXDa4V7l5lK-7-jrqgvlXTAs9B4JnUVlXjrrUWU_mcQcQgYC0SRZxI-hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv-z0kq\",\"size\":1023}";
            case 2:
                return "{\"y\":\"MORP0TzR04TBg-dTmwhYY-cE2QEW9U-YxDpRDFoPaKg6OeejSAtlbNVpI-y5NWm6NMayI_s1GMuObE4-YD09AfOnH2zWxnt-vDuaaY9dI93ciFoipmlWbB3w4YngVZRGm8YX6MU6ar_izAvWeCFFe821bxG9q2FCjajBb3y5fVY\",\"p\":\"AP1_U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq_xfW6MPbLm1Vs14E7gB00b_JmYLdrmVClpJ-f6AR7ECLCT7up1_63xhv4O1fnxqimFQ8E-4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHH\",\"q\":\"AJdgUI8VIwvMspK5gqLrhAvwWBz1\",\"g\":\"APfhoIXWmz3ey7yrXDa4V7l5lK-7-jrqgvlXTAs9B4JnUVlXjrrUWU_mcQcQgYC0SRZxI-hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv-z0kq\",\"size\":1022}";
            case 3:
                return "{\"y\":\"cHNd9gmmPyKWt82dYcRyDhaUuIkP8zdP7GO7pl4388iMKEHEG2qiTOnpUofpmfvsAsfz7uodLihtkf1e13Bb-UKDDr4e9ZV8anAuW3naxVJ_ste9oHOBmWB2RhUMBNrxNqf6B--i7z1XrDmkMoPU_B7wQpiTMh0s1FzJmamXhWw\",\"p\":\"AP1_U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq_xfW6MPbLm1Vs14E7gB00b_JmYLdrmVClpJ-f6AR7ECLCT7up1_63xhv4O1fnxqimFQ8E-4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHH\",\"q\":\"AJdgUI8VIwvMspK5gqLrhAvwWBz1\",\"g\":\"APfhoIXWmz3ey7yrXDa4V7l5lK-7-jrqgvlXTAs9B4JnUVlXjrrUWU_mcQcQgYC0SRZxI-hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv-z0kq\",\"size\":1023}";
            default:
                return null;
        }
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey() throws KeyczarException {
        return null;
    }
}
