package Service;


import Domain.Poster;

public class posterService {
    private int limit;

    public posterService() {
        this.limit = 5;
    }

    public posterService(int limit) {
        this.limit = limit;
    }

    private Poster[] poster = new Poster[0];

    public void addPoster(Poster item) {
        Poster[] tmp = new Poster[poster.length + 1];
        for (int i = 0; i < poster.length; i++) {
            tmp[i] = poster[i];
        }
        tmp[tmp.length - 1] = item;
        poster = tmp;
    }

    public Poster[] getItems() {

        return poster;
    }

    public Poster[] findLast() {
        int resultLength;
        if (poster.length < limit) {
            resultLength = poster.length;
        } else {
            resultLength = limit;
        }
        Poster[] tmp = new Poster[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = poster[poster.length - 1 - i];
        }
        return tmp;
    }

}
