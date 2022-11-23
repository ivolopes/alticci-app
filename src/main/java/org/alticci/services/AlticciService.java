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

        if (number < 0) {
            throw new AlticciException("The N param should be greater or equal to zero");
        } else {

            for (int i = 0 ; i <= number ; i++) {
                if (i < 3) {
                    sequences.add(getValideValue(i));
                } else {
                    int calc1 = getValideValue(i-3);
                    int calc2 = getValideValue(i-2);

                    if (calc1 > 2) {
                        calc1 = sequences.get(calc1);
                    }

                    if (calc2 > 2) {
                        calc2 = sequences.get(calc2);
                    }

                    int result = calc1 + calc2;
                    sequences.add(result);
                }
            }
        }

        return sequences;
    }

    private int getValideValue(int value) {
        if (value == 2) {
            return 1;
        } else {
            return value;
        }
    }

}
