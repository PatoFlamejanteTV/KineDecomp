package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.JsonFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudShellCredential extends GoogleCredential {
    private final int u;
    private final JsonFactory v;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
    public TokenResponse a() throws IOException {
        Socket socket = new Socket("localhost", l());
        socket.setSoTimeout(5000);
        TokenResponse tokenResponse = new TokenResponse();
        try {
            new PrintWriter(socket.getOutputStream(), true).println("2\n[]");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.readLine();
            tokenResponse.setAccessToken(((List) this.v.a((Reader) bufferedReader).a(LinkedList.class, Object.class)).get(2).toString());
            return tokenResponse;
        } finally {
            socket.close();
        }
    }

    protected int l() {
        return this.u;
    }
}
