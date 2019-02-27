package ai.h2o.model.info;

import java.util.Objects;

public class ModelInfoAttribute {

    private String _name;
    private Object _value;

    public String getName() {
        return _name;
    }

    public Object getValue() {
        return _value;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelInfoAttribute that = (ModelInfoAttribute) o;
        return Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name);
    }

}
