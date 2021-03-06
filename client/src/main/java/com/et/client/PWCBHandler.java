package com.et.client;

import java.io.IOException;
import javax.security.auth.callback.*;
import org.apache.ws.security.WSPasswordCallback;

public class PWCBHandler
    implements CallbackHandler
{

    public PWCBHandler()
    {
    }

    public void handle(Callback callbacks[])
        throws IOException, UnsupportedCallbackException
    {
        for(int i = 0; i < callbacks.length; i++)
            if(callbacks[i] instanceof WSPasswordCallback)
            {
                WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
				pc.setIdentifier("");
                pc.setPassword("");
            } else
            {
                throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
            }

    }
}