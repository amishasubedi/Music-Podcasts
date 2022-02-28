public class InvalidEpisodeException extends RuntimeException{
    public InvalidEpisodeException() {
        super("Invalid episode");
    }

    public InvalidEpisodeException(String e) {
        super(e);
    }
}
