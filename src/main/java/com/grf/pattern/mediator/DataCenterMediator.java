package com.grf.pattern.mediator;

import java.util.*;

/**
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/2
 */
public class DataCenterMediator implements Mediator {
    private Set<Colleague> colleagues = new HashSet<>();


    @Override
    public void register(Colleague colleague) {
        colleagues.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    public void relay(Colleague colleague) {
        colleagues.stream().filter(x->!x.equals(colleague)).forEach(Colleague::receive);
    }
}
