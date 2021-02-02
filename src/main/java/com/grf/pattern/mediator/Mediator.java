package com.grf.pattern.mediator;

/**
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/2
 */
public interface Mediator {

    void register(Colleague colleague);
    void relay(Colleague colleague);

}
