package com.nexstreaming.kinemaster.kmpackage;

import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

/* compiled from: KMKeystore.java */
/* loaded from: classes.dex */
final class ab implements KeyczarReader {
    @Override // org.keyczar.interfaces.KeyczarReader
    public String getMetadata() throws KeyczarException {
        return "{\"name\":\"KEDL\",\"purpose\":\"VERIFY\",\"type\":\"DSA_PUB\",\"versions\":[{\"exportable\":false,\"status\":\"PRIMARY\",\"versionNumber\":1},{\"exportable\":false,\"status\":\"ACTIVE\",\"versionNumber\":2},{\"exportable\":false,\"status\":\"ACTIVE\",\"versionNumber\":3}],\"encrypted\":false}";
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey(int i) throws KeyczarException {
        switch (i) {
            case 1:
                return "{\"y\":\"ALWIKr-Dv9v39sGiuSacD4z1lStEfeUS5pO3WhWa29kG-ceH0k4RPLs4LHUITbc-1ho5LU4r4Omm0PiDgmnY8SfVk4khk7y0EYkIe-62iqxTMUUjYdh5mYBFsnquQlP3vV9a2j-3rwfc2-Y40lsUw8u84SqO6ympnL3eIL_N8dFR\",\"p\":\"AP1_U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq_xfW6MPbLm1Vs14E7gB00b_JmYLdrmVClpJ-f6AR7ECLCT7up1_63xhv4O1fnxqimFQ8E-4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHH\",\"q\":\"AJdgUI8VIwvMspK5gqLrhAvwWBz1\",\"g\":\"APfhoIXWmz3ey7yrXDa4V7l5lK-7-jrqgvlXTAs9B4JnUVlXjrrUWU_mcQcQgYC0SRZxI-hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv-z0kq\",\"size\":1024}";
            case 2:
                return "{\"y\":\"EPQj_HHVJS4cSATHAU04JCYMtJolnTbBBDnd_G_6SoExXl6399NNKYOvwK_4kzSFgIzxFUjpXdNbPYqpW8hZpeMX8dMskYyytnrly1Fus6btU5hRHx1HAITQUNf9oTno7g3cog4Yml9I4bp-j2k-yAuGpBh-aBfNMThEIE-4MPU\",\"p\":\"AP1_U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq_xfW6MPbLm1Vs14E7gB00b_JmYLdrmVClpJ-f6AR7ECLCT7up1_63xhv4O1fnxqimFQ8E-4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHH\",\"q\":\"AJdgUI8VIwvMspK5gqLrhAvwWBz1\",\"g\":\"APfhoIXWmz3ey7yrXDa4V7l5lK-7-jrqgvlXTAs9B4JnUVlXjrrUWU_mcQcQgYC0SRZxI-hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv-z0kq\",\"size\":1021}";
            case 3:
                return "{\"y\":\"DUp3c5JzOkvB02-9pW9NRwm4qVy8oCZ-zqqLawjidqwGCZMjwf2I_-xxrQ6iTMSgW9oi1R3l6xdloW7ROz189KUqINRfVKkBK0PmH7l5Za-yy54Zcq2cdmv2NehzuZl-Cta7Fd8RIJzBacUdvYQo3YaMzhlSMEellGO1mWNOlqs\",\"p\":\"AP1_U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq_xfW6MPbLm1Vs14E7gB00b_JmYLdrmVClpJ-f6AR7ECLCT7up1_63xhv4O1fnxqimFQ8E-4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHH\",\"q\":\"AJdgUI8VIwvMspK5gqLrhAvwWBz1\",\"g\":\"APfhoIXWmz3ey7yrXDa4V7l5lK-7-jrqgvlXTAs9B4JnUVlXjrrUWU_mcQcQgYC0SRZxI-hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv-z0kq\",\"size\":1020}";
            default:
                return null;
        }
    }

    @Override // org.keyczar.interfaces.KeyczarReader
    public String getKey() throws KeyczarException {
        return null;
    }
}
