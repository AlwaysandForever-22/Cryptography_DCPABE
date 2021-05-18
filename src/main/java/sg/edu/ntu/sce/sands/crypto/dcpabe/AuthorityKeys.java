package sg.edu.ntu.sce.sands.crypto.dcpabe;

import com.fasterxml.jackson.annotation.JsonProperty;
import sg.edu.ntu.sce.sands.crypto.dcpabe.key.PublicKey;
import sg.edu.ntu.sce.sands.crypto.dcpabe.key.SecretKey;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class AuthorityKeys implements Serializable {
    private static final long serialVersionUID = 1L;

    public PublicKey publicAA;
    public SecretKey secretAA;
    public Map<String, AttributeValues> mapOf_AA_PK;
    public Map<String, AttributeValues> mapOf_AA_SK;


    @JsonProperty("authorityID")
    private String authorityID;

    public AuthorityKeys(String authorityID) {
        this.authorityID = authorityID;
        mapOf_AA_PK = new HashMap<>();
        mapOf_AA_SK = new HashMap<>();
    }

    private AuthorityKeys() {
    }


    public String getAuthorityID() {
        return authorityID;
    }



    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityKeys that = (AuthorityKeys) o;
        return Objects.equals(getAuthorityID(), that.getAuthorityID()) &&
                Objects.equals(getPublicKeys(), that.getPublicKeys()) &&
                Objects.equals(getSecretKeys(), that.getSecretKeys());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorityID(), getPublicKeys(), getSecretKeys());
    }*/
}
