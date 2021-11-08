package com.manuelr.javaee.cdi.producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;


public class ArtistProducer {

    @Produces
    public List<String> getArtists() {
        List<String> artists = new ArrayList<>();
        artists.add("John Lennon");
        artists.add("Julian Casablancas");
        artists.add("Brandon Flowers");
        return artists;
    }

    public void dispose(@Disposes List<String> artists) {
        artists = null;
    }
}
