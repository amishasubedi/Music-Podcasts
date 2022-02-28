/*
 CSCI 211
 Amisha Subedi
 Student ID : 10866938
 Program 2
 In keeping with the UM Honor Code, I have neither given nor received assistance from anyone other
 than the instructor
*/

import java.util.NoSuchElementException;
import java.util.Stack;

public class Podcasts<T> implements PodcastsADT {
    Stack<Episode> player;

    // constructor
    public Podcasts() {
        player = new Stack<>();
    }


    /**
     * method: play
     * @return Episode (what is currently playing)
     */
    public Episode play() throws InvalidEpisodeException {

        if (!player.isEmpty()) {
            return player.pop();
        } else {
            throw new InvalidEpisodeException();
        }

    }


    /**
     * method: playNext
     * @param e (Episode)
     * method body:  positions this Episode to play next
     */
    public void playNext(Episode e) {
        player.push(e);
    }


    /**
     * method: playLast
     * @param e (Episode)
     * method body:  positions Episode to play last
     */
    @Override
    public void playLast(Episode e) {

        Stack <Episode> temp = new Stack<>();
        while(!player.isEmpty()) {
            temp.push(player.pop());
        }
        player.push(e);
        while (!temp.isEmpty()) {
            player.push(temp.pop());
        }
    }


    /**
     * method: playEpisode
     * @param pos (int)
     * @param e   (Episode)
     * method body:  plays the Episode at a given position in the stack
     * pos is first parameter, e is second parameter
     */
    @Override
    public void playEpisode(int pos, Episode e) {

        Stack<Episode> temp = new Stack<>();
        int index = player.size();

        // if stack is empty
        if (player.isEmpty()) {
            player.push(e);

        } else if (Math.abs(index - pos) > 1) {  // if the position is greater than players size
            throw new InvalidEpisodeException("j");

        } else if (pos == index + 1) {  // if position is at last
            playLast(e);

        } else {

            while (pos == index) {
                temp.push(player.pop());
                index--;
            }
            player.push(e);

            while (!temp.isEmpty()) {
                player.push(temp.pop());
            }
        }

    }


    /**
     * method: deleteNext
     * method body: deletes the next Episode that would play
     */
    @Override
    public void deleteNext() {

        if (player.isEmpty()) {
            throw new InvalidEpisodeException("No episode in the queue");
        }
        player.pop();
        System.out.println(player);
    }


    /**
     * method: deleteLast
     * method body:  deletes the last Episode in the stack
     */
    public void deleteLast() {

        if (player.isEmpty())
            throw new InvalidEpisodeException("No episode in the queue");
        Stack<Episode> temp = new Stack<>();
        while (!player.isEmpty()) {
            System.out.println(temp.push(player.pop()));
        }
        temp.pop();
        while (!temp.isEmpty()) {
            System.out.println(player.push(temp.pop()));
        }

    }


    /**
     * method: deleteEpisode
     * @param title
     * method body: finds and deletes the episode with this title
     */
    public void deleteEpisode(String title) {
        Stack<Episode> temp = new Stack<>();
        int count = 0;
        int n = player.size();
        if (player.isEmpty())
            throw new InvalidEpisodeException("No episodes in the queue");

            while (!player.isEmpty()) {

                Episode episode = player.pop();
                String compareTitle = episode.getTitle();

                if (!compareTitle.equals(title)) {
                    temp.push(episode);
                    count++;
                }
            }

            // element not found exception
           if (count == n) {
                throw new NoSuchElementException("Not found");
            }

            while (!temp.isEmpty()) {
                player.push(temp.pop());
            }

        }



    /**
     * method: toString
     * @return output (titles of Episodes in stack - one title per line)
     */
    public String toString() {
        String output = "";
        Episode tempEpisode;
        Stack<Episode> temp = new Stack<>();
        while (!player.isEmpty()) {
            tempEpisode = player.pop();
            output += tempEpisode.getTitle() + "\n";
            temp.push(tempEpisode);
        }
        while (!temp.isEmpty()) {
            player.push(temp.pop());
        }
        return output;

    }

}

