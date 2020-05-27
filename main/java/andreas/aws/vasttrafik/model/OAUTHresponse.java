package andreas.aws.vasttrafik.model;

public class OAUTHresponse
{
        public String scope;
        public String token_type;
        public int expires_in;
        public String refresh_token;
        public String access_token;

    @Override
    public String toString() {
        return "OAUTHresponse{" +
                "scope='" + scope + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", access_token='" + access_token + '\'' +
                "}\n";
    }
}
