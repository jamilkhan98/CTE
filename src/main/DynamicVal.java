package main;

public class DynamicVal {
    private int intVal;
    private float floatVal;
    private String strVal;
    String type;

    DynamicVal(String type, String val) {
        this.type = type;
        try {
            switch (type) {
                case "INT":
                    this.intVal = Integer.parseInt(val);
                    break;
                case "FLOAT":
                    this.floatVal = Float.parseFloat(val);
                    break;
                case "STRING":
                    this.strVal = val;
                    break;
                default:
                    System.out.println("Error: Attempted to put invalid type in symbol table");
                    break;
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Exception: Attempted to put invalid type in symbol table");
        }
    }

    private DynamicVal(int val) {
        type = "INT";
        intVal = val;
    }

    private DynamicVal(float val) {
        type = "FLOAT";
        floatVal = val;
    }

    private DynamicVal(String val) {
        type = "STRING";
        strVal = val;
    }

    DynamicVal plus(DynamicVal other) {
        if(this.type.equals("INT") && other.type.equals("INT")) {
            return new DynamicVal(intVal + other.intVal);
        }
        else if(this.type.equals("FLOAT") && other.type.equals("FLOAT")) {
            return new DynamicVal(floatVal + other.floatVal);
        }
        else {
            return null;
        }
    }

    DynamicVal minus(DynamicVal other) {
        if(this.type.equals("INT") && other.type.equals("INT")) {
            return new DynamicVal(intVal - other.intVal);
        }
        else if(this.type.equals("FLOAT") && other.type.equals("FLOAT")) {
            return new DynamicVal(floatVal - other.floatVal);
        }
        else {
            return null;
        }
    }

    DynamicVal mul(DynamicVal other) {
        if(this.type.equals("INT") && other.type.equals("INT")) {
            return new DynamicVal(intVal * other.intVal);
        }
        else if(this.type.equals("FLOAT") && other.type.equals("FLOAT")) {
            return new DynamicVal(floatVal * other.floatVal);
        }
        else {
            return null;
        }
    }

    DynamicVal equals(DynamicVal other) {
        if(this.type.equals("INT") && other.type.equals("INT") && this.intVal == other.intVal) {
            return new DynamicVal(1);
        }
        else if(this.type.equals("FLOAT") && other.type.equals("FLOAT") && this.floatVal == other.floatVal) {
            return new DynamicVal(1);
        }
        else if(this.type.equals("STRING") && other.type.equals("STRING") && this.strVal.equals(other.strVal)) {
            return new DynamicVal(1);
        }
        else {
            return new DynamicVal(0);
        }
    }

    DynamicVal lessThan(DynamicVal other) {
        if(this.type.equals("INT") && other.type.equals("INT") && this.intVal < other.intVal) {
            return new DynamicVal(1);
        }
        else if(this.type.equals("FLOAT") && other.type.equals("FLOAT") && this.floatVal < other.floatVal) {
            return new DynamicVal(1);
        }
        else if(this.type.equals("STRING") && other.type.equals("STRING") && this.strVal.compareTo(other.strVal) < 0) {
            return new DynamicVal(1);
        }
        else {
            return new DynamicVal(0);
        }
    }

    DynamicVal greaterThan(DynamicVal other) {
        DynamicVal less = this.lessThan(other);
        DynamicVal equals = this.equals(other);
        if(less.intVal == 0 && equals.intVal == 0) {
            return new DynamicVal(1);
        }
        else {
            return new DynamicVal(0);
        }
    }

    DynamicVal notEqual(DynamicVal other) {
        DynamicVal equal = this.equals(other);
        if(equal.intVal == 1) {
            return new DynamicVal(0);
        }
        else {
            return new DynamicVal(1);
        }
    }

    public String toString() {
        switch (type) {
            case "INT":
                return String.valueOf(intVal);
            case "FLOAT":
                return String.valueOf(floatVal);
            case "STRING":
                return strVal;
            default:
                return "NULL";
        }
    }


}