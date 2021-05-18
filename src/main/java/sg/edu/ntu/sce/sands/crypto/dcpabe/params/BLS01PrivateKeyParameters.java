package sg.edu.ntu.sce.sands.crypto.dcpabe.params;

import it.unisa.dia.gas.crypto.jpbc.signature.bls01.params.BLS01KeyParameters;
import it.unisa.dia.gas.crypto.jpbc.signature.bls01.params.BLS01Parameters;
import it.unisa.dia.gas.jpbc.Element;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class BLS01PrivateKeyParameters extends BLS01KeyParameters {
    private Element sk;


    public BLS01PrivateKeyParameters(BLS01Parameters parameters, Element sk) {
        super(true, parameters);
        this.sk = sk;
    }


    public Element getSk() {
        return sk;
    }
}