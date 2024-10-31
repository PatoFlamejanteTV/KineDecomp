package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
class zzde extends Number implements Comparable<zzde> {
    private double zzaZG;
    private long zzaZH;
    private boolean zzaZI = false;

    private zzde(double d) {
        this.zzaZG = d;
    }

    private zzde(long j) {
        this.zzaZH = j;
    }

    public static zzde zzW(long j) {
        return new zzde(j);
    }

    public static zzde zza(Double d) {
        return new zzde(d.doubleValue());
    }

    public static zzde zzfd(String str) throws NumberFormatException {
        try {
            return new zzde(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new zzde(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) longValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return zzDN() ? this.zzaZH : this.zzaZG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzde) && compareTo((zzde) obj) == 0;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return zzDP();
    }

    @Override // java.lang.Number
    public long longValue() {
        return zzDO();
    }

    @Override // java.lang.Number
    public short shortValue() {
        return zzDQ();
    }

    public String toString() {
        return zzDN() ? Long.toString(this.zzaZH) : Double.toString(this.zzaZG);
    }

    public boolean zzDM() {
        return !zzDN();
    }

    public boolean zzDN() {
        return this.zzaZI;
    }

    public long zzDO() {
        return zzDN() ? this.zzaZH : (long) this.zzaZG;
    }

    public int zzDP() {
        return (int) longValue();
    }

    public short zzDQ() {
        return (short) longValue();
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public int compareTo(zzde zzdeVar) {
        return (zzDN() && zzdeVar.zzDN()) ? new Long(this.zzaZH).compareTo(Long.valueOf(zzdeVar.zzaZH)) : Double.compare(doubleValue(), zzdeVar.doubleValue());
    }
}
