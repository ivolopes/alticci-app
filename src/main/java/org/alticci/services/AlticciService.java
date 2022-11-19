package org.alticci.services;

import io.quarkus.cache.CacheResult;
import org.alticci.exceptions.AlticciException;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AlticciService {

    /**
     * It is responsible for creating the alticci sequence
     * @param number alticci index
     * @return a list with the alticci sequence
     */
    @CacheResult(cacheName = "get-sequence-cache")
    public List<Integer> get(Integer number) throws AlticciException {

        List<Integer> sequences = new ArrayList<>();
        sequences.add(0);

        if (number < 0) {
            throw new AlticciException("The N param should be greater or equal to zero");
        } else {

            for (int i = 1 ; i <= number ; i++) {
                if (i == 1 || i == 2) {
                    sequences.add(1);
                } else {
                    Integer result = (i-3) + (i-2);
                    sequences.add(result);
                }
            }
        }

        return sequences;
    }

}
