package sg.edu.ntu.sce.sands.crypto.dcpabe.params;

import org.bouncycastle.crypto.KeyGenerationParameters;

import java.security.SecureRandom;

/**
 * @author Angelo De Caro (jpbclib@gmail.com)
 */
public class BLS01KeyGenerationParameters extends KeyGenerationParameters {

    private final sg.edu.ntu.sce.sands.crypto.dcpabe.params.BLS01Parameters params;

    public BLS01KeyGenerationParameters(final SecureRandom random, final sg.edu.ntu.sce.sands.crypto.dcpabe.params.BLS01Parameters params) {
        super(random, params.getG().getField().getLengthInBytes());

        this.params = params;
    }

    public BLS01Parameters getParameters() {
        return params;
    }

}