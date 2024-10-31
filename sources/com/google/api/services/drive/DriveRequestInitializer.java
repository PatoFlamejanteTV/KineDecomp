package com.google.api.services.drive;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DriveRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public DriveRequestInitializer() {
    }

    protected void initializeDriveRequest(DriveRequest<?> driveRequest) throws IOException {
    }

    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeDriveRequest((DriveRequest) abstractGoogleJsonClientRequest);
    }

    public DriveRequestInitializer(String str) {
        super(str);
    }

    public DriveRequestInitializer(String str, String str2) {
        super(str, str2);
    }
}
