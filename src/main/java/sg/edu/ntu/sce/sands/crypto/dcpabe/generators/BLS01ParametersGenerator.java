package sg.edu.ntu.sce.sands.crypto.dcpabe.generators;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import sg.edu.ntu.sce.sands.crypto.dcpabe.params.*;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class BLS01ParametersGenerator {
    private PairingParameters parameters;
    private Pairing pairing;


    public void init(PairingParameters parameters) {
        this.parameters = parameters;
        this.pairing = PairingFactory.getPairing(parameters);
    }

    public sg.edu.ntu.sce.sands.crypto.dcpabe.params.BLS01Parameters generateParameters() {
        Element g = pairing.getG2().newRandomElement();

        return new BLS01Parameters(parameters, g.getImmutable());
    }
}
