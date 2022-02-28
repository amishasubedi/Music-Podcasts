import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PodcastsSubsetTest {
    @Test
    public void testPlay1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        Episode e = evaluator.play();
        assertEquals("The Summit", e.getTitle());
    }

    @Test
    public void testPlay2 () {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("HJ","jnhj", 8));
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("hi", "k cha", 4));
        Episode e = evaluator.play();
        assertEquals("hi", e.getTitle());

    }

    @Test
    public void testPlay3() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            Episode e = evaluator.play();
        });
    }

    @Test
    public void testPlayNext1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayNext2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        assertEquals("The Death Zone\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Summit\n",evaluator.toString());
    }

    @Test
    public void testPlayLast2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        assertEquals("The Summit\nThe Death Zone\n",evaluator.toString());
    }


    @Test
    public void testPlayEpisode1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playEpisode(1, new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisode2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(2,new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Death Zone\nThe Summit\nThe Savage Mountain\n", evaluator.toString() );
    }

    @Test
    public void testPlayEpisode3() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(3, new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Savage Mountain\nThe Death Zone\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisode4() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(1, new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Summit\nThe Savage Mountain\nThe Death Zone\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisode5() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playEpisode(2, new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playLast(new Episode("Climbing High Peaks","Mike Corey", 45));
        assertEquals("The Death Zone\nThe Savage Mountain\nThe Summit\nClimbing High Peaks\n", evaluator.toString());
    }


    @Test
    public void testPlayEpisode6() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
            evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
            evaluator.playEpisode(4, new Episode("The Summit", "Mike Corey", 46));

        });
    }


    @Test
    public void testPlayNextAndLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        assertEquals("The Summit\nThe Death Zone\n", evaluator.toString());
    }

    @Test
    public void testPlayNextAndLast2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playLast(new Episode("The Savage Mountain", "Mike Corey", 52));
        assertEquals("The Summit\nThe Death Zone\nThe Savage Mountain\n", evaluator.toString());
    }


    @Test
    public void testPlayNextAndLast4() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playNext(new Episode("Climbing High Peaks", "Mike Corey", 45));
        assertEquals("Climbing High Peaks\nThe Savage Mountain\nThe Summit\nThe Death Zone\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisodeNextAndLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(1, new Episode("The Savage Mountain", "Mike Corey", 52));
        assertEquals("The Savage Mountain\nThe Death Zone\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisodeNextAndLast2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(2, new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playNext(new Episode("Climbing High Peaks", "Mike Corey", 45));
        assertEquals("Climbing High Peaks\nThe Death Zone\nThe Savage Mountain\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testDeleteNext1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.deleteNext();
        assertEquals("", evaluator.toString());
    }

    @Test
    public void testDeleteNext2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("Climbing High Peaks", "Mike Corey", 45));
        evaluator.deleteNext();
        assertEquals("Climbing High Peaks\n", evaluator.toString());
    }

    @Test
    public void testDeleteNext3() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.deleteNext();

        });
    }

    @Test
    public void testDeleteLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.deleteLast();
        assertEquals("", evaluator.toString());
    }

    @Test
    public void testDeleteLast2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.deleteLast();
        evaluator.deleteLast();
        assertEquals("", evaluator.toString());

    }

    @Test
    public void testDeleteLast3() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playLast( new Episode("Theranos Startup", "Lindsey Graham", 53));
        evaluator.deleteLast();
        assertEquals("The Death Zone\nThe Summit\n", evaluator.toString());

    }
    @Test
    public void testDeleteEpisode1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.deleteEpisode("The Summit");
        assertEquals("", evaluator.toString());
    }

    @Test
    public void testDeleteEpisode2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.deleteEpisode("The Death Zone");
        assertEquals("The Summit\n", evaluator.toString());
    }

    @Test
    public void testDeleteEpisode3() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("a", "m", 2));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.deleteEpisode("The Death Zone");
        evaluator.deleteEpisode("a");
        evaluator.deleteEpisode("The Summit");
        assertEquals("", evaluator.toString());
    }



    @Test
    public void testDeleteEpisode4() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.deleteEpisode("The Summit");

        });
    }

    @Test
    public void testDeleteEpisode5() {
        assertThrows(NoSuchElementException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
            evaluator.deleteEpisode("Amisha");
        });

    }

}