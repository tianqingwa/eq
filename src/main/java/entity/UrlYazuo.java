package entity;

import org.springframework.stereotype.Component;

/**
 * @author tianqinghua
 * @date 2018/12/21 10:17
 */
@Component
public class UrlYazuo {

    private String url;

    private String clientId;

    private String clientSecret;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
