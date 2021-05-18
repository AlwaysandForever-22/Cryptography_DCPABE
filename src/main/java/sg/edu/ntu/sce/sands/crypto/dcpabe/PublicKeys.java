package sg.edu.ntu.sce.sands.crypto.dcpabe;

import com.fasterxml.jackson.annotation.JsonProperty;
import sg.edu.ntu.sce.sands.crypto.dcpabe.ac.Attribute;
import sg.edu.ntu.sce.sands.crypto.dcpabe.key.PublicKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PublicKeys {
    @JsonProperty("publicKeys")
    private Map<String, AttributeValues> publicKeys;

    public PublicKeys() {
        publicKeys = new HashMap<>();
    }

    public void subscribeAuthority(Map<String, AttributeValues> pks) {
        publicKeys.putAll(pks);
    }

    public byte[] getPK(String attributeName, String attributeValue) {

        AttributeValues av = publicKeys.get(attributeName);
       return av.getKey(attributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicKeys that = (PublicKeys) o;
        return Objects.equals(publicKeys, that.publicKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicKeys);
    }
}
