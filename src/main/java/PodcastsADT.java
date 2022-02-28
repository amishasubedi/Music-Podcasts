public interface PodcastsADT {
    public Episode play();
    public void playNext(Episode e);
    public void playLast(Episode e);
    public void playEpisode(int pos, Episode e);

    public void deleteNext();
    public void deleteLast();
    public void deleteEpisode(String title);
}
