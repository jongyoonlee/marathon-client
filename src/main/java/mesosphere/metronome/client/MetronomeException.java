package mesosphere.metronome.client;

import mesosphere.client.common.HttpResponseException;

public class MetronomeException extends HttpResponseException {
    protected MetronomeException(int status, String message) {
        super(status, message);
    }
}
