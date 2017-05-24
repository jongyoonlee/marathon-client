package mesosphere.metronome.client;

import feign.Feign.Builder;
import feign.auth.BasicAuthRequestInterceptor;
import mesosphere.client.common.ModelUtils;
import mesosphere.marathon.client.auth.TokenAuthRequestInterceptor;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

import java.io.IOException;

import static java.util.Arrays.asList;

public class MetronomeClient {
    static class MetronomeHeaderInterceptor implements RequestInterceptor {
        @Override
        public void apply(RequestTemplate template) {
            template.header("Accept", "application/json");
            if (template.body() != null && template.body().length > 0) {
                template.header("Content-Type", "application/json");
            }
        }
    }

    static class MetronomeErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            return new MetronomeException(response.status(), response.reason());
        }
    }

    public static Metronome getInstance(String endpoint) {
        return getInstance(endpoint, null);
    }

    public static Metronome getInstance(String endpoint, RequestInterceptor... interceptors) {
        Builder b = Feign.builder()
                .encoder(new GsonEncoder(ModelUtils.GSON))
                .decoder(new GsonDecoder(ModelUtils.GSON))
                .errorDecoder(new MetronomeErrorDecoder());
        if (interceptors!=null)
            b.requestInterceptors(asList(interceptors));
        b.requestInterceptor(new MetronomeHeaderInterceptor());
        return b.target(Metronome.class, endpoint);
    }

    public static Metronome getInstanceWithBasicAuth(String endpoint, String username, String password) {
        return getInstance(endpoint,new BasicAuthRequestInterceptor(username,password));
    }

    public static Metronome getInstanceWithTokenAuth(String endpoint, String token) {
        return getInstance(endpoint, new TokenAuthRequestInterceptor(token));
    }
}
