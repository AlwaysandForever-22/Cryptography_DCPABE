package sg.edu.ntu.sce.sands.crypto.dcpabe;

public class Main {
    public static void main(String[] args) {
        DCPABE.globalSetup(160);
        DCPABE.setBLSParameters();
        CentralAuthority.setupCA();

        byte[] signature = CentralAuthority.sign("Tushar");

        System.out.println(CentralAuthority.verify(signature, "Tushar"));
    }
}
