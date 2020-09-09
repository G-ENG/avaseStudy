package com.grf.pattern.combination;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    public Composite(String propertyA, String propertyB) {
        super(propertyA, propertyB);
    }

    private List<Component>  childNodeList = new ArrayList<>();

    public void addChildNode(Component component){
        component.setParent(this);
        childNodeList.add(component);
    }

    public List<Component> getChildNodeList(){
        return this.childNodeList;
    }
}
