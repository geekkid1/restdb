package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilterService {
    @Autowired FilterRepo fr;

    public FilterData getForProduct(String product) {
        Optional<FilterData> ofd = fr.findById(product);
        if(ofd.isEmpty()) {
            FilterData ret = new FilterData(product, 'A');
            fr.save(ret);
            return ret;
        }
        return ofd.get();
    }

    public FilterData updateFilterData(FilterData fd) {
        fr.save(fd);
        return fd;
    }
}
