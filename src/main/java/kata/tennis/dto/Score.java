package kata.tennis.dto;

import static java.util.Arrays.stream;

public enum Score {
    LOVE(0, "Love", 0), FIFTEEN(1, "Fifteen", 15), THIRTY(2, "Thirty", 30), FORTY(3, "Forty", 40);

    private final int point;
    private final String name;
    private final int value;

    Score (int point, String name, int value){
        this.point = point;
        this.name = name;
        this.value = value;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Score of (int point) {
        return stream(Score.values())
                .filter(s -> point == s.getPoint())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no %s point.", point)));
    }
}
