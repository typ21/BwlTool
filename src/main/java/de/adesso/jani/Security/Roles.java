package de.adesso.jani.Security;

public enum Roles {

    ADMIN("ADMINISTRATOR"),
    USER("USER");

    private final String ident;

    Roles(String ident){
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }
}
