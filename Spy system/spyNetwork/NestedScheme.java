package spyNetwork;

abstract class NestedScheme implements scheme {
    private scheme Scheme;
    public NestedScheme(scheme newScheme){
        this.Scheme= newScheme;
    }

    public String encryption(String message){
        return Scheme.encryption(message);
    }
    public String decryption(String message){
        return Scheme.decryption(message);
    }
}
