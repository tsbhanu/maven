package devops_project.domain.code;

import devops_project.infrastructure.code.Code;

/**
 * 
 **/
public enum GenderCd implements Code {
    男性("1"), 女性("2"),;

    private GenderCd(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return name();
    }

    @Override
    public String toString() {
        return getLabel();
    }

}
