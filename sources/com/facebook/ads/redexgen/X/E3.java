package com.facebook.ads.redexgen.X;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class E3 extends AbstractC0351Dr<C0256Aa> {
    public E3(long j, @Nullable E7 e7, C0256Aa c0256Aa) {
        super(j, e7, c0256Aa, E8.A0B);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final int A06() {
        return A07().A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        return A07().A04(jSONObject);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.biometric.model.SensorSignalRawValue> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final boolean A0A(AbstractC0351Dr<C0256Aa> abstractC0351Dr) {
        return A07().A05(abstractC0351Dr.A07());
    }
}
