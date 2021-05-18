package sg.edu.ntu.sce.sands.crypto.dcpabe.params;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.PairingParameters;
import org.bouncycastle.crypto.CipherParameters;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class BLS01Parameters implements CipherParameters {
    private PairingParameters parameters;
    private Element g;


    public BLS01Parameters(PairingParameters parameters, Element g) {
        this.parameters = parameters;
        this.g = g.getImmutable();
    }

    public BLS01Parameters(BLS01Parameters bls)
    {
        this.parameters = bls.getParameters();
        this.g = bls.getG();
    }


    public PairingParameters getParameters() {
        return parameters;
    }

    public Element getG() {
        return g;
    }

}