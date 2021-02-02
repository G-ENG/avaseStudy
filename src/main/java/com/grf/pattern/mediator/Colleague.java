package com.grf.pattern.mediator;

/**
 * @author XYZ
 * @version 1.0.0
 * @since 2021/2/2
 */
public abstract class Colleague {
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    protected Mediator mediator;
    abstract void send();
    abstract void receive();
}
