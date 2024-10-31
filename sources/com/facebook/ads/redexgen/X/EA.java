package com.facebook.ads.redexgen.X;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class EA extends AbstractC0351Dr<C0258Ac> {
    public EA(long j, @Nullable E7 e7, C0258Ac c0258Ac) {
        super(j, e7, c0258Ac, E8.A0D);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final int A06() {
        return A07().A09();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        return A07().A0A(jSONObject);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.biometric.model.TouchSignalRawValue> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final boolean A0A(AbstractC0351Dr<C0258Ac> abstractC0351Dr) {
        return A07().A0B(abstractC0351Dr.A07());
    }
}
