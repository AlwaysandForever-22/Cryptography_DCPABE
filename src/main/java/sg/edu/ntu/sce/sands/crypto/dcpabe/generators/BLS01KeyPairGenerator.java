package sg.edu.ntu.sce.sands.crypto.dcpabe.generators;

import it.unisa.dia.gas.crypto.jpbc.signature.bls01.params.BLS01KeyGenerationParameters;
import it.unisa.dia.gas.crypto.jpbc.signature.bls01.params.BLS01Parameters;
import it.unisa.dia.gas.crypto.jpbc.signature.bls01.params.BLS01PrivateKeyParameters;
import it.unisa.dia.gas.crypto.jpbc.signature.bls01.params.BLS01PublicKeyParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;


/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class BLS01KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    private BLS01KeyGenerationParameters param;

    @Override
    public void init(final KeyGenerationParameters param) {
        this.param = (BLS01KeyGenerationParameters) param;
    }

    @Override
    public AsymmetricCipherKeyPair generateKeyPair() {
        final BLS01Parameters parameters = param.getParameters();

        final Pairing pairing = PairingFactory.getPairing(parameters.getParameters());
        final Element g = parameters.getG();

        // Generate the secret key
        final Element sk = pairing.getZr().newRandomElement();

        // Generate the corresponding public key
        final Element pk = g.powZn(sk);

        return new AsymmetricCipherKeyPair(
            new BLS01PublicKeyParameters(parameters, pk.getImmutable()),
            new BLS01PrivateKeyParameters(parameters, sk.getImmutable())
        );
    }
}