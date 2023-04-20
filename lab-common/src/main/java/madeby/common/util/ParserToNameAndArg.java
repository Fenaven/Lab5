package madeby.common.util;


import lombok.Getter;

@Getter
public class ParserToNameAndArg {

    private String name;
    private String arg;

    public ParserToNameAndArg(String line) {
        String[] lineSplit = line.split(" ", 2);
        this.name = lineSplit[0];
        this.arg = lineSplit.length == 2 ? lineSplit[1] : "";
    }
}
