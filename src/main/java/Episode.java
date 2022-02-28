public class Episode {
    String title;
    String host;
    int duration;

    public Episode() {
        this.title = "";
        this.host = "";
        this.duration = 0;
    }

    public Episode(String title, String host, int duration) {
        this.title = title;
        this.host = host;
        this.duration = duration;
    }

    //Getters
    public String getTitle() {

        return title;
    }
    public String getHost() {

        return host;
    }

    public int getDuration() {

        return duration;
    }


    //Setters
    public void setTitle(String title) {

        this.title = title;
    }
    public void setHost(String host) {

        this.host = host;
    }

    public void setDuration(int duration) {

        this.duration = duration;
    }

    public String toString() {
        return   this.title +  ", "  + this.host +  ", "  + this.duration;
    }


}
