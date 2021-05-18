package sg.edu.ntu.sce.sands.crypto.dcpabe;

public class Attributes {
    public String attributeName;
    public String[] attributeValues;

    public Attributes(String attName, String...values)
    {
        attributeName = attName;
        attributeValues = values;
    }
}
