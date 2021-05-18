package sg.edu.ntu.sce.sands.crypto.dcpabe;

import it.unisa.dia.gas.crypto.jpbc.signature.bls01.engines.BLS01Signer;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import sg.edu.ntu.sce.sands.crypto.dcpabe.generators.BLS01KeyPairGenerator;
import sg.edu.ntu.sce.sands.crypto.dcpabe.params.BLS01KeyGenerationParameters;
import sg.edu.ntu.sce.sands.crypto.dcpabe.params.BLS01Parameters;

public class CentralAuthority {

    private static BLS01Parameters parameters;
    private static AsymmetricCipherKeyPair keyPair;

    private CentralAuthority()
    {

    }

    private static AsymmetricCipherKeyPair keyGen() {
        final BLS01KeyPairGenerator keyGen = new BLS01KeyPairGenerator();
        keyGen.init(new BLS01KeyGenerationParameters(null, parameters));

        return keyGen.generateKeyPair();
    }

    public static void setupCA()
    {
        parameters = DCPABE.getBLSParameters();
        keyPair = keyGen();
    }

    public static byte[] sign(final String message) {
        return sign(message, keyPair.getPrivate());
    }

    private static byte[] sign(final String message, final CipherParameters privateKey) {
        final byte[] bytes = message.getBytes();

        final BLS01Signer signer = new BLS01Signer(new SHA256Digest());
        signer.init(true, privateKey);
        signer.update(bytes, 0, bytes.length);

        final byte[] signature;

        try {
            signature = signer.generateSignature();
        }
        catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        return signature;
    }

    public static boolean verify(final byte[] signature, final String message) {
        return verify(signature, message, keyPair.getPublic());
    }

    private static boolean verify(final byte[] signature, final String message, final CipherParameters publicKey) {
        final byte[] bytes = message.getBytes();

        final BLS01Signer signer = new BLS01Signer(new SHA256Digest());
        signer.init(false, publicKey);
        signer.update(bytes, 0, bytes.length);

        return signer.verifySignature(signature);
    }

}
