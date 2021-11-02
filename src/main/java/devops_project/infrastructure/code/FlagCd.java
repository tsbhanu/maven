package devops_project.infrastructure.code;

/**
 * この列挙型は、フラグの値を定義する{@link Code}です。
 *
 */
public enum FlagCd implements Code {
    No('0'), Yes('1');

    private char value;

    private FlagCd(char value) {
        this.value = value;
    }

    @Override
    public String getLabel() {
        return name();
    }

    @Override
    public String getValue() {
        return Character.toString(value);
    }

    public char getFlag() {
        return value;
    }

    public static char toFlag(boolean boo) {
        return boo ? Yes.getFlag() : No.getFlag();
    }

    public static boolean toBoolean(char flag) {
        return flag == Yes.getFlag();
    }

}
