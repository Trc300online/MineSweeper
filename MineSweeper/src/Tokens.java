public enum Tokens {

    HIDDEN('#'),
    BOMB('X'),
    FLAGGED('P'),
    REVEALED('*');

    final char sign;

    Tokens (char sing){
        this.sign = sing;
    }
}
