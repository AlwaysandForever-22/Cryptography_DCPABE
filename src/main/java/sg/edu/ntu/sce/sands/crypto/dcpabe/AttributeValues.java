package sg.edu.ntu.sce.sands.crypto.dcpabe;

import sg.edu.ntu.sce.sands.crypto.dcpabe.key.SecretKey;

import java.util.HashMap;
import java.util.Map;

//Map<String, Map<String, SecretKey>>

public class AttributeValues {
    private Map<String, byte[]> mapOfKeys; //a1-> a2 -> a3 ->

    public AttributeValues()
    {

        mapOfKeys = new HashMap<>();
    }

    public void addAttributeValues(String attval, byte[] s)
    {
        mapOfKeys.put(attval, s);
    }



    public byte[] getKey(String attributeValue) {
        byte[] s = mapOfKeys.get(attributeValue);
        return s;
    }
}
